package com.jiyun.huanchong.ui.activity.order.fragment;


import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.bean.OrderBean;
import com.jiyun.huanchong.ui.activity.order.Details_03Activity;
import com.jiyun.huanchong.ui.activity.order.adapter.OrderAdapter;
import com.jiyun.huanchong.ui.base.BaseFragment;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfostercareFragment extends BaseFragment {


    private ListView infolist;
    private ArrayList<OrderBean> list = new ArrayList<>();
    public InfostercareFragment() {
        // Required empty public constructor
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_infostercare;
    }

    @Override
    protected void findViewById(View view) {
        infolist = (ListView)view.findViewById(R.id.infolist);
    }

    @Override
    protected void init() {
        infolist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), Details_03Activity.class));
            }
        });

    }

    @Override
    protected void loadData() {
        list.clear();
        for (int i = 0; i <5 ; i++) {


            list.add(new OrderBean(R.mipmap.hhh,R.mipmap.hhh,"待确认"));
            OrderAdapter orderAdapter = new OrderAdapter(list, getContext());
            infolist.setAdapter(orderAdapter);
        }
    }

}
