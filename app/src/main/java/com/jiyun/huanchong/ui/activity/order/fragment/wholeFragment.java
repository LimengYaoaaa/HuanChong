package com.jiyun.huanchong.ui.activity.order.fragment;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.bean.OrderBean;
import com.jiyun.huanchong.ui.activity.order.presenter.OrderPresenter;
import com.jiyun.huanchong.ui.activity.order.view.IorderView;
import com.jiyun.huanchong.ui.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class wholeFragment extends BaseFragment implements IorderView{


    private ListView wholelist;
    private ArrayList<OrderBean.DescBean> list = new ArrayList<>();
    private OrderPresenter OrderPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_whole;
    }

    @Override
    protected void findViewById(View view) {
        wholelist = (ListView)view.findViewById(R.id.wholelist);

    }

    @Override
    protected void init() {
        OrderPresenter = new OrderPresenter(this);

        SharedPreferences userInfo = getContext().getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String userid = userInfo.getString("userid", "1");
        OrderPresenter.orderget(userid,"");
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void orderget(OrderBean orderBean) {
        ArrayList<OrderBean.DescBean> desc = (ArrayList<OrderBean.DescBean>) orderBean.getDesc();
        list.addAll(desc);
        Log.e("=============",desc.toString());
    }
}
