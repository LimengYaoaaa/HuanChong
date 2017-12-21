package com.jiyun.huanchong.ui.activity.order.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.bean.OrderBean;
import com.jiyun.huanchong.ui.activity.order.Details_02Activity;
import com.jiyun.huanchong.ui.activity.order.adapter.OrderAdapter;
import com.jiyun.huanchong.ui.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TobeconfirmedFragment extends BaseFragment {


    private ListView tobeclist;
    private ArrayList<OrderBean> list = new ArrayList<>();
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tobeconfirmed;
    }

    @Override
    protected void findViewById(View view) {
        tobeclist = (ListView) view.findViewById(R.id.tobeclist);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        list.clear();
        for (int i = 0; i <5 ; i++) {


            list.add(new OrderBean(R.mipmap.hhh,R.mipmap.hhh,"待确认"));
            OrderAdapter orderAdapter = new OrderAdapter(list, getContext());
            tobeclist.setAdapter(orderAdapter);
        }
       tobeclist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), Details_02Activity.class));
            }
        });
    }

}
