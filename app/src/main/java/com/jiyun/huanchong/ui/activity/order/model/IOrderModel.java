package com.jiyun.huanchong.ui.activity.order.model;

import com.jiyun.huanchong.model.api.HttpCallback;

/**
 * Created by hp on 2017/12/19.
 */

public interface IOrderModel<T> {

   void  ordergetlist(String userId, String orderState, HttpCallback<T> callback);
}
