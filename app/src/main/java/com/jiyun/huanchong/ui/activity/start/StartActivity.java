package com.jiyun.huanchong.ui.activity.start;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.home.HomeActivity;
import com.jiyun.huanchong.ui.base.BaseActivity;


public class StartActivity extends BaseActivity {


    private Handler handler = new Handler();
    private ImageView iv_Start;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void findViewById() {
        iv_Start = (ImageView) findViewById(R.id.iv_start);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(StartActivity.this,HomeActivity.class));

                finish();
            }
        },3000);
    }

    @Override
    protected void init() {

    }


    @Override
    protected void loadData() {

    }


}
