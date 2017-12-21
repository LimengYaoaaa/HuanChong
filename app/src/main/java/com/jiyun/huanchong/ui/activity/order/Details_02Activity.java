package com.jiyun.huanchong.ui.activity.order;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.utils.CircleBitmapTransformation;

import static com.jiyun.huanchong.app.App.context;

/**
 * Created by hp on 2017/12/21.
 */

public class Details_02Activity extends BaseActivity {

    private ImageView touxiang;
    private TextView name;
    private ImageView touxiang_01;
    private TextView name_01;
    private ImageView orderback;

    @Override
    protected int getLayoutId() {
        return R.layout.details_02;
    }

    @Override
    protected void findViewById() {
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

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }
}
