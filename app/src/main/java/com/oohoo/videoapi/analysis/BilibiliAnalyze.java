package com.oohoo.videoapi.analysis;

import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import java.util.List;

/**
 * Created by HeHang on 2018/1/18.
 */

public class BilibiliAnalyze extends BaseAnalyze {
    private String TAG = "BilibiliAnalyze";

    public BilibiliAnalyze(){
        title = "哔哩哔哩";
    }

    @Override
    public List<NetVideo> getVideoListByHome() {
        return null;
    }

    @Override
    public List<VideoUrlItem> getVideoUrlList(NetVideo nv) {
        return null;
    }

    @Override
    public List<NetVideo> getVideoListBySearch(String searchKey) {
        return null;
    }
//    public List<NetVideo> getVideoListByHome(String retStr){
//        List<NetVideo> list =  new ArrayList<>();
//        try {
//            JSONObject jsonObject = new JSONObject(retStr).getJSONObject("hot");
//            JSONArray streams = (JSONArray) jsonObject.get("list");
//            for (int i = 0; i < streams.length(); i++){
//                try {
//                    JSONObject stream = streams.getJSONObject(i);
//                    String title = stream.getString("title");
//                    String info = stream.getString("author");
//                    String imgUrl = stream.getString("pic").replace("http://","https://");
//                    String videoInfo = "http://www.bilibili.com/video/av" + stream.getString("aid");
//                    String number = "" + i;
//                    NetVideo nv = new NetVideo(title,info,imgUrl, videoInfo,number);
//                    list.add(nv);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<NetVideo> getNetVideoList(String retStr){
//        List<NetVideo> list =  new ArrayList<>();
//        try {
//            JSONObject jsonObject = new JSONObject(retStr).getJSONObject("data").getJSONObject("items");
//            JSONArray streams = (JSONArray) jsonObject.get("archive");
//            for (int i = 0; i < streams.length(); i++){
//                try {
//                    JSONObject stream = streams.getJSONObject(i);
//                    String title = stream.getString("title");
//                    String info = stream.getString("desc");
//                    String imgUrl = stream.getString("cover").replaceFirst("https","http");
//                    String videoInfo = stream.getString("uri").replace("bilibili://video/", "http://www.bilibili.com/video/av");;
//                    NetVideo nv = new NetVideo(title,info,imgUrl,videoInfo,"" + (i+1));
//                    list.add(nv);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return list;
//    }
//
//    public List<VideoUrlItem> getVideoUrlList(String retStr){
//        List<VideoUrlItem> list = new ArrayList<>();
//
//        try {
//            JSONObject jsonObject = new JSONObject(retStr).getJSONObject("data");
//            JSONArray streams = (JSONArray) jsonObject.get("streams");
//            for (int i = 0; i < streams.length(); i++){
//                try {
//                    JSONObject stream = streams.getJSONObject(i);
//                    String des = VideoUrlType.get(stream.getString("quality"));
//                    JSONArray ja = (JSONArray)(stream.get("segs"));
//                    String url = ja.getJSONObject(0).getString("url");
//                    VideoUrlItem vui = new VideoUrlItem(des,url );
//                    list.add(vui);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return list;
//    }
//    public String getSearchUrl(String searchParam){
//        String params = "appkey=1d8b6e7d45233436" + "&build=518000&keyword=" + URLEncoder.encode(searchParam) + "&mobi_app=android&platform=android&pn=1" + "&ps=20&ts=" + System.currentTimeMillis() / 1000L;
//        return "http://app.bilibili.com/x/v2/search?" + params + "&sign=" + Tools.md5Encoder(new StringBuilder().append(params).append("560c52ccd288fed045859ed18bffd973").toString());
//    }
//
//    public String getVideoUrl(String url){
//        String aid = Tools.getStrWithRegular("/video/([\\s\\S][^']+)/",url).length() > 0 ? Tools.getStrWithRegular("/video/([\\s\\S][^']+)/",url) : Tools.getStrWithRegular("/video/([\\s\\S][^']+).html",url);;
//        String paramString1 = "aid=" + aid + "&appkey=1d8b6e7d45233436" + "&build=518000&from=6&mobi_app=android&plat=0&platform=android&ts=" + System.currentTimeMillis() / 1000L;
//        String paramString2 = new StringBuilder().append(paramString1).append("560c52ccd288fed045859ed18bffd973").toString();
//        String paramUrl = "http://app.bilibili.com/x/v2/view?" + paramString1 + "&sign=" + Tools.md5Encoder(paramString2);
//        String anaStr = Utils.sendDataByGet(paramUrl, "Android");
//        String cid = "";
//        try {
//            JSONObject jsonObject = new JSONObject(anaStr).getJSONObject("data").getJSONArray("pages").getJSONObject(0);
//            cid = jsonObject.getString("cid");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        if (cid.equals("")) return "";
//        String paramString3 = "access_key=121c589b8dde2e22e48b5f442f75d863&appkey=iVGUTjsxvpLeuDCf" + "&build=518000&buvid=B4284733-5697-4A34-A153-2F67BA7855B41981infoc&cid=" + cid + "&device=android&mid=5136944&otype=json&platform=android&quality=2";
//
//        String paramString4 = "http://app.bilibili.com/playurl?" + paramString3 + "&sign=" + Tools.md5Encoder(paramString3 + "aHRmhWMLkdeMuILqORnYZocwMBpMEOdt");
//        anaStr = Utils.sendDataByGet(paramString4, "Android");
//        String videoUrl = "";
//        try {
//            JSONObject jsonObject = new JSONObject(anaStr).getJSONArray("durl").getJSONObject(0);
//            videoUrl = jsonObject.getString("url");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//        return videoUrl;
//    }
//
//    public String getTitleByUrl(String url) {
//        String title = "";
//        String vid = Tools.getStrWithRegular("/av([\\s\\S][^']+)/",url).length() > 0 ? Tools.getStrWithRegular("/av([\\s\\S][^']+)/",url) : Tools.getStrWithRegular("/av([\\s\\S][^']+).html",url);
//        String anaStr = Utils.sendDataByGet("http://api.bilibili.com/view?type=json&appkey=8e9fc618fbd41e28&id=" + vid + "&page=1", "Win32");
//        try {
//            title = new JSONObject(anaStr).getString("title");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return title;
//    }
//
//    public boolean checkVideoUrl(String url) {
//            return url.contains("/video/");
//    }
//
//    public String getPageLoadedJs() {
//        return "function closeAd(){if($('.index__openBtn__M-commonComponent-openBtn-').length > 0) $('.index__openBtn__M-commonComponent-openBtn-').hide(); if($('.index__openAppBtn__M-commonComponent-topArea-').length > 0) $('.index__openAppBtn__M-commonComponent-topArea-').hide();};closeAd();";
//    }
//
//    private String shieldUrls = "";
//    public boolean isShield(String url) {
//        return  shieldUrls.contains(url) || url.contains(".apk");
//    }
}
