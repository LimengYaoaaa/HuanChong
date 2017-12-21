package com.jiyun.huanchong.ui.activity.setting;

import android.view.View;
import android.widget.ImageView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

public class ChangpingJianYiActivity extends BaseActivity {


    private ImageView Back_return_01;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_changping_jian_yi;
    }

    @Override
    protected void findViewById() {
        Back_return_01 = (ImageView)findViewById(R.id.Back_return_01);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        Back_return_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
