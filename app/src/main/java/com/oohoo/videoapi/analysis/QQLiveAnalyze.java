package com.oohoo.videoapi.analysis;

import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import java.util.List;

/**
 * Created by HeHang on 2018/1/13.
 */

public class QQLiveAnalyze extends BaseAnalyze {
    private String TAG = "QQLiveAnalyze";

    public QQLiveAnalyze(){
        title = "腾讯视频";
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
//        String pattern = "<body[^>]*>([\\s\\S]*)</body>";
//        Pattern r = Pattern.compile(pattern);
//        Matcher m = r.matcher(retStr);
//        if(m.find()) {
//            retStr = m.group(0);
//        }
//        Document doc = Jsoup.parse(retStr);
//        Elements links = doc.select("a.figure, a.p-link");
//        for ( Element link: links) {
//            Element img = link.select("img").first();
//            String imgUrl = img.attr("lz_src");
//            Element title = link.select("span.figure_title").first();
//            Element subTitle = link.select("p.figure_desc").first();
//            list.add(new NetVideo(
//                    title.text(),
//                    subTitle.text(),
//                    imgUrl,
//                    link.attr("href").replace("?ptag", ""),
//                    "1" ));
//        }
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
//        Elements li_items = doc.select("li.item");
//        for (int i = 0; i < li_items.size(); ){
//            if (li_items.get(i).hasClass("_option") || li_items.get(i).hasClass("item_more")){
//                li_items.remove(i);
//            }else{
//                i++;
//            }
//        }
//
//        for(int i = li_items.size()-1; i >= 0; i--){
//            Element link = li_items.get(i);
//            Element title = link.select("span.title").first();
//            Element number = link.select("span.date").first();
//
//            list.add(new NetVideo(
//                    title.text(),
//                    "",
//                    "",
//                    link.attr("href").replace("?ptag", ""),
//                    number.text().length() > 2 ? ""+i+1 :number.text()));
//        }
//
//        Elements links = doc.select("a.figure, a.p-link");
//
//        for (int i = 0; i < links.size(); ){
//            if (links.get(i).hasClass("_figure")){
//                links.remove(i);
//            }else{
//                i++;
//            }
//        }
//        for ( Element link: links) {
//            Element img = link.select("img").first();
//            String imgUrl = img.attr("src");
//            Element title = link.select("span.figure_title").first();
//            Element subTitle = link.select("p.figure_desc").first();
//            list.add(new NetVideo(
//                    title.text().replace("<span class=\"h1\">","").replace("</span>",""),
//                    subTitle.text().replace("<em>","").replace("</em>",""),
//                    imgUrl,
//                    link.attr("href"),
//                    "1" ));
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
//                    if (stream.getString("type").equals("MP4")){
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
//        //String vid = Tools.getStrWithRegular("vid=([\\s\\S]+)&",url).length() > 0 ? Tools.getStrWithRegular("vid=([\\s\\S][^']+)&",url) : Tools.getStrWithRegular("vid=([\\s\\S][^']+)[^&]$",url);
//        if (!url.contains("/x/"))
//            url = url.replace("http://m.v.qq.com/","https://m.v.qq.com/x/");
//        else
//            url = url.replace("http://m.v.qq.com/x/","https://m.v.qq.com/x/");
//        String anaStr = NetVideoHelper.sendDataByGet(url, "Win32");
//        title = Tools.getStrWithRegular("\"shareSingleTitle\":\"([\\s\\S][^\"]+)\"",anaStr);
//        return title;
//    }
//
//    public static boolean checkVideoUrl(String url) {
//        return url.contains("vid=") || url.contains("/x/cover");
//    }
//
//    public static String getPageLoadedJs() {
//        return "";
//    }
//
//
//    private static String shieldUrls = "";
//    public static boolean isShield(String url) {
//        return  shieldUrls.contains(url) || url.contains(".apk");
//    }
}
