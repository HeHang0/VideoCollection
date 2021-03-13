package com.oohoo.videoapi.analysis;

import android.util.Log;

import com.oohoo.videoapi.util.AnalysisUtils;
import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.oohoo.videoapi.util.AnalysisUtils.VideoUrlType;


public class CloudMusicAnalyze extends BaseAnalyze {

    private final String TAG = "CloudMusicAnalyze";
    private  String HomeUrl = "http://music.163.com/api/cloudsearch/get/web?s=jfla&limit=50&type=1014&offset=0";
    private  String HomeUrl2;
    private final  String SEARCH_URL = "http://music.163.com/api/cloudsearch/get/web?s=%s&limit=50&type=1014&offset=0";
    private final  String VIDEO_URL = "http://music.163.com/api/mv/detail?id=%s&type=mp4";

    public CloudMusicAnalyze(){
        title = "云音乐";
        HomeUrl2 = getApiByCloudVideoTopList();
    }

    private List<NetVideo> getVideoListByHome(String homeUrl){
        String retStr = AnalysisUtils.sendDataByPost(homeUrl);
        List<NetVideo> list =  new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(retStr).getJSONObject("data");
            JSONArray videos = (JSONArray) jsonObject.get("chart");
            for (int i = 0; i < videos.length(); i++){
                try {
                    JSONObject video = videos.getJSONObject(i);
                    String title = video.getString("name");
                    String info = video.getString("publishTime");
                    String imgUrl = video.getString("cover");
                    String videoInfo = video.getString("resId");
                    NetVideo nv = new NetVideo(title,info,imgUrl,videoInfo,""+(i+1));
                    list.add(nv);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<NetVideo> getVideoListByHome(){
        List<NetVideo> list = getVideoListByHome(HomeUrl2);
        if(list.size() == 0) list = getVideoListByHome(HomeUrl);
        return list;
    }

    public List<NetVideo> getVideoListBySearch(String searchKey){
        try {
            String retStr = AnalysisUtils.sendDataByPost(
                    String.format(SEARCH_URL, URLEncoder.encode(searchKey, "utf-8")));
            return getList(retStr);
        }catch (Exception e){
            Log.e(TAG, e.getMessage());
        }
        return null;
    }

    private static List<NetVideo> getList(String retStr){
        List<NetVideo> list =  new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(retStr).getJSONObject("result");
            JSONArray videos = (JSONArray) jsonObject.get("videos");
            for (int i = 0; i < videos.length(); i++){
                try {
                    JSONObject video = videos.getJSONObject(i);
                    String title = video.getString("title");
                    String info = ((JSONArray)video.get("creator")).getJSONObject(0).getString("userName");
                    String imgUrl = video.getString("coverUrl");
                    String videoInfo = video.getString("vid");
                    NetVideo nv = new NetVideo(title,info,imgUrl,videoInfo,""+(i+1));
                    list.add(nv);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<VideoUrlItem> getVideoUrlList(NetVideo nv){
        if (!nv.getExtraUrl().matches("^\\d+$")){
            return getVideoUrlListSingle(nv);
        }else {
            return getVideoUrlListMulti(nv);
        }
    }

    private List<VideoUrlItem> getVideoUrlListMulti(NetVideo nv){
        String api = String.format(VIDEO_URL, nv.getExtraUrl());
        String retStr = AnalysisUtils.sendDataByPost(api);
        List<VideoUrlItem> list = new ArrayList<>();
        try {
            JSONObject videoUrls = new JSONObject(retStr).getJSONObject("data").getJSONObject("brs");
            Iterator<String> items = videoUrls.keys();
            while(items.hasNext()){
                String item = items.next();
                VideoUrlItem vui = new VideoUrlItem(VideoUrlType.get(item),videoUrls.getString(item));
                list.add(0, vui);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    private List<VideoUrlItem> getVideoUrlListSingle(NetVideo nv){
        String api = getApiByCloudVideoId(nv.getExtraUrl());
        String retStr = AnalysisUtils.sendDataByPost(api);
        List<VideoUrlItem> list = new ArrayList<>();
        try {
            JSONObject videoUrl = new JSONObject(retStr).getJSONArray("urls").getJSONObject(0);
                VideoUrlItem vui = new VideoUrlItem(VideoUrlType.get(videoUrl.getString("r")),videoUrl.getString("url"));
                list.add(vui);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }

    private String getApiByCloudVideoId(String vid){
        try {
            String param = AnalysisUtils.aesEncrypt("{\"ids\":\"[\"" + vid + "\"]\",\"resolution\":\"1080\",\"csrf_token\":\"\"}", "0CoJUm6Qyw8W8jud");
            param = AnalysisUtils.aesEncrypt(param, "a8LWv2uAtXjzSfkQ");
            param = java.net.URLEncoder.encode(param,   "utf-8");
            String encSecKey = "&encSecKey=2d48fd9fb8e58bc9c1f14a7bda1b8e49a3520a67a2300a1f73766caee29f2411c5350bceb15ed196ca963d6a6d0b61f3734f0a0f4a172ad853f16dd06018bc5ca8fb640eaa8decd1cd41f66e166cea7a3023bd63960e656ec97751cfc7ce08d943928e9db9b35400ff3d138bda1ab511a06fbee75585191cabe0e6e63f7350d6";
            String url = "http://music.163.com/weapi/cloudvideo/playurl?csrf_token=";
            String paramData = "params=" + param + encSecKey;
            return url + "&" + paramData;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

    private String getApiByCloudVideoTopList() {
//        https://interface.music.163.com/weapi/charts/mv/ali-light?csrf_token=f40034c4b89ee3bfed606d05a16631cd
        String param = "guCk4Rgr1xBChl0httzg714pjfjHw85GcniB7Dsp4vuu225tlQTGxJ0IPFCW1UoM";
        String encSecKey = "&encSecKey=4b9408c2868caca2fb1e1e504a18e0a6bc027c7137aa2aa4f66c79f9c99f63e3aeaaad4a547b8394c427e2b6af62d09b602ffa943d7fba35a6eb0abea4231efa2947771c6da3e6f97925e96ad625f5acbd47de2930a9e71865dd15be58c79e29a3eac626b7014102a65f6ee36f453f4a825de0c9a31fc58a712db7b723888094";
        String url = "http://music.163.com/weapi/charts/mv/ali-light?csrf_token=";
        String paramData = "params=" + param + encSecKey;
        return url + "&" + paramData;
    }
}
