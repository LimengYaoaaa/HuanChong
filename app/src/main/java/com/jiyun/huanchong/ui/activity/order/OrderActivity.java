package com.jiyun.huanchong.ui.activity.order;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.order.adapter.TabLayoutAdapter;
import com.jiyun.huanchong.ui.activity.order.fragment.InfostercareFragment;
import com.jiyun.huanchong.ui.activity.order.fragment.TobeconfirmedFragment;
import com.jiyun.huanchong.ui.activity.order.fragment.TobeevaluatedFragment;
import com.jiyun.huanchong.ui.activity.order.fragment.wholeFragment;
import com.jiyun.huanchong.ui.base.BaseActivity;

import java.util.ArrayList;


public class OrderActivity extends BaseActivity {


    private TabLayout tab_demo1;
    private ViewPager vip_demo1;
    private ImageView orderback;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void findViewById() {
        tab_demo1 = (TabLayout)findViewById(R.id.tab_demo1);
        vip_demo1 = (ViewPager)findViewById(R.id.vip_demo1);
        orderback = (ImageView)findViewById(R.id.orderback);

    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("全部");
        strings.add("待确认");
        strings.add("寄养中");
        strings.add("待评价");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new wholeFragment());
        fragments.add(new TobeevaluatedFragment());
        fragments.add(new TobeconfirmedFragment());
        fragments.add(new InfostercareFragment());
        TabLayoutAdapter tabLayoutAdapter = new TabLayoutAdapter(getSupportFragmentManager(), strings, fragments);
        vip_demo1.setAdapter(tabLayoutAdapter);
        tab_demo1.setupWithViewPager(vip_demo1);

        orderback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }


}
