package com.jiyun.huanchong.ui.activity.news;

import android.widget.FrameLayout;

import com.hyphenate.easeui.ui.EaseChatFragment;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

/**
 * Created by mengYao on 2017/12/12.
 */

public class ChatInterfaceActivity extends BaseActivity {
    private FrameLayout frag;
    @Override
    protected int getLayoutId() {
   return      R.layout.chat;
    }

    @Override
    protected void findViewById() {
        frag = findViewById(R.id.frag);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
//new出EaseChatFragment或其子类的实例
        EaseChatFragment chatFragment = new EaseChatFragment();
        //传入参数
        chatFragment.setArguments(getIntent().getExtras());
        getSupportFragmentManager().beginTransaction().add(R.id.frag, chatFragment).commit();
    }
}
