package com.skyfin.recyclerview.bean;

/**
 * Created by skyfin on 15-10-31.
 */
public class RecycleItemBean {
    int imageviewdrawable;
    String title;

    public RecycleItemBean(int imageviewdrawable, String title) {
        this.imageviewdrawable = imageviewdrawable;
        this.title = title;
    }

    public RecycleItemBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getImageviewdrawable() {
        return imageviewdrawable;
    }

    public void setImageviewdrawable(int imageviewdrawable) {
        this.imageviewdrawable = imageviewdrawable;
    }

    @Override
    public String toString() {
        return "RecycleItemBean{" +
                "imageviewdrawable=" + imageviewdrawable +
                ", title='" + title + '\'' +
                '}';
    }
}
