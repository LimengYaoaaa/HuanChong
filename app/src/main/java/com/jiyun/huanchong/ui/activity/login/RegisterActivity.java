package com.jiyun.huanchong.ui.activity.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private TextView mRegisterBack;
    private TextView mRegisterLogin;
    private EditText inputPhoneNum;
    private TextView getCheckCode;
    private EditText inputCheckCode;
    private EditText inputUserName;
    private EditText inputPassword;
    private Button mBtnRegister;
    private TextView mWxRegister;
    private TextView mQQRegister;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void findViewById() {
        mRegisterBack= (TextView) findViewById(R.id.mRegisterBack);
        mRegisterLogin= (TextView) findViewById(R.id.mRegisterLogin);
        inputPhoneNum= (EditText) findViewById(R.id.inputPhoneNum);
        getCheckCode= (TextView) findViewById(R.id.getCheckCode);
        inputCheckCode= (EditText) findViewById(R.id.inputCheckCode);
        inputUserName= (EditText) findViewById(R.id.inputUserName);
        inputPassword= (EditText) findViewById(R.id.inputPassword);
        mBtnRegister= (Button) findViewById(R.id.mBtnRegister);
        mWxRegister= (TextView) findViewById(R.id.mWxRegister);
        mQQRegister= (TextView) findViewById(R.id.mQQRegister);
    }

    @Override
    protected void init() {
        mRegisterBack.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

        }
    }
}
