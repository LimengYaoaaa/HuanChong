package com.jiyun.huanchong.ui.activity.home.model;

import com.jiyun.huanchong.model.api.HttpCallback;

/**
 * Created by hp on 2017/12/18.
 */

public interface IModel<T> {
    void  get(String beginIndex,String coordX,String coordY,String endIndex,String orderBy,HttpCallback<T> callback);
    void  getlist(String beginIndex,String endIndex,String petTypeCode,HttpCallback<T> callback);
}
