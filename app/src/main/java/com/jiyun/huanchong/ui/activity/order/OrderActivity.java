package com.jiyun.huanchong.ui.activity.order;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;


public class OrderActivity extends BaseActivity implements View.OnClickListener {

    private Button order;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_order;
    }

    @Override
    protected void findViewById() {
        order = (Button) findViewById(R.id.order);
        order.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order:
                 startActivity(new Intent(this,OrderdetailsActivity.class));
                break;
        }
    }
}
