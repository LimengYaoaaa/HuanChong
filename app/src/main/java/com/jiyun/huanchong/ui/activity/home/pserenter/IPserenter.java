package com.jiyun.huanchong.ui.activity.home.pserenter;

/**
 * Created by hp on 2017/12/18.
 */

public interface IPserenter {
    void get(String beginIndex,String coordX,String coordY,String endIndex,String orderBy);
    void  getlist(String beginIndex,String endIndex,String petTypeCode);
}
