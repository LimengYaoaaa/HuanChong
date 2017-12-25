package com.jiyun.huanchong.ui.activity.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.presenter.BindePhonePresenteImpl;
import com.jiyun.huanchong.ui.activity.home.HomeActivity;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.ui.view.BindPhoneView;

public class BindPhoneActivity extends BaseActivity implements View.OnClickListener, BindPhoneView {

    private ImageView mBindPhoneBack;
    private ImageView mBindPhoneHeadImg;
    private TextView mBindPhoneName;
    private EditText mBindPhone;
    private TextView mGetCheckCode;
    private EditText mInputCheckCode;
    private EditText mInputUserName;
    private EditText mInputPassword;
    private Button mBindPhoneBtn;
    private BindePhonePresenteImpl bindePhonePresente;
    private String uid;
    private String iconurl;
    private String name;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_bind_phone;
    }

    @Override
    protected void findViewById() {
        mBindPhoneBack= (ImageView) findViewById(R.id.mBindPhoneBack);
        mBindPhoneHeadImg= (ImageView) findViewById(R.id.mBindPhoneHeadImg);
        mBindPhoneName= (TextView) findViewById(R.id.mBindPhoneName);
        mBindPhone= (EditText) findViewById(R.id.mBindPhone);
        mGetCheckCode= (TextView) findViewById(R.id.mGetCheckCode);
        mInputCheckCode= (EditText) findViewById(R.id.mInputCheckCode);
        mInputUserName= (EditText) findViewById(R.id.mInputUserName);
        mInputPassword= (EditText) findViewById(R.id.mInputPassword);
        mBindPhoneBtn= (Button) findViewById(R.id.mBindPhoneBtn);
    }

    @Override
    protected void init() {
        SharedPreferences disanfangInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        iconurl = disanfangInfo.getString("iconurl",null);
        name = disanfangInfo.getString("username", null );
        uid = disanfangInfo.getString("uid", null );
        Glide.with(this).load(iconurl).into(mBindPhoneHeadImg);
        mBindPhoneName.setText(name);
        mBindPhoneBack.setOnClickListener(this);
        mBindPhoneBtn.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        bindePhonePresente = new BindePhonePresenteImpl(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBindPhoneBack:
                finish();
                break;
            case R.id.mBindPhoneBtn:
                bindePhonePresente.bind(uid,mBindPhone.getText().toString(),iconurl,name,mInputPassword.getText().toString());
                break;
        }
    }

    @Override
    public void sucess() {
        Toast.makeText(this, "绑定成功", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(BindPhoneActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
