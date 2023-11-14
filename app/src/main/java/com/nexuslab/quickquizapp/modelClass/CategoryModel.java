package com.nexuslab.quickquizapp.modelClass;

public class CategoryModel {
    String title, desc, category;

    public CategoryModel() {

    }

    public CategoryModel(String title, String desc, String category) {
        this.title = title;
        this.desc = desc;
        this.category = category;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
