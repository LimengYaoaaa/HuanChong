package com.jiyun.huanchong.ui.activity.order.presenter;

import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.ui.activity.bean.OrderBean;
import com.jiyun.huanchong.ui.activity.order.model.IOrderModel;
import com.jiyun.huanchong.ui.activity.order.model.OrderModel;
import com.jiyun.huanchong.ui.activity.order.view.IorderView;

/**
 * Created by hp on 2017/12/19.
 */

public class OrderPresenter implements  IorderPresenter {
    private IOrderModel iOrderModel;
    private IorderView iorderView;

    public OrderPresenter( IorderView iorderView) {
        this.iOrderModel = new OrderModel();
        this.iorderView = iorderView;
    }

    @Override
    public void orderget(String userId, String orderState) {
     iOrderModel.ordergetlist(userId, orderState, new HttpCallback<OrderBean>() {


         @Override
         public void success(OrderBean orderBean) {
             iorderView.orderget(orderBean);
         }

         @Override
         public void error(String error) {

         }
     });
    }
}
