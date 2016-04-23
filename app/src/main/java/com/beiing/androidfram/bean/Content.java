package com.beiing.androidfram.bean;


public class Content{
    private int TYPE = 2;
    private String title;
    private String desc;
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getIconUrl() {
        return url;
    }

    public void setIconUrl(String iconUrl) {
        this.url = iconUrl;
    }

    @Override
    public String toString() {
        return "Content{" +
                "title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", icon=" + url +
                '}';
    }
}
