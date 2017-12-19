package com.jiyun.huanchong.ui.activity.order.model;

import com.jiyun.huanchong.config.Urls;
import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.net.OkHttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by hp on 2017/12/19.
 */

public class OrderModel implements IOrderModel {
    @Override
    public void ordergetlist(String userId, String orderState, HttpCallback callback) {
        Map<String,Object> map = new HashMap<>();
        map.put("userId",userId);
        map.put("orderState",orderState);
        OkHttpUtils.getInstance().login(Urls.DINGDAN,map,callback);
    }
}
