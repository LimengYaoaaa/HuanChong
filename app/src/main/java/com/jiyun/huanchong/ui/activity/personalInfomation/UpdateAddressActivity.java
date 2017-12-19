package com.jiyun.huanchong.ui.activity.personalInfomation;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.utils.SharedUtils;
import com.zaaach.citypicker.CityPickerActivity;

import static com.jiyun.huanchong.constants.Constants.RESULTCODE;
import static com.umeng.qq.handler.a.n;
import static com.umeng.qq.handler.a.s;


public class UpdateAddressActivity extends BaseActivity implements View.OnClickListener {


    private ImageView mBack;
    private TextView mCommit;
    private TextView mCity;
    private ImageView selectCity;
    private TextView specificAddress;
    private EditText mspecificAddress;
    private RelativeLayout mSelectCityContainer;
    private final int REQUEST_CITY_CODE=101;
    private final int RESULT_CITY_CODE=201;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_update_address;
    }

    @Override
    protected void findViewById() {
        SharedPreferences userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        String city = userInfo.getString("city", null);
        String address = userInfo.getString("address", null);
        String iconurl = userInfo.getString("iconurl", null);
        mBack= (ImageView) findViewById(R.id.mBack);
        mCommit= (TextView) findViewById(R.id.mCommit);
        mSelectCityContainer = (RelativeLayout) findViewById(R.id.mSelectCityContainer);
        mspecificAddress = (EditText) findViewById(R.id.mspecificAddress);
        mCity = (TextView) findViewById(R.id.mCity);
        if (city!=null)
            mCity.setText(city);
        if (address!=null)
            mspecificAddress.setText(address);
    }

    @Override
    protected void init() {
        mBack.setOnClickListener(this);
        mCommit.setOnClickListener(this);
        mSelectCityContainer.setOnClickListener(this);
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
                String city = mCity.getText().toString().trim();
                String specificAddress = mspecificAddress.getText().toString().trim();
                if (city==null||city.equals("")||specificAddress==null||specificAddress.equals("")){
                    Toast.makeText(this, "地址不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                SharedUtils.getInstance(this).addUserCity(city);
                SharedUtils.getInstance(this).addUserAddress(specificAddress);
                Intent intent = new Intent();
                intent.putExtra("city",city);
                intent.putExtra("address",specificAddress);
                setResult(RESULT_CITY_CODE,intent);
                finish();
                break;
            case R.id.mSelectCityContainer:
                startActivityForResult(new Intent(this, CityPickerActivity.class),REQUEST_CITY_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CITY_CODE&&data!=null){
            String extra = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
            if (extra==null)
                return;
            mCity.setText(extra);
        }
    }
}
