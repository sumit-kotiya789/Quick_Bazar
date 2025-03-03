package com.sumitkotiya.quickbazar.models;

public class CategoryResponseModel {
    String id,cat_name,cat_img,cat_desc,cat_status;

    public CategoryResponseModel(String id, String cat_name, String cat_img, String cat_desc, String cat_status) {
        this.id = id;
        this.cat_name = cat_name;
        this.cat_img = cat_img;
        this.cat_desc = cat_desc;
        this.cat_status = cat_status;
    }

    public CategoryResponseModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCat_name() {
        return cat_name;
    }

    public void setCat_name(String cat_name) {
        this.cat_name = cat_name;
    }

    public String getCat_img() {
        return cat_img;
    }

    public void setCat_img(String cat_img) {
        this.cat_img = cat_img;
    }

    public String getCat_desc() {
        return cat_desc;
    }

    public void setCat_desc(String cat_desc) {
        this.cat_desc = cat_desc;
    }

    public String getCat_status() {
        return cat_status;
    }

    public void setCat_status(String cat_status) {
        this.cat_status = cat_status;
    }
}
