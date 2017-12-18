package com.jiyun.huanchong.ui.activity.login;

import android.Manifest;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.presenter.LoginPresenterImpl;
import com.jiyun.huanchong.ui.activity.bean.LoginBean;
import com.jiyun.huanchong.ui.activity.home.HomeActivity;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.ui.view.LoginView;
import com.jiyun.huanchong.utils.SharedUtils;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.Map;


public class LoginActivity extends BaseActivity implements View.OnClickListener,LoginView {

    private ImageView mLoginBack;
    private TextView mToRegister;
    private EditText mLoginPhoneEdit;
    private EditText mLoginPassWordEdit;
    private TextView mForgetWord;
    private Button mBtnLogin;
    private LinearLayout mWxLogin;
    private LinearLayout mQqLogin;
    private LoginPresenterImpl loginPresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void findViewById() {
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        mLoginBack = (ImageView) findViewById(R.id.mLoginBack);
        mToRegister = (TextView) findViewById(R.id.mToRegister);
        mLoginPhoneEdit = (EditText) findViewById(R.id.mLoginPhoneEdit);
        mLoginPassWordEdit = (EditText) findViewById(R.id.mLoginPassWordEdit);
        mForgetWord = (TextView) findViewById(R.id.mForgetWord);
        mBtnLogin = (Button) findViewById(R.id.mBtnLogin);
        mWxLogin = (LinearLayout) findViewById(R.id.mWxLogin);
        mQqLogin = (LinearLayout) findViewById(R.id.mQqLogin);
    }

    @Override
    protected void init() {
        mLoginBack.setOnClickListener(this);
        mToRegister.setOnClickListener(this);
        mForgetWord.setOnClickListener(this);
        mBtnLogin.setOnClickListener(this);
        mWxLogin.setOnClickListener(this);
        mQqLogin.setOnClickListener(this);
        loginPresenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void loadData() {

    }
        @Override
        public void onClick (View v){
            switch (v.getId()) {
                case R.id.mLoginBack:
                    finish();
                    break;
                case R.id.mToRegister:
                    startActivity(new Intent(this, RegisterActivity.class));
                    break;
                case R.id.mForgetWord:

                    break;
                case R.id.mWxLogin:

                    break;
                case R.id.mQqLogin:
                    UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, new UMAuthListener() {
                        @Override
                        public void onStart(SHARE_MEDIA share_media) {

                        }

                        @Override
                        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
                            String iconurl = map.get("iconurl");
                            String name = map.get("name");
                            String uid = map.get("uid");
                            String gender = map.get("gender");
                            SharedUtils.saveDisanfangInfo(LoginActivity.this, uid, iconurl, name, gender);
                            Intent intent = new Intent(LoginActivity.this, BindPhoneActivity.class);
                            startActivity(intent);
                        }

                        @Override
                        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {

                        }

                        @Override
                        public void onCancel(SHARE_MEDIA share_media, int i) {

                        }
                    });
                    break;
                case R.id.mBtnLogin:
                    loginPresenter.login(mLoginPhoneEdit.getText().toString().trim(),
                            mLoginPassWordEdit.getText().toString().trim());
                    break;
            }
        }

        @Override
        public void onSuccess (LoginBean loginBean){
            Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
            SharedUtils.saveUserInfo(this, loginBean.getResult().getUserPhone(), loginBean.getResult().getUserName(), loginBean.getResult().getUserId(), loginBean.getResult().getUserSex());
            startActivity(new Intent(this, HomeActivity.class));
        }

        @Override
        public void onFailure (String error){
            Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        }
        @Override
        protected void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);
            UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);


        }
    }
