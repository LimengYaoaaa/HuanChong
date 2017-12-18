package com.jiyun.huanchong.ui.activity.pet;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

import static com.jiyun.huanchong.constants.Constants.REQUESTCODE;

public class PetActivity extends BaseActivity implements View.OnClickListener {

    private ImageView imageView;
    private TextView wodechongwu;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet;
    }

    @Override
    protected void findViewById() {
        imageView = (ImageView) findViewById(R.id.imageView);
        wodechongwu = (TextView) findViewById(R.id.wodechongwu);
    }

    @Override
    protected void init() {


        wodechongwu.setOnClickListener(this);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void loadData() {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.wodechongwu:
                startActivityForResult(new Intent(this,AddPetActivity.class),REQUESTCODE);
                break;
        }
    }
}
