package com.jiyun.huanchong.ui.activity.order.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.jiyun.huanchong.ui.activity.bean.OrderBean;

import java.util.ArrayList;

/**
 * Created by hp on 2017/12/19.
 */

public class OrderAdapter extends BaseAdapter {
    private ArrayList<OrderBean.DescBean> list;
    private Context context;

    public OrderAdapter(ArrayList<OrderBean.DescBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
