package com.oohoo.videoapi.video;


import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

public class NetVideo {
    private final String title;
    private final String info;
    private Bitmap img;
    private final String imgUrl;
    private final List<VideoUrlItem> videoUrls;
    private String extraUrl;
    private final String number;

    public NetVideo(String title, String info, String imgUrl, List<VideoUrlItem> videoUrls, String number){
        this.title = title;
        this.info = info;
        this.imgUrl = imgUrl;
        this.videoUrls = videoUrls;
        this.number = number;
        this.extraUrl = "";
    }

    public NetVideo(String title, String info, String imgUrl, String number){
        this.title = title;
        this.info = info;
        this.imgUrl = imgUrl;
        this.number = number;
        this.extraUrl = "";
        this.videoUrls = new ArrayList<>();
    }

    public NetVideo(String title, String info, String imgUrl, String extraUrl, String number){
        this.title = title;
        this.info = info;
        this.imgUrl = imgUrl;
        this.number = number;
        this.extraUrl = extraUrl;
        this.videoUrls = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public String getInfo() {
        return info;
    }

    public List<VideoUrlItem> getVideoUrls() {
        return videoUrls;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Bitmap getImg() {
        return img;
    }

    public void setImg(Bitmap img) {
        this.img = img;
    }

    public String getNumber() {
        return number;
    }

    public void setExtraUrl(String url) { extraUrl = url; }

    public String getExtraUrl() { return extraUrl; }
}

