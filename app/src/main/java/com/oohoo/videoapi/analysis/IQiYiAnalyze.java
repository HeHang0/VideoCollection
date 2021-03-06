package com.oohoo.videoapi.analysis;

import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import java.util.List;


public class IQiYiAnalyze extends BaseAnalyze {
    private String TAG = "IQiYiAnalyze";

    public IQiYiAnalyze(){
        title = "爱奇艺";
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
//    public static List<NetVideo> GetVideoListByHome(String retStr){
//        List<NetVideo> list =  new ArrayList<>();
////        String pattern = "<body[^>]*>([\\s\\S]*)</body>";
////        Pattern r = Pattern.compile(pattern);
////        Matcher m = r.matcher(retStr);
////        if(m.find()) {
////            retStr = m.group(0);
////        }
//        Document doc = Jsoup.parse(retStr);
//
//        Elements links0 = doc.select("a.mod_focus-index_item");
//        for ( Element link: links0) {
//            Element img = link.parent();
//            String imgUrl = img.attr("data-indexfocus-lazyimg");
//            if (imgUrl.length()< 1) imgUrl = img.attr("style").replace("background-image: url(","").replaceFirst("\\);([\\w\\W]*)","");
//            imgUrl = imgUrl.startsWith("//") ? "http:"+imgUrl : imgUrl;
//            String url = link.attr("href");
//            url = url.startsWith("//") ? "http:"+url : url;
//            list.add(new NetVideo(
//                    link.attr("alt"),
//                    "",
//                    imgUrl,
//                    url,
//                    "1" ));
//        }
//
//        Elements links = doc.select("a.site-piclist_pic_link");
//        for ( Element link: links) {
//            Element img = link.getElementsByTag("img").first();
//            String imgUrl = img.attr("src");
//            imgUrl = imgUrl.startsWith("//") ? "http:"+imgUrl : imgUrl;
//            String url = link.attr("href");
//            url = url.startsWith("//") ? "http:"+url : url;
//            list.add(new NetVideo(
//                    link.attr("title").length() < 1 ? img.attr("title") : link.attr("title"),
//                    "",
//                    imgUrl,
//                    url,
//                    "1" ));
//        }
//
//        return list;
//    }
//
//    public static List<NetVideo> GetNetVideoList(String retStr){
//        List<NetVideo> list =  new ArrayList<>();
//        String pattern = "<body[^>]*>([\\s\\S]*)</body>";
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(retStr);
//        if(m.find()) {
//            retStr = m.group(0);
//        }
//        Document doc = Jsoup.parse(retStr);
//        Elements albun_links = doc.select("a.album_link");
//
//
//        for(int i = 0; i < albun_links.size(); i++){
//            Element link = albun_links.get(i);
//            if (link.hasClass("album_link-more") || link.attr("title").equals("更多")) continue;
//            list.add(new NetVideo(
//                    link.attr("title"),
//                    "",
//                    "",
//                    link.attr("href"),
//                    ""+(i+1) ));
//        }
//
//        int i = 1;
//        Elements links = doc.select("a.figure");
//        for ( Element link: links) {
//            if (!link.attr("href").contains(".html")) continue;
//            Element img = link.getElementsByTag("img").first();
//            list.add(new NetVideo(
//                    img.attr("title"),
//                    "",
//                    img.attr("src"),
//                    link.attr("href"),
//                    "1"));
//        }
//        return list;
//    }
//
//    public static List<VideoUrlItem> GetVideoUrlList(String retStr){
//        List<VideoUrlItem> list = new ArrayList<>();
//
//        try {
//            JSONObject jsonObject = new JSONObject(retStr).getJSONObject("data");
//            JSONArray streams = (JSONArray) jsonObject.get("streams");
//            for (int i = 0; i < streams.length(); i++){
//                try {
//                    JSONObject stream = streams.getJSONObject(i);
//                    if (stream.getString("type").equals("M3U8")){
//                        String des = VideoUrlType.get(stream.getString("quality"));
//                        JSONArray ja = (JSONArray)(stream.get("segs"));
//                        if (ja.length() == 1){
//                            String url = ja.getJSONObject(0).getString("url");
//                            VideoUrlItem vui = new VideoUrlItem(des,url );
//                            list.add(vui);
//                        }
//                    }
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
//
//    public static String getTitleByUrl(String url) {
//        String title = "";
//        String vid = Tools.getStrWithRegular("v_([\\s\\S]+).html",url);
//        String anaStr = NetVideoHelper.sendDataByGet("http://expand.video.iqiyi.com/api/fb?apiKey=71c300df4a7f4e89a43d8e19e5458e6f&rec=0&playurl=http://www.iqiyi.com/v_" + vid + ".html", "Win32");
//        try {
//            title = new JSONObject(anaStr).getJSONObject("data").getString("title");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return title;
//    }
//
//    public static boolean checkVideoUrl(String url) {
//            return url.contains(".com/v_");
//    }
//
//    public static String getPageLoadedJs() {
//        return "function closeAd(){if($('.header-app').length > 0) $('.header-app').css('display','none !important');if($('.m-downiqy').length > 0) $('.m-downiqy').css('display','none !important');if($('.m-guide.po-fixed.hide').length > 0) $('.m-guide.po-fixed.hide').css('display','none !important');} closeAd();";
//    }
//
//    private static String shieldUrls = "iqiyi://mobile/home?ftype=27&subtype=144,";
//    public static boolean isShield(String url){
//        return  shieldUrls.contains(url) || url.contains(".apk");
//    }
}
