package com.jiyun.huanchong.model.biz;

import com.jiyun.huanchong.config.Urls;
import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.net.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 张龙辉 on 2017/12/22.
 */

public class BindPhoneModelmpl implements BindPhoneModel {
    @Override
    public <T> void bind(String threeId, String userPhone, String userImage, String userName, String password, HttpCallback<T> callback) {
        Map<String,Object> map=new HashMap<>();
        map.put("threeId",threeId);
        map.put("userPhone",userPhone);
        map.put("userImage",userImage);
        map.put("userName",userName);
        map.put("password",password);
        OkHttpUtils.getInstance().login(Urls.BASEURL+"user/register.jhtml",map,callback);
    }
}
