package com.oohoo.videoapi.video;

import java.util.Map;

public class VideoUrlItem{
    private String description;
    private Map<String, String> headers;
    private String url;

    public VideoUrlItem(String description, String url){
        this.description = description;
        this.url = url;
    }

    public VideoUrlItem(String description, String url, Map<String, String> headers){
        this.description = description;
        this.url = url;
        this.headers = headers;
    }

    public String getDescription() {
        return description;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
