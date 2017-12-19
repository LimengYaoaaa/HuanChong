package com.jiyun.huanchong.ui.activity.personalInfomation;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.utils.SharedUtils;


public class UpdateUserNameActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mBack;
    private TextView mTitle;
    private TextView mCommit;
    private EditText mUpdateContent;
    private final int RESULT_CODE=201;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_name;
    }

    @Override
    protected void findViewById() {
        mBack= (ImageView) findViewById(R.id.mBack);
        mCommit= (TextView) findViewById(R.id.mCommit);
        mUpdateContent= (EditText) findViewById(R.id.mUpdateContent);
    }

    @Override
    protected void init() {
        mBack.setOnClickListener(this);
        mCommit.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.mBack:
                finish();
                break;
            case R.id.mCommit:
                String name = mUpdateContent.getText().toString().trim();
                if (name==null){
                    Toast.makeText(this, "修改名字不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedUtils.getInstance(this).addUserName(name);
                Intent intent = new Intent();
                intent.putExtra("name",name);
                setResult(RESULT_CODE,intent);
                finish();
                break;
        }
    }
}
