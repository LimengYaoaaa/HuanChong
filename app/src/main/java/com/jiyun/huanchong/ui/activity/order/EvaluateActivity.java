package com.jiyun.huanchong.ui.activity.order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.utils.CircleBitmapTransformation;

import static com.jiyun.huanchong.app.App.context;

public class EvaluateActivity extends AppCompatActivity {

    private ImageView orderback;
    private ImageView touxiang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);
        initView();
    }

    private void initView() {
        orderback = (ImageView) findViewById(R.id.orderback);
        touxiang = (ImageView) findViewById(R.id.touxiang);
        Glide.with(this)
                .load(R.mipmap.vvv)
                .transform(new CircleBitmapTransformation(context))
                .into(touxiang);
    }
}
