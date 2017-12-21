package com.jiyun.huanchong.ui.activity.setting;

import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;


public class SettingActivity extends BaseActivity {


    private RelativeLayout Product;
    private ImageView Back_return;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void findViewById() {
        Product = (RelativeLayout)findViewById(R.id.Product);
        Back_return = (ImageView)findViewById(R.id.Back_return_01);




    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }
}
