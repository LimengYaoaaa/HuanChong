package com.jiyun.huanchong.ui.activity.personalInfomation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

import static com.jiyun.huanchong.constants.Constants.REQUESTCODE;
import static com.jiyun.huanchong.utils.LogUtils.D;

/**
 * Created by mengYao on 2017/12/11.
 */

public class PersonalInfomationActivity extends BaseActivity implements View.OnClickListener {



    private ImageView personal_return;
    private RelativeLayout head_portrait;
    private RelativeLayout mPersonalUserName;
    private RelativeLayout mPersonalSex;
    private RelativeLayout mDataOfBirth;
    private RelativeLayout mPersonalPhone;
    private RelativeLayout mPersonalWx;
    private RelativeLayout mPersonalQq;
    private RelativeLayout mContractAddress;
    private final int requestCode=100;
    private PopupWindow pop;
    private View mContainer;
    private View inflate;
    private TextView mPopupTitle;
    private TextView mToPhotograph;
    private TextView mToAlbum;
    private TextView mDismissPopup;
    private final int TOPHOTOGRAPH_01=101;
    private final int TOPHOTOGRAPH_02=102;
    private ImageView mHead;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_infomation;
    }

    @Override
    protected void findViewById() {
        inflate = LayoutInflater.from(this).inflate(R.layout.popup, null);
        mContainer = findViewById(R.id.mContainer);
        personal_return = (ImageView) findViewById(R.id.personal_return);
        head_portrait = (RelativeLayout) findViewById(R.id.head_portrait);
        mPersonalUserName = (RelativeLayout) findViewById(R.id.mPersonalUserName);
        mPersonalSex = (RelativeLayout) findViewById(R.id.mPersonalSex);
        mDataOfBirth = (RelativeLayout) findViewById(R.id.mDataOfBirth);
        mPersonalPhone = (RelativeLayout) findViewById(R.id.mPersonalPhone);
        mPersonalWx = (RelativeLayout) findViewById(R.id.mPersonalWx);
        mPersonalQq = (RelativeLayout) findViewById(R.id.mPersonalQq);
        mContractAddress = (RelativeLayout) findViewById(R.id.mContractAddress);
        mHead = (ImageView) findViewById(R.id.mHead);
        mPopupTitle = inflate.findViewById(R.id.mPopupTitle);
        mToPhotograph = inflate.findViewById(R.id.mToPhotograph);
        mToAlbum = inflate.findViewById(R.id.mToAlbum);
        mDismissPopup = inflate.findViewById(R.id.mDismissPopup);
    }

    @Override
    protected void init() {
        mPopupTitle.setText("上传头像");
        personal_return.setOnClickListener(this);
        head_portrait.setOnClickListener(this);
        mPersonalUserName.setOnClickListener(this);
        mPersonalSex.setOnClickListener(this);
        mDataOfBirth.setOnClickListener(this);
        mPersonalPhone.setOnClickListener(this);
        mPersonalWx.setOnClickListener(this);
        mPersonalQq.setOnClickListener(this);
        mContractAddress.setOnClickListener(this);
        mToPhotograph.setOnClickListener(this);
        mToAlbum.setOnClickListener(this);
        mDismissPopup.setOnClickListener(this);
    }

    @Override
    protected void loadData() {

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_return:
                finish();
                break;
            case R.id.head_portrait:

                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.WRAP_CONTENT);
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.setOutsideTouchable(true);
                pop.showAtLocation(mContainer, Gravity.BOTTOM, 0, 0);
                startAlphAnimotion();
                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });

                break;
            case R.id.mPersonalUserName:
                startActivityForResult(new Intent(this,UpdateUserNameActivity.class),REQUESTCODE);
                break;
            case R.id.mPersonalSex:

                break;
            case R.id.mDataOfBirth:

                break;
            case R.id.mPersonalPhone:

                break;
            case R.id.mPersonalWx:

                break;
            case R.id.mPersonalQq:

                break;
            case R.id.mContractAddress:
                break;
            case R.id.mToPhotograph:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,TOPHOTOGRAPH_01);
                break;
        }
    }
    //改变屏幕透明度
    public void startAlphAnimotion() {
        WindowManager.LayoutParams ll = getWindow().getAttributes();
        ll.alpha = 0.7f;
        getWindow().setAttributes(ll);
    }


    //恢复屏幕透明度
    public void endAlphAnimotion() {
        WindowManager.LayoutParams ll = getWindow().getAttributes();
        ll.alpha = 1;
        getWindow().setAttributes(ll);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode== Activity.RESULT_OK){
            if (requestCode==TOPHOTOGRAPH_01){
                Bundle extras = data.getExtras();
                Bitmap bitmap = (Bitmap) extras.get("data");
                mHead.setImageBitmap(bitmap);
            }
        }
    }
}
