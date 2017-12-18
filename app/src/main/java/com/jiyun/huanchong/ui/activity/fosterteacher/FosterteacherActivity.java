package com.jiyun.huanchong.ui.activity.fosterteacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.zaaach.citypicker.CityPickerActivity;


/**
 * Created by mengYao on 2017/12/12.
 */

public class FosterteacherActivity extends BaseActivity implements View.OnClickListener {
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private Button comment;
    private Button appointment;
    private ImageView mFosterteacherBack;
    private EditText mName;
    private EditText mPhone;
    private TextView mCity;
    private EditText mHomeAddress;
    private LinearLayout ll_city;
    private EditText mIdNumber;
    private CheckBox mIsBigDog;
    private CheckBox mIsSecondaryDog;
    private CheckBox mIsSmallDog;
    private CheckBox mIsCat;
    private CheckBox mIsSmallPet;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_fosterteacher;
    }

    @Override
    protected void findViewById() {
         ll_city = (LinearLayout) findViewById(R.id.ll_city);
        mCity = (TextView) findViewById(R.id.mCity);
    }

    @Override
    protected void init() {
            ll_city.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ll_city:

//启动
                startActivityForResult(new Intent(FosterteacherActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);


                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) and run LayoutCreator again
    }
    //重写onActivityResult方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK){
            if (data != null){
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                mCity.setText("当前选择：" + city);
            }
        }
    }


}
