package com.jiyun.huanchong.ui.activity.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

public class LoginActivity extends BaseActivity implements View.OnClickListener {

    private ImageView mLoginBack;
    private TextView mToRegister;
    private EditText mLoginPhoneEdit;
    private EditText mLoginPassWordEdit;
    private TextView mForgetWord;
    private Button mBtnLogin;
    private LinearLayout mWxLogin;
    private LinearLayout mQqLogin;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViewById() {
        mLoginBack= (ImageView) findViewById(R.id.mLoginBack);
        mToRegister= (TextView) findViewById(R.id.mToRegister);
        mLoginPhoneEdit= (EditText) findViewById(R.id.mLoginPhoneEdit);
        mLoginPassWordEdit= (EditText) findViewById(R.id.mLoginPassWordEdit);
        mForgetWord= (TextView) findViewById(R.id.mForgetWord);
        mBtnLogin= (Button) findViewById(R.id.mBtnLogin);
        mWxLogin= (LinearLayout) findViewById(R.id.mWxLogin);
        mQqLogin= (LinearLayout) findViewById(R.id.mQqLogin);
    }

    @Override
    protected void init() {
        mLoginBack.setOnClickListener(this);
        mToRegister.setOnClickListener(this);
        mForgetWord.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        mWxLogin.setOnClickListener(this);
        mQqLogin.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mLoginBack:
                finish();
                break;
            case R.id.mToRegister:
                startActivity(new Intent(this,RegisterActivity.class));
                break;
            case R.id.mForgetWord:

                break;
            case R.id.mWxLogin:

                break;
            case R.id.mQqLogin:

                break;
            case R.id.mBtnLogin:

                break;
        }
    }
}
