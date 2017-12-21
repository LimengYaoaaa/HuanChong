package com.jiyun.huanchong.ui.activity.order;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.utils.CircleBitmapTransformation;

import static com.jiyun.huanchong.app.App.context;

public class DetailsActivity extends AppCompatActivity {

    private ImageView orderback;
    private ImageView touxiang;
    private TextView name;
    private ImageView touxiang_01;
    private TextView name_01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_02);
        initView();
    }

    private void initView() {
        orderback = (ImageView) findViewById(R.id.orderback);
        touxiang = (ImageView) findViewById(R.id.touxiang);
        name = (TextView) findViewById(R.id.name);
        touxiang_01 = (ImageView) findViewById(R.id.touxiang_01);
        name_01 = (TextView) findViewById(R.id.name_01);
        Glide.with(this)
                .load(R.mipmap.hhh)
                .transform(new CircleBitmapTransformation(context))
                .into(touxiang);
        Glide.with(this)
                .load(R.mipmap.hhh)
                .transform(new CircleBitmapTransformation(context))
                .into(touxiang_01);
    }

}
