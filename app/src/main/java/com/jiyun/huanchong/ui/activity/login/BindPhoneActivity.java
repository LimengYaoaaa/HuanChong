package com.jiyun.huanchong.ui.activity.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.request.RequestOptions;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.utils.Formation;


/**
 * Created by mengYao on 2017/12/11.
 */

public class BindPhoneActivity extends BaseActivity implements  View.OnClickListener {

    private ImageView mBindPhoneBack;
    private Button mBindPhoneBtn;
    private ImageView mBindPhoneHeadImg;
    private TextView mBindPhoneName;
    private TextView mGetCheckCode;
    private EditText mInputCheckCode;
    private EditText mInputUserName;
    private EditText mInputPassword;
    private EditText mBindPhone;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_phone;
    }


    @Override
    protected void findViewById() {
        mBindPhoneBack = (ImageView) findViewById(R.id.mBindPhoneBack);
        mBindPhoneBtn = (Button) findViewById(R.id.mBindPhoneBtn);
        mBindPhoneHeadImg = (ImageView) findViewById(R.id.mBindPhoneHeadImg);
        mBindPhoneName = (TextView) findViewById(R.id.mBindPhoneName);
        mBindPhone = (EditText) findViewById(R.id.mBindPhone);
        mGetCheckCode = (TextView) findViewById(R.id.mGetCheckCode);
        mInputCheckCode = (EditText) findViewById(R.id.mInputCheckCode);
        mInputUserName = (EditText) findViewById(R.id.mInputUserName);
        mInputPassword = (EditText) findViewById(R.id.mInputPassword);
    }

    @Override
    protected void init() {
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String img = intent.getStringExtra("img");
        Glide.with(this).load(img).apply(new RequestOptions()
                .centerCrop()
                .priority(Priority.HIGH)
                .error(R.mipmap.ic_launcher_round)
                .placeholder(R.mipmap.ic_launcher)
                .transform(new Formation())).into(mBindPhoneHeadImg);
        mBindPhoneName.setText(name);
        mBindPhoneBack.setOnClickListener(this);
        mBindPhoneBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mBindPhoneBack:
                finish();
                break;
            case R.id.mBindPhoneBtn:

                break;
        }
    }



}
