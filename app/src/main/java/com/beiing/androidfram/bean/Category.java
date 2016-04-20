package com.beiing.androidfram.bean;

import java.util.List;

/**
 * Created by chenliu on 2016/4/14.
 * 描述：
 */
public class Category {

    /**
     * id : 0
     * name : all
     * title : 热门
     * intro : null
     * is_display : true
     * cover_path : http://s1.xmcdn.com/css/img/common/category/hot.png
     * tag_list : ["治愈系","排行榜","英语","相声","新歌","老歌","访谈","脱口秀","鬼故事","评书","公开课","理财","国学","童话","声音日记","随手录","星座"]
     */

    private int id;
    private String name;
    private String title;
    private Object intro;
    private boolean is_display;
    private String cover_path;
    private List<String> tag_list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Object getIntro() {
        return intro;
    }

    public void setIntro(Object intro) {
        this.intro = intro;
    }

    public boolean isIs_display() {
        return is_display;
    }

    public void setIs_display(boolean is_display) {
        this.is_display = is_display;
    }

    public String getCover_path() {
        return cover_path;
    }

    public void setCover_path(String cover_path) {
        this.cover_path = cover_path;
    }

    public List<String> getTag_list() {
        return tag_list;
    }

    public void setTag_list(List<String> tag_list) {
        this.tag_list = tag_list;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", intro=" + intro +
                ", is_display=" + is_display +
                ", cover_path='" + cover_path + '\'' +
                ", tag_list=" + tag_list +
                '}';
    }
}
