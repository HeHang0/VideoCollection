package com.oohoo.videoapi.video;

public class VideoUrlItem{
    private String description;
    private String url;

    public VideoUrlItem(String description, String url){
        this.description = description;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }
}
