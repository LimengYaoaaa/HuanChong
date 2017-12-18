package com.jiyun.huanchong.ui.activity.wallet;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

public class WalletActivity extends BaseActivity implements View.OnClickListener {

    private Button proposal;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_wallet;
    }

    @Override
    protected void findViewById() {
        proposal = (Button) findViewById(R.id.proposal);
        proposal.setOnClickListener(this);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.proposal:
                 startActivity(new Intent(this,ProposalActivity.class));
                break;
        }
    }
}
