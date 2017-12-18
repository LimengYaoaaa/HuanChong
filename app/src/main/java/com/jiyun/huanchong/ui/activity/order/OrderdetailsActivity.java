package com.jiyun.huanchong.ui.activity.order;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;


/**
 * Created by mengYao on 2017/12/12.
 */

public class OrderdetailsActivity extends BaseActivity implements View.OnClickListener{

    private Button evaluate;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_orderdetails;
    }

    @Override
    protected void findViewById() {
        evaluate = (Button) findViewById(R.id.evaluate);
        evaluate.setOnClickListener(this);
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
            case R.id.evaluate:
                   startActivity(new Intent(this,EvaluatesuccessActivity.class));
                break;
        }
    }
}
