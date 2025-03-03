package com.sumitkotiya.quickbazar.models;

public class DealsResponseModel {
    String id,item_name,item_img,off,MRP,item_desc;

    public DealsResponseModel(String id, String item_name, String item_img, String off, String MRP, String item_desc) {
        this.id = id;
        this.item_name = item_name;
        this.item_img = item_img;
        this.off = off;
        this.MRP = MRP;
        this.item_desc=item_desc;
    }


    public DealsResponseModel() {    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getItem_img() {
        return item_img;
    }

    public void setItem_img(String item_img) {
        this.item_img = item_img;
    }

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }

    public String getMRP() {
        return MRP;
    }

    public void setMRP(String MRP) {
        this.MRP = MRP;
    }

    public String getItem_desc() {
        return item_desc;
    }

    public void setItem_desc(String item_desc) {
        this.item_desc = item_desc;
    }
}
