package com.jiyun.huanchong.ui.activity.order.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.bean.OrderBean;
import com.jiyun.huanchong.utils.CircleBitmapTransformation;

import java.util.ArrayList;

/**
 * Created by hp on 2017/12/19.
 */

public class OrderAdapter extends BaseAdapter {
    private ArrayList<OrderBean> list;
    private Context context;

    public OrderAdapter(ArrayList<OrderBean> list, Context context) {
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

    class  ViewHolder{
        ImageView imageView;
        ImageView imageView01;
        TextView textView;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.order_item,null);
            holder.imageView = view.findViewById(R.id.orderiv_demo1);
            holder.imageView01 = view.findViewById(R.id.orderiv_demo3);
            holder.textView = view.findViewById(R.id.ordertv_demo1);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context)
                .load(R.mipmap.vvv)
                .transform(new CircleBitmapTransformation(context))
                .into(holder.imageView);
        Glide.with(context)
                .load(R.mipmap.vvv)
                .transform(new CircleBitmapTransformation(context))
                .into(holder.imageView01);
        holder.textView.setText(list.get(i).getText());


        return view;
    }
}
