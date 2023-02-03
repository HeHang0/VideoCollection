package com.oohoo.videoapi.analysis;

import android.os.Build;
import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.oohoo.videoapi.util.AnalysisUtils;
import com.oohoo.videoapi.util.Tools;
import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;


public class LiveAnalyze extends BaseAnalyze {

    private final String TAG = "LiveAnalyze";

    private final String HOME_URL = "https://i.rcuts.com/update/938";

//    private final String STREAM_URL = "https://iptv-org.github.io/api/streams.json";

    private final String STREAM_URL = "https://raw.fastgit.org/iptv-org/iptv/master/streams/cn.m3u";

    private final String STREAM_URL_CCTV = "https://raw.fastgit.org/iptv-org/iptv/master/streams/cn_cctv.m3u";

    private final String Channel_URL = "https://iptv-org.github.io/api/channels.json";

    private List<NetVideo> allVideos = null;

    public LiveAnalyze(){
        title = "直播";
        isLive = true;
        showSearch = true;
    }

    @Override
    public List<NetVideo> getVideoListBySearch(String searchKey) {
        searchKey = searchKey.toLowerCase();
        if(allVideos != null && !searchKey.isEmpty()) {
            List<NetVideo> result = new ArrayList<>();
            for (int i = 0; i < allVideos.size(); i++) {
                if(allVideos.get(i).getTitle().toLowerCase().contains(searchKey)){
                    result.add(allVideos.get(i));
                }
            }
            return result;
        }else if(allVideos != null) {
            return allVideos;
        }
        return null;
    }

    @Override
    public List<NetVideo> getVideoListByHome(){
        List<NetVideo> result = getVideoListStreamUrl(STREAM_URL_CCTV);
//        Collections.sort(result);
        result.addAll(getVideoListStreamUrl(STREAM_URL));
        allVideos = result;
        return result;
    }

    private List<NetVideo> getVideoListStreamUrl(String streamUrl){
        Log.i(TAG, "准备获取stream");
        String retStr = AnalysisUtils.sendDataByGet(streamUrl,"Android");
        Log.i(TAG, "获取到了stream");
        String[] m3UList = retStr.split("\n");
        String name = "";
        List<NetVideo> list =  new ArrayList<>();
        Map<String, List<VideoUrlItem>> streamMap = new HashMap<>();
        List<String> keyList = new ArrayList<>();
        for (String line : m3UList) {
            if (line.contains(" status=\"online\"")) {
                name = Tools.getStrWithRegular("status=\"online\",([\\S\\s]+)", line);
            } else if (!line.startsWith("http")) {
                name = "";
            }
            if (!name.isEmpty() && line.startsWith("http")) {
                String nameKey = Tools.getStrWithRegular("([^\\(^\\(]+)", name);
                if(!streamMap.containsKey(nameKey)) {
                    streamMap.put(nameKey, new ArrayList<>());
                    keyList.add(nameKey);
                }
                Objects.requireNonNull(streamMap.get(nameKey)).add(new VideoUrlItem(name, line));
            }
        }

        for (String nameKey: keyList) {
            List<VideoUrlItem> streams = streamMap.get(nameKey);
            if(streams == null || streams.size() <= 0) continue;
            String imgUrl = findImage(nameKey);
            if(imgUrl == null || imgUrl.isEmpty()){
                imgUrl = findImage(nameKey.substring(0, 2));
            }
            if(imgUrl == null)imgUrl = "";
            NetVideo nv = new NetVideo(nameKey, "", imgUrl, streams, nameKey.substring(0, 1));
            list.add(nv);
        }
        return list;
    }

    private String findImage(String name) {
        for (int i = 0; i < LiveConst.ImageList.size(); i++) {
            if(name.contains(LiveConst.ImageList.get(i).get(1))) {
                return LiveConst.ImageList.get(i).get(0);
            }
        }
        return "";
    }

    private Map<String, String> getChannelMap() {
        Log.i(TAG, "准备获取channel");
//        String retStr = AnalysisUtils.sendDataByGet(Channel_URL,"Android");
        Map<String, String> channelMap = new HashMap<>();
        try {
            JSONArray jsonArray = JSON.parseArray(LiveConst.Channel);
            Log.i(TAG, "获取到channel json: " + jsonArray.size());
            for (int i = 0; i < jsonArray.size(); i++){
                try {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    String channel = jo.getString("id");
                    if(channel == null || !channel.endsWith(".cn")) continue;
                    if(!channelMap.containsKey(channel)) {
                        String name = jo.getString("native_name");
                        if(name == null) name = jo.getString("name");
                        channelMap.put(name.replaceAll(" ", "").toLowerCase(), jo.getString("logo"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage());
        }
        Log.i(TAG, "获取到channel map: " + channelMap.size());
        return channelMap;
    }

    @Override
    public List<VideoUrlItem> getVideoUrlList(NetVideo nv) {
        List<VideoUrlItem> result = new ArrayList<>();
        result.add(new VideoUrlItem(nv.getInfo(), nv.getExtraUrl()));
        return result;
    }
}
