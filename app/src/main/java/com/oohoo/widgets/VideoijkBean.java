package com.oohoo.widgets;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by HeHang on 2018/1/28.
 */

public class VideoijkBean implements Parcelable {
    /**
     * id
     */
    int id;
    /**
     * 分辨率名称
     */
    String stream;
    /**
     * 分辨率对应视频地址
     */
    String url;
    /**
     * 备注备用
     */
    String remarks;
    /**
     * 当前选中的
     */
    boolean select;

    public VideoijkBean() {

    }

    public VideoijkBean(int id, String stream, String url) {
        this.id = id;
        this.stream = stream;
        this.url = url;
    }

    public VideoijkBean(int id, String stream, String url, boolean select) {
        this.id = id;
        this.stream = stream;
        this.url = url;
        this.select = select;
    }

    protected VideoijkBean(Parcel in) {
        id = in.readInt();
        stream = in.readString();
        url = in.readString();
        remarks = in.readString();
        select = in.readByte() != 0;
    }

    public static final Creator<VideoijkBean> CREATOR = new Creator<VideoijkBean>() {
        @Override
        public VideoijkBean createFromParcel(Parcel in) {
            return new VideoijkBean(in);
        }

        @Override
        public VideoijkBean[] newArray(int size) {
            return new VideoijkBean[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isSelect() {
        return select;
    }

    public void setSelect(boolean select) {
        this.select = select;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VideoijkBean that = (VideoijkBean) o;

        if (id != that.id) return false;
        if (stream != null ? !stream.equals(that.stream) : that.stream != null) return false;
        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        return remarks != null ? remarks.equals(that.remarks) : that.remarks == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (stream != null ? stream.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (remarks != null ? remarks.hashCode() : 0);
        return result;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(stream);
        dest.writeString(url);
        dest.writeString(remarks);
        dest.writeByte((byte) (select ? 1 : 0));
    }
}
