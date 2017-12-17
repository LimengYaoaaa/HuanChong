package com.jiyun.huanchong.ui.activity.start;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.home.HomeActivity;
import com.jiyun.huanchong.ui.base.BaseActivity;

public class StartActivity extends BaseActivity implements View.OnClickListener {

    private TextView toHomePage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_start;
    }

    @Override
    protected void findViewById() {
        toHomePage = (TextView) findViewById(R.id.toHomePage);
    }

    @Override
    protected void init() {
        toHomePage.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toHomePage:
                startActivity(new Intent(this, HomeActivity.class));
                finish();
                break;
        }
    }
}
