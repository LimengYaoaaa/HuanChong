package com.jiyun.huanchong.model.biz;

import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.utils.CJSON;

/**
 * Created by mengYao on 2017/12/17.
 */

public interface RegisterModel {
    <T>void register(String phone, String username, String password, HttpCallback<T> callback);
    <T>void login(String phone,String password, HttpCallback<T> callback);
}
