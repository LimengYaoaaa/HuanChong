package com.jiyun.huanchong.ui.activity.home.model;

import com.jiyun.huanchong.config.Urls;
import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.net.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 2017/12/18.
 */

public class Model implements IModel {
    @Override
    public void get(String beginIndex, String coordX, String coordY, String endIndex, String orderBy, HttpCallback callback) {
        Map<String,Object> map=new HashMap<>();
        map.put("beginIndex",beginIndex);
        map.put("coordX",coordX);
        map.put("coordY",coordY);
        map.put("endIndex",endIndex);
        map.put("orderBy",orderBy);
        OkHttpUtils.getInstance().login(Urls.HOMEURL,map,callback);

    }

    @Override
    public void getlist(String beginIndex, String endIndex, String petTypeCode, HttpCallback callback) {
        Map<String, Object> map = new HashMap<>();
        map.put("beginIndex",beginIndex);
        map.put("endIndex",endIndex);
        map.put("petTypeCode",petTypeCode);
        OkHttpUtils.getInstance().login(Urls.HOMEURL_01,map,callback);
    }


}
