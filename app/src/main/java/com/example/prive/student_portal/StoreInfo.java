package com.example.prive.student_portal;

import android.os.Parcel;
import android.os.Parcelable;

public class StoreInfo implements Parcelable {

    private String url;
    private String title;

    StoreInfo(String url, String title) {
        this.url = url;
        this.title = title;
    }

    protected StoreInfo(Parcel in) {
        url = in.readString();
        title = in.readString();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle(){
        return title;
    }


    public static final Creator<StoreInfo> CREATOR = new Creator<StoreInfo>() {
        @Override
        public StoreInfo createFromParcel(Parcel in) {
            return new StoreInfo(in);
        }

        @Override
        public StoreInfo[] newArray(int size) {
            return new StoreInfo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(title);
    }
}
