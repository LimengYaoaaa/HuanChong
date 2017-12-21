package com.jiyun.huanchong.ui.activity.login;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.hyphenate.chat.EMClient;
import com.hyphenate.exceptions.HyphenateException;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.presenter.RegisterPresenter;
import com.jiyun.huanchong.presenter.RegisterPresenterImpl;
import com.jiyun.huanchong.ui.activity.bean.RegisterBean;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.ui.view.RegisterView;

public class RegisterActivity extends BaseActivity implements View.OnClickListener,RegisterView {

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
    private RegisterPresenter registerPresenter;
    private TextView mGetCheckCode;


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

        mRegisterBack = (TextView) findViewById(R.id.mRegisterBack);
        mRegisterLogin = (TextView) findViewById(R.id.mRegisterLogin);
        mGetCheckCode = (TextView) findViewById(R.id.mGetCheckCode);
        mWxRegister = (TextView) findViewById(R.id.mWxRegister);
        mQQRegister = (TextView) findViewById(R.id.mQQRegister);

    }

    @Override
    protected void init() {
        mRegisterBack.setOnClickListener(this);
        mRegisterLogin.setOnClickListener(this);

        mBtnRegister.setOnClickListener(this);
        mWxRegister.setOnClickListener(this);
        mQQRegister.setOnClickListener(this);
        registerPresenter=new RegisterPresenterImpl(this);


        mWxRegister.setOnClickListener(this);
        mQQRegister.setOnClickListener(this);

    }

    @Override
    protected void loadData() {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mRegisterBack:
                finish();
                break;
            case R.id.mRegisterLogin:

                finish();
                break;
            case R.id.mBtnRegister:
                registerPresenter.register(inputPhoneNum.getText().toString().trim(),
                        inputUserName.getText().toString().trim(),
                        inputPassword.getText().toString().trim());
                break;
            case R.id.mGetCheckCode:
                Toast.makeText(this, "获取验证码", Toast.LENGTH_SHORT).show();
                break;
            case R.id.mWxRegister:
                startActivity(new Intent(this,BindPhoneActivity.class));
                break;
            case R.id.mQQRegister:
                startActivity(new Intent(this,BindPhoneActivity.class));
                break;

        }
    }

    @Override
    public void onSuccess(final RegisterBean registerBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        EMClient.getInstance().createAccount(registerBean.getResult().getUserPhone()+"",registerBean.getResult().getPassword()+"");
                    } catch (HyphenateException e) {
                        e.printStackTrace();

                    }
                }
            }).start();



    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }


        }

