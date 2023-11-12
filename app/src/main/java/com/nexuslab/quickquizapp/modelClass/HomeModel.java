package com.nexuslab.quickquizapp.modelClass;

public class HomeModel {
    String title, desc;

    public HomeModel() {
    }

    public HomeModel(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

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
}
