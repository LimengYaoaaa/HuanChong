package com.jiyun.huanchong.ui.activity.bean;

/**
 * Created by hp on 2017/12/19.
 */

public class OrderBean {
     private int img;
     private int img_01;
     private String text;

    public OrderBean(int img, int img_01, String text) {
        this.img = img;
        this.img_01 = img_01;
        this.text = text;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getImg_01() {
        return img_01;
    }

    public void setImg_01(int img_01) {
        this.img_01 = img_01;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "OrderBean{" +
                "img=" + img +
                ", img_01=" + img_01 +
                ", text='" + text + '\'' +
                '}';
    }
}
