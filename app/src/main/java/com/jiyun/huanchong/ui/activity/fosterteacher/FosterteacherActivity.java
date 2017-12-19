package com.jiyun.huanchong.ui.activity.fosterteacher;

import android.content.Intent;
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
    private ImageView mIdCard;
    private EditText big_edit;
    private EditText center_edit;
    private EditText small_edit;
    private EditText cat_edit;
    private EditText smallpet_edit;
    private CheckBox wish;
    private EditText swish_edit;
    private CheckBox get;
    private EditText get_edit;
    private EditText mNiCheng;
    private EditText mShow;
    private ImageView mYingYe;
    private ImageView mPlayPhoto;
    private Button ende;


    @Override
    protected int getLayoutId() {
        return R.layout.activity_fosterteacher;
    }

    @Override
    protected void findViewById() {
        mIdCard = (ImageView) findViewById(R.id.mIdCard);
        big_edit = (EditText) findViewById(R.id.big_edit);
        center_edit = (EditText) findViewById(R.id.center_edit);
        small_edit = (EditText) findViewById(R.id.small_edit);
        cat_edit = (EditText) findViewById(R.id.cat_edit);
        smallpet_edit = (EditText) findViewById(R.id.smallpet_edit);
        wish = (CheckBox) findViewById(R.id.wish);
        swish_edit = (EditText) findViewById(R.id.swish_edit);
        get = (CheckBox) findViewById(R.id.get);
        get_edit = (EditText) findViewById(R.id.get_edit);
        mNiCheng = (EditText) findViewById(R.id.mNiCheng);
        mShow = (EditText) findViewById(R.id.mShow);
        mYingYe = (ImageView) findViewById(R.id.mYingYe);
        mPlayPhoto = (ImageView) findViewById(R.id.mPlayPhoto);
        ende = (Button) findViewById(R.id.ende);
        ll_city = (LinearLayout) findViewById(R.id.ll_city);
    }

    @Override
    protected void init() {
            ll_city.setOnClickListener(this);
            ende.setOnClickListener(this);

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
            case R.id.ende:

                break;
        }
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
