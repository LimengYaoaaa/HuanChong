package com.jiyun.huanchong.model.biz;

import com.jiyun.huanchong.model.api.HttpCallback;

/**
 * Created by 张龙辉 on 2017/12/18.
 */

public interface ForgetModel {
    <T>void forget(String phone, String pass, HttpCallback<T> callback);
}
