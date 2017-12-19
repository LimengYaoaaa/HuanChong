package com.jiyun.huanchong.ui.activity.setting;

import android.content.Intent;
import android.view.View;
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

        Product.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this,ChangpingJianYiActivity.class));
            }
        });
        Back_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }
}
