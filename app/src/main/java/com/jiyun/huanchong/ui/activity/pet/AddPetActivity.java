package com.jiyun.huanchong.ui.activity.pet;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

import static com.jiyun.huanchong.constants.Constants.REQUESTCODE;

public class AddPetActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout btnJump1;
    private RelativeLayout btnJump2;
    private ImageView back;




    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_pet;
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void init() {
        btnJump1 = (RelativeLayout) findViewById(R.id.btnJump1);
        btnJump2 = (RelativeLayout) findViewById(R.id.btnJump2);
        back = (ImageView) findViewById(R.id.back);
        btnJump1.setOnClickListener(this);
        btnJump2.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }




    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnJump1:
                startActivityForResult(new Intent(this,PetTypeActivity.class),REQUESTCODE);
                break;
            case R.id.btnJump2:
                startActivity(new Intent(this,PetMianYiActivity.class));
                break;
            case R.id.back:
                finish();
                break;
        }
    }
}
