package com.jiyun.huanchong.ui.activity.home;

import java.io.Serializable;

/**
 * Created by hp on 2017/12/18.
 */

public class Person implements Serializable {
    private String Title ; //每条item的数据
    private boolean isChecked; //每条item的状态
    public Person(String title){
        Title = title;
    }
    public String getTitle() {
        return Title;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public boolean isChecked() {
        return isChecked;
    }
    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}

