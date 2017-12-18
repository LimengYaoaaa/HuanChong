package com.jiyun.huanchong.ui.activity.home;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jiyun.huanchong.R;

import java.util.ArrayList;

/**
 * Created by hp on 2017/12/18.
 */

public class ListAdapter extends BaseAdapter {

    private ArrayList<Person> list;
    private Context context;

    public ListAdapter(ArrayList<Person> list, Context context) {
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
        TextView textView;
        CheckBox checkBox;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
           ViewHolder holder;
           if (view == null){
               holder = new ViewHolder();
               view = View.inflate(context, R.layout.listview_item,null);
               holder.textView = (TextView) view.findViewById(R.id.item_demo1);
               holder.checkBox = view.findViewById(R.id.checkbox);
               view.setTag(holder);
           }else{
               holder = (ViewHolder) view.getTag();
           }
           holder.textView.setText(list.get(i).getTitle());
//判断CheckBox的状态
        if(list.get(i).isChecked()){
            holder.checkBox.setChecked(true);//选中
        }else {
            holder.checkBox.setChecked(false);//未选中
        }
        holder.textView.setText(list.get(i).getTitle());
        return view;


    }





}
