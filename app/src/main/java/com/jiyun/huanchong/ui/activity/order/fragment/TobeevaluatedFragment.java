package com.jiyun.huanchong.ui.activity.order.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.bean.OrderBean;
import com.jiyun.huanchong.ui.activity.order.Details_01Activity;
import com.jiyun.huanchong.ui.activity.order.adapter.OrderAdapter;
import com.jiyun.huanchong.ui.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class TobeevaluatedFragment extends BaseFragment {


    private ListView tobeelist;
    private ArrayList<OrderBean> list = new ArrayList<>();
    public TobeevaluatedFragment() {
        // Required empty public constructor
    }




    @Override
    protected int getLayoutId() {
        return R.layout.fragment_tobeevaluated;
    }

    @Override
    protected void findViewById(View view) {
        tobeelist = (ListView) view.findViewById(R.id.tobeelist);
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
        tobeelist.setAdapter(orderAdapter);
    }
        tobeelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), Details_01Activity.class));
            }
        });
    }
}
