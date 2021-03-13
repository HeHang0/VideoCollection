package com.oohoo.videoapi.analysis;

import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import java.util.List;


public class YouKuAnalyze extends BaseAnalyze {
    private String TAG = "YouKuAnalyze";

    public YouKuAnalyze(){
        title = "优酷";
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
//        Elements links = doc.select("a.v-link, a.p-link");
//        for ( Element link: links) {
//            Element img = link.previousElementSibling();
//            int length = img.attr("style").length();
//            String imgUrl = img.attr("style").substring(22, length-3);
//            if (imgUrl.startsWith("//")){
//                imgUrl = imgUrl.replaceFirst("//", "http://");
//            }else if(imgUrl.startsWith("https://")){
//
//            }else{
//                imgUrl = "";
//            }
//            String herf = link.attr("href").replaceFirst("//", "http://");
//            //herf = herf.replaceAll("([\\s\\S]*)id_", "").replace(".html","").replaceAll("==([\\s\\S]*)$","") + "==";
//            list.add(new NetVideo(
//                    link.attr("title"),
//                    "",
//                    imgUrl,
//                    herf,
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
//        Elements yk_dir_container = doc.getElementsByClass("yk_dir");
//        Document yk_dir_containerDoc = Jsoup.parse(yk_dir_container.toString());
//        Elements yk_dir = yk_dir_containerDoc.select("div.yk_card,div.ep_box");
//
//        for(Element yk_dir_div: yk_dir) {
//            if (yk_dir_div.attr("id").equals("more-video")) continue;
//            if(yk_dir_div.hasClass("yk_card")) {
//                Element item = yk_dir_div.getElementsByClass("card_link").first();
//                Element img = yk_dir_div.getElementsByTag("img").first();
//                if (item.attr("href").contains("i.youku.com")) continue;
//                list.add(new NetVideo(
//                        item.attr("_log_title"),
//                        "",
//                        img != null ? img.attr("src").replaceFirst("//", "http://") : "",
//                        item.attr("href").replaceFirst("//", "http://"),
//                        "" ));
//            }else if(yk_dir_div.hasClass("ep_box")){
//                Elements clearfix = yk_dir_div.select("li");
//                for(int i=0;i<clearfix.size();i++){
//                    Document clearfixliDoc = Jsoup.parse(clearfix.get(i).toString());
//                    Elements item = clearfixliDoc.select("a");  //选择器的形式
//                    Document span = Jsoup.parse(item.toString());
//                    Elements spana = span.select("span");
//                    list.add(new NetVideo(
//                            item.text().replaceFirst(spana.text(), ""),
//                            item.attr("_log_title"),
//                            "",
//                            item.attr("href").replaceFirst("//", "http://"),
//                            i+1+""));
//                }
//            }
//        }
//        Elements yk_result_container = doc.getElementsByClass("yk_result _sk_content");
//        Elements yk_result = yk_result_container.select(".v");
//        for(Element yk_result_v: yk_result) {
//            Element item = yk_result_v.select("a").first();
//            Element img = yk_result_v.getElementsByTag("img").first();
//            Element subTitle = yk_result_v.getElementsByClass("v-desc-col").first();
//            String herf = item.attr("href").replaceFirst("//", "http://");
//            //herf = herf.replaceAll("([\\s\\S]*)id_", "").replace(".html","").replaceAll("==([\\s\\S]*)$","") + "==";
//            list.add(new NetVideo(
//                    item.attr("title"),
//                    subTitle.text(),
//                    img.attr("src").replaceFirst("//", "http://"),
//                    herf,
//                    ""));
//        }
//        return list;
//    }
//
//    public static List<VideoUrlItem> GetVideoUrlList(String retStr){
//        List<VideoUrlItem> list = new ArrayList<>();
//        try {
//            JSONObject jsonObject = new JSONObject(retStr).getJSONObject("data");
//            JSONArray streams = (JSONArray) jsonObject.get("streams");
//            for (int i = 0; i < streams.length(); i++){
//                try {
//                    JSONObject stream = streams.getJSONObject(i);
//                    if (stream.getString("type").equals("M3U8") && stream.getString("subType").equals("MP4")){
//                        String des = VideoUrlType.get(stream.getString("quality"));
//                        String url = ((JSONArray)(stream.get("segs"))).getJSONObject(0).getString("url");
//                        VideoUrlItem vui = new VideoUrlItem(des,url );
//                        list.add(vui);
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
//        String vid = Tools.getStrWithRegular("id_([\\s\\S]+).html",url);
//        String anaStr = NetVideoHelper.sendDataByGet("http://openapi.youku.com/v2/videos/show_basic.json?video_id=" + vid + "&client_id=b10ab8588528b1b1", "Win32");
//        try {
//            title = new JSONObject(anaStr).getString("title");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        return title;
//    }
//
//    public static boolean checkVideoUrl(String url) {
//        if (url.contains("youku.com/video") || url.contains("youku.com/v_show"))
//            return true;
//        else
//            return false;
//    }
//
//    public static String getPageLoadedJs() {
//        return "function closeAd(){if($('div [sourcetype=\\'yksmartbanner_index_0\\'] :first').length > 0) $('div [sourcetype=\\'yksmartbanner_index_0\\'] :first').click()};closeAd();";
//    }
//
//    private static String shieldUrls = "";
//    public static boolean isShield(String url) {
//        return  shieldUrls.contains(url) || url.contains(".apk");
//    }
}