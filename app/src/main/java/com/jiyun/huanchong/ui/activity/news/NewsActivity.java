package com.jiyun.huanchong.ui.activity.news;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

public class NewsActivity extends BaseActivity implements View.OnClickListener {

    private Button dialogue;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    protected void findViewById() {
        dialogue = (Button) findViewById(R.id.dialogue);
        dialogue.setOnClickListener(this);
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
            case R.id.dialogue:
                  startActivity(new Intent(this,ChatInterfaceActivity.class));
                break;
        }
    }
}