package com.jiyun.huanchong.model.biz;

import com.jiyun.huanchong.config.Urls;
import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.net.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengYao on 2017/12/17.
 */

public class RegisterModelImpl implements RegisterModel {
    @Override
    public <T>void register(String phone, String username, String password, HttpCallback<T> callback) {
        Map<String,Object> params=new HashMap<>();
        params.put("userPhone",phone);
        params.put("userName",username);
        params.put("password",password);
        OkHttpUtils.getInstance().login(Urls.BASEURL+"user/register.jhtml",params,callback);
    }

    @Override
    public <T> void login(String phone, String password, HttpCallback<T> callback) {
        Map<String,Object> params=new HashMap<>();
        params.put("userPhone",phone);
        params.put("password",password);
        OkHttpUtils.getInstance().login(Urls.BASEURL+"user/login.jhtml",params,callback);
    }
}
