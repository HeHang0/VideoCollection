package com.oohoo.videoapi.analysis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.oohoo.videoapi.util.AnalysisUtils;
import com.oohoo.videoapi.util.Tools;
import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import static com.oohoo.videoapi.util.AnalysisUtils.VideoUrlType;

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
        String searchUrl = "https://api.bilibili.com/x/web-interface/ranking/region?rid=1&day=3&original=0";
        String anaStr = AnalysisUtils.sendDataByGet(searchUrl, "Android");
        return getVideoListByHome(anaStr);
    }

    @Override
    public List<VideoUrlItem> getVideoUrlList(NetVideo nv) {
        return getVideoUrl(nv.getExtraUrl());
    }

    @Override
    public List<NetVideo> getVideoListBySearch(String searchKey) {
        String searchUrl = getSearchUrl(searchKey);
        String anaStr = AnalysisUtils.sendDataByGet(searchUrl, "Android");
        return getNetVideoList(anaStr);
    }
    public List<NetVideo> getVideoListByHome(String retStr){
        List<NetVideo> list =  new ArrayList<>();
        try {
            JSONObject jsonObject = JSON.parseObject(retStr);
            JSONArray streams = (JSONArray) jsonObject.get("data");
            if(streams == null) return list;
            for (int i = 0; i < streams.size(); i++){
                try {
                    JSONObject stream = streams.getJSONObject(i);
                    String title = stream.getString("title");
                    String info = stream.getString("author");
                    String imgUrl = stream.getString("pic").replace("http://","https://");
                    String videoInfo = "http://www.bilibili.com/video/av" + stream.getString("aid");
                    String number = "" + i;
                    NetVideo nv = new NetVideo(title,info,imgUrl, videoInfo,number);
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

    private List<NetVideo> getNetVideoList(String retStr){
        List<NetVideo> list =  new ArrayList<>();
        try {
            JSONObject jsonObject = JSON.parseObject(retStr).getJSONObject("data").getJSONObject("items");
            JSONArray streams = (JSONArray) jsonObject.get("archive");
            if(streams == null) return list;
            for (int i = 0; i < streams.size(); i++){
                try {
                    JSONObject stream = streams.getJSONObject(i);
                    String title = stream.getString("title");
                    String info = stream.getString("desc");
                    String imgUrl = stream.getString("cover").replaceFirst("https","http");
                    String videoInfo = stream.getString("uri").replace("bilibili://video/", "http://www.bilibili.com/video/av");;
                    NetVideo nv = new NetVideo(title,info,imgUrl,videoInfo,"" + (i+1));
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
//
    private List<VideoUrlItem> getVideoUrlList(String retStr){
        List<VideoUrlItem> list = new ArrayList<>();

        try {
            JSONObject jsonObject = JSON.parseObject(retStr).getJSONObject("data");
            JSONArray streams = (JSONArray) jsonObject.get("streams");
            if(streams == null) return list;
            for (int i = 0; i < streams.size(); i++){
                try {
                    JSONObject stream = streams.getJSONObject(i);
                    String des = VideoUrlType.get(stream.getString("quality"));
                    JSONArray ja = (JSONArray)(stream.get("segs"));
                    if(ja == null) continue;
                    String url = ja.getJSONObject(0).getString("url");
                    VideoUrlItem vui = new VideoUrlItem(des,url );
                    list.add(vui);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return list;
    }
    public String getSearchUrl(String searchParam){
        String params = "appkey=1d8b6e7d45233436" + "&build=518000&keyword=" + URLEncoder.encode(searchParam) + "&mobi_app=android&platform=android&pn=1" + "&ps=20&ts=" + System.currentTimeMillis() / 1000L;
        return "http://app.bilibili.com/x/v2/search?" + params + "&sign=" + Tools.md5Encoder(new StringBuilder().append(params).append("560c52ccd288fed045859ed18bffd973").toString());
    }

  public List<VideoUrlItem> getVideoUrl(String url){
      List<VideoUrlItem> result = new ArrayList<>();
        String aid;
          if(url.contains("/video/av")) {
              aid = Tools.getStrWithRegular("(?i)/video/av([^/^\\?]+)",url);
          }else if(url.contains("/video/bv") || url.contains("/video/BV")) {
              aid = Tools.getStrWithRegular("(?i)/video/bv([^/^\\?]+)",url);
          }else if(url.contains("html")) {
            aid = Tools.getStrWithRegular("/video/([\\S]+).html",url);
        }else {
            aid = Tools.getStrWithRegular("/video/([^/]+)",url);
        }
        String paramString1 = "aid=" + aid + "&appkey=1d8b6e7d45233436" + "&build=518000&from=6&mobi_app=android&plat=0&platform=android&ts=" + System.currentTimeMillis() / 1000L;
        String paramString2 = new StringBuilder().append(paramString1).append("560c52ccd288fed045859ed18bffd973").toString();
        String paramUrl = "http://app.bilibili.com/x/v2/view?" + paramString1 + "&sign=" + Tools.md5Encoder(paramString2);
        String anaStr = AnalysisUtils.sendDataByGet(paramUrl, "Android");
        String cid = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(anaStr).getJSONObject("data").getJSONArray("pages").getJSONObject(0);
            cid = jsonObject.getString("cid");
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (cid.isEmpty()) return null;
        String paramString3 = "access_key=121c589b8dde2e22e48b5f442f75d863&appkey=iVGUTjsxvpLeuDCf" + "&build=518000&buvid=B4284733-5697-4A34-A153-2F67BA7855B41981infoc&cid=" + cid + "&avid=" + aid + "&device=android&mid=5136944&otype=json&platform=android&quality=2";

        String paramString4 = "http://api.bilibili.com/x/player/playurl?" + paramString3 + "&sign=" + Tools.md5Encoder(paramString3 + "aHRmhWMLkdeMuILqORnYZocwMBpMEOdt");
        anaStr = AnalysisUtils.sendDataByGet(paramString4, "Android");
        String videoUrl = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(anaStr).getJSONObject("data");
            videoUrl = jsonObject.getJSONArray("durl").getJSONObject(0).getString("url");

            JSONArray supportFormats = jsonObject.getJSONArray("support_formats");
            for (int i = 0; i < supportFormats.size(); i++){
                try {
                    result.add(new VideoUrlItem(supportFormats.getJSONObject(i).getString("display_desc"), videoUrl));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
      try {
      } catch (Exception e) {
          e.printStackTrace();
      }

        return null;
    }
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
