package com.jiyun.huanchong.ui.activity.order.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.bean.OrderBean;
import com.jiyun.huanchong.ui.activity.order.DetailsActivity;
import com.jiyun.huanchong.ui.activity.order.adapter.OrderAdapter;
import com.jiyun.huanchong.ui.activity.order.presenter.OrderPresenter;
import com.jiyun.huanchong.ui.activity.order.view.IorderView;
import com.jiyun.huanchong.ui.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class wholeFragment extends BaseFragment implements IorderView{


    private ListView wholelist;
    private ArrayList<OrderBean> list = new ArrayList<>();
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
      //  OrderPresenter.orderget(userid,"");
    }

    @Override
    protected void loadData() {
        list.clear();
        for (int i = 0; i < 5; i++) {


        list.add(new OrderBean(R.mipmap.hhh,R.mipmap.hhh,"待确认"));
        OrderAdapter orderAdapter = new OrderAdapter(list, getContext());
        wholelist.setAdapter(orderAdapter);
        }

        wholelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), DetailsActivity.class));
            }
        });
    }

    @Override
    public void orderget(OrderBean orderBean) {


    }
}
