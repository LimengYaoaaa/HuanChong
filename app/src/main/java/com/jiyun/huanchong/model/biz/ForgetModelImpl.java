package com.jiyun.huanchong.model.biz;

import com.jiyun.huanchong.config.Urls;
import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.net.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张龙辉 on 2017/12/18.
 */

public class ForgetModelImpl implements ForgetModel {
    @Override
    public <T> void forget(String phone, String pass, HttpCallback<T> callback) {
        Map<String ,Object> map=new HashMap<>();
        map.put("userPhone",phone);
        map.put("password",pass);
        OkHttpUtils.getInstance().login(Urls.BASEURL+"user/updatePassword.jhtml",map,callback);
    }
}
