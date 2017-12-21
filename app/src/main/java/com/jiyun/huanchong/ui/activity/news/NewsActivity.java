package com.jiyun.huanchong.ui.activity.news;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.EaseConstant;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

public class NewsActivity extends BaseActivity implements View.OnClickListener {

 private EditText et_name;
private Button bt_chat;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news;
    }

    @Override
    protected void findViewById() {
        et_name  = findViewById(R.id.et_name);
         bt_chat = findViewById(R.id.bt_chat);
    }

    @Override
    protected void init() {
        bt_chat.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.bt_chat:
                Intent intent=new Intent(NewsActivity.this,ChatInterfaceActivity.class);
                intent.putExtra(EaseConstant.EXTRA_USER_ID,et_name.getText().toString().trim());
                intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, EMMessage.ChatType.Chat);
                startActivity(intent);
                break;
        }
    }
}
