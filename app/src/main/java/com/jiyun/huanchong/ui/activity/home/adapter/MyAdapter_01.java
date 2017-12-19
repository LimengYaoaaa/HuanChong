package com.jiyun.huanchong.ui.activity.home.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.bean.ZhuYeBean_01;
import com.jiyun.huanchong.utils.Formation;

import java.util.ArrayList;

/**
 * Created by hp on 2017/12/18.
 */

public class MyAdapter_01  extends BaseAdapter {
    private ArrayList<ZhuYeBean_01.DescBean> list;
    private Context context;

    public MyAdapter_01(ArrayList<ZhuYeBean_01.DescBean> list, Context context) {
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
        TextView textView;
        TextView textView01;
        TextView textView02;
        TextView textView03;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null){
            holder = new ViewHolder();
            view = View.inflate(context, R.layout.list_item_01,null);
            holder.imageView = view.findViewById(R.id.iv_demo1);
            holder.textView = view.findViewById(R.id.tv_demo1);
            holder.textView01 = view.findViewById(R.id.tv_demo2);
            holder.textView02 = view.findViewById(R.id.tv_demo3);
            holder.textView03 = view.findViewById(R.id.tv_demo4);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context)
                .load(list.get(i).getPetTypeImage())
                .apply(new RequestOptions()
                        .centerCrop()
                        .priority(Priority.HIGH)
                        .transform(new Formation()))
                .into(holder.imageView);



        holder.textView.setText(list.get(i).getTypeName());
        holder.textView02.setText(list.get(i).getPetPrice()+"元起");
        holder.textView03.setText("距"+0.01+"km");

        return view;
    }
}


