package com.jiyun.huanchong.ui.activity.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.presenter.ForgetPresenterImpl;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.ui.view.ForgetView;

/**
 * Created by 张龙辉 on 2017/12/18.
 */

public class ForgetActivity extends BaseActivity implements View.OnClickListener, ForgetView {
    private TextView tv_for_tijiao;
    private EditText et_phone;
    private EditText phone_pass;
    private EditText phone_pass_rember;
    private ForgetPresenterImpl forgetPresenter;

    @Override

    protected int getLayoutId() {

        return R.layout.activity_forget;
    }

    @Override
    protected void findViewById() {
         tv_for_tijiao = (TextView) findViewById(R.id.tv_for_tijiao);
        et_phone = (EditText) findViewById(R.id.et_phone);
        phone_pass = (EditText) findViewById(R.id.phone_pass);
        phone_pass_rember = (EditText) findViewById(R.id.phone_pass_rember);
    }

    @Override
    protected void init() {
        tv_for_tijiao.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        forgetPresenter = new ForgetPresenterImpl(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_for_tijiao:

                forgetPresenter.sucess(et_phone.getText().toString(),phone_pass.getText().toString());
                break;
}
    }

    @Override
    public void sucess() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("操作成功");
        builder.setMessage("您的新密码已修改成功，请直接登陆");
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.create();
        builder.show();
    }
}
