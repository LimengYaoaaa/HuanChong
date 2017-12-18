package com.jiyun.huanchong.ui.activity.login;

<<<<<<< Updated upstream
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
=======
import android.content.Intent;
import android.view.View;
>>>>>>> Stashed changes
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanchong.R;
<<<<<<< Updated upstream
import com.jiyun.huanchong.presenter.RegisterPresenter;
import com.jiyun.huanchong.presenter.RegisterPresenterImpl;
import com.jiyun.huanchong.ui.activity.bean.RegisterBean;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.ui.view.RegisterView;
import com.jiyun.huanchong.utils.CJSON;
import com.jiyun.huanchong.utils.ConnectionUtils;

import java.util.HashMap;
import java.util.Map;

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
=======
import com.jiyun.huanchong.ui.base.BaseActivity;


/**
 * Created by mengYao on 2017/12/10.
 */

public class RegisterActivity extends BaseActivity implements View.OnClickListener {

    private TextView mRegisterLogin;
    private TextView mRegisterBack;
    private TextView mGetCheckCode;
    private TextView mWxRegister;
    private TextView mQQRegister;

>>>>>>> Stashed changes
    @Override
    protected int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void findViewById() {
<<<<<<< Updated upstream
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
=======
        mRegisterBack = (TextView) findViewById(R.id.mRegisterBack);
        mRegisterLogin = (TextView) findViewById(R.id.mRegisterLogin);
        mGetCheckCode = (TextView) findViewById(R.id.mGetCheckCode);
        mWxRegister = (TextView) findViewById(R.id.mWxRegister);
        mQQRegister = (TextView) findViewById(R.id.mQQRegister);
>>>>>>> Stashed changes
    }

    @Override
    protected void init() {
        mRegisterBack.setOnClickListener(this);
        mRegisterLogin.setOnClickListener(this);
<<<<<<< Updated upstream
        mBtnRegister.setOnClickListener(this);
        mWxRegister.setOnClickListener(this);
        mQQRegister.setOnClickListener(this);
        registerPresenter=new RegisterPresenterImpl(this);
=======
        mGetCheckCode.setOnClickListener(this);
        mWxRegister.setOnClickListener(this);
        mQQRegister.setOnClickListener(this);
>>>>>>> Stashed changes
    }

    @Override
    protected void loadData() {

    }

<<<<<<< Updated upstream
=======


>>>>>>> Stashed changes
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mRegisterBack:
                finish();
                break;
            case R.id.mRegisterLogin:
<<<<<<< Updated upstream
                finish();
                break;
            case R.id.mBtnRegister:
                registerPresenter.register(inputPhoneNum.getText().toString().trim(),
                        inputUserName.getText().toString().trim(),
                        inputPassword.getText().toString().trim());
                break;
            case R.id.mWxRegister:

                break;
            case R.id.mQQRegister:

                break;
        }
    }

    @Override
    public void onSuccess(RegisterBean registerBean) {
        Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
=======
                startActivity(new Intent(this,LoginActivity.class));
                finish();
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
>>>>>>> Stashed changes
}
