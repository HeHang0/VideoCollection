package com.oohoo.videoapi.analysis;

import android.graphics.drawable.Drawable;

import com.oohoo.videoapi.video.NetVideo;
import com.oohoo.videoapi.video.VideoUrlItem;

import java.util.List;

public abstract class BaseAnalyze {

    protected String title = "";

    protected Boolean showSearch = true;

    protected Boolean isLive = false;

    protected Drawable icon = null;

    protected int iconId = -1;

    public abstract List<NetVideo> getVideoListByHome();

    public abstract List<VideoUrlItem> getVideoUrlList(NetVideo nv);

    public abstract List<NetVideo> getVideoListBySearch(String searchKey);

    public String getTitle() {
        return title;
    }

    public Boolean getShowSearch() {
        return showSearch;
    }

    public Boolean getLive() {
        return isLive;
    }

    public Drawable getIcon() {
        return icon;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIcon(Drawable da) {
        icon = da;
    }

    public BaseAnalyze setIconId(int id) {
        iconId = id;
        return this;
    }

    //
//    String getVideoUrl(String url);
//
//    String getTitleByUrl(String url);
//
//    boolean checkVideoUrl(String url);
//
//    String getPageLoadedJs();
//
//    boolean isShield(String url);
}
