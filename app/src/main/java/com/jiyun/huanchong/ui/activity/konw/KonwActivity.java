package com.jiyun.huanchong.ui.activity.konw;

import android.view.View;
import android.widget.ImageView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;


public class KonwActivity extends BaseActivity {


    private ImageView konwback;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_konw;
    }

    @Override
    protected void findViewById() {
        konwback = (ImageView)findViewById(R.id.konwback);
        konwback.setOnClickListener(new View.OnClickListener() {
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
