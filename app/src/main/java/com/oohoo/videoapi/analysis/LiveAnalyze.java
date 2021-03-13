package com.oohoo.videoapi.analysis;

import android.util.Log;

import com.oohoo.videoapi.util.Tools;
import com.oohoo.videoapi.util.AnalysisUtils;
import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class LiveAnalyze extends BaseAnalyze {

    private final String TAG = "LiveAnalyze";

    private final String HOME_URL = "https://i.rcuts.com/update/938";

    public LiveAnalyze(){
        title = "直播";
        isLive = true;
        showSearch = false;
    }

    @Override
    public List<NetVideo> getVideoListByHome(){
        String retStr = AnalysisUtils.sendDataByGet(HOME_URL,"Android");
        List<NetVideo> list =  new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(retStr);
            String baseUrl = jsonObject.getString("url");
            JSONArray bigTypes = (JSONArray) jsonObject.getJSONArray("list");
            int c = 1;
            for (int i = 0; i < bigTypes.length(); i++){
                try {
                    String bigType = bigTypes.getString(i);
                    JSONArray middleTypes = (JSONArray) jsonObject.getJSONArray(bigType);
                    for (int j = 0; j < middleTypes.length(); j++){
                        try {
                            String tvTitle = middleTypes.getString(j);
                            boolean isHD = tvTitle.endsWith("高清");
                            String tvUrl = jsonObject.getString(tvTitle);
                            String num = tvTitle.substring(0, 2);
                            if(tvTitle.trim().startsWith("CCTV")){
                                num = Tools.getStrWithRegular("([\\d]+)",tvTitle);
                            }else {
                                if(AnalysisUtils.areaAbb.containsKey(num)){
                                    num = AnalysisUtils.areaAbb.get(num);
                                }else {
                                    num = num.substring(0, 1);
                                }
                            }
                            List<VideoUrlItem> vList = new ArrayList<>();
                            vList.add(new VideoUrlItem(isHD ? "HD" : "SD", baseUrl+tvUrl));
                            NetVideo nv = new NetVideo(tvTitle,isHD ? "HD" : "SD","",vList,num);
                            list.add(nv);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            Log.e(TAG, e.getMessage());
        }
        if(list.isEmpty()){
            list.add(new NetVideo("CCTV1","高清","http://download.easyicon.net/png/518254/77/","http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8","1"));
            list.add(new NetVideo("CCTV3","高清","http://download.easyicon.net/png/518256/77/","http://ivi.bupt.edu.cn/hls/cctv3hd.m3u8","2"));
            list.add(new NetVideo("CCTV5","高清","http://download.easyicon.net/png/518258/77/","http://ivi.bupt.edu.cn/hls/cctv5hd.m3u8","3"));
            list.add(new NetVideo("CCTV5+","高清","http://download.easyicon.net/png/518258/77/","http://ivi.bupt.edu.cn/hls/cctv5phd.m3u8","4"));
            list.add(new NetVideo("CCTV6","高清","http://download.easyicon.net/png/518259/77/","http://ivi.bupt.edu.cn/hls/cctv6hd.m3u8","5"));
            list.add(new NetVideo("CCTV9","标清","http://download.easyicon.net/png/518259/77/","http://223.82.250.72/ysten-business/live/cctv-news/1.m3u8","6"));
            list.add(new NetVideo("香港卫视","高清","http://www.hkstv.tv/templates/site_shared/assets/img/blogo.png","http://live.hkstv.hk.lxdns.com/live/hks/playlist.m3u8","6"));
        }
        return list;
    }

    @Override
    public List<VideoUrlItem> getVideoUrlList(NetVideo nv) {
        List<VideoUrlItem> result = new ArrayList<>();
        result.add(new VideoUrlItem(nv.getInfo(), nv.getExtraUrl()));
        return result;
    }

    @Override
    public List<NetVideo> getVideoListBySearch(String searchKey) {
        return null;
    }
}
