package com.jiyun.huanchong.ui.activity.personalInfomation;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.utils.CircleBitmapTransformation;

import static com.jiyun.huanchong.constants.Constants.REQUESTCODE;

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
    private ImageView mHead;
    private String path;
    private String photoName;
    private final String TAG="Tag";
    private Uri uri;
    private Uri originalUri;
    private Bitmap bitmap;
    private final int TOPHOTOGRAPH=101;
    private final int TOALBUM=102;
    private final int TOUPDATENAME=103;
    private final int TOUPDATEADDRESS=104;
    private final int TOUPDATEQQ=105;
    private final int TOUPDATEWX=106;
    private TextView mNameInfo;
    private TextView mSexInfo;
    private TextView mDateInfo;
    private TextView mPhoneInfo;
    private TextView mWxInfo;
    private TextView mQqInfo;
    private TextView mAddressInfo;
    private TextView mTishi;

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
        mNameInfo = (TextView) findViewById(R.id.mNameInfo);
        mSexInfo = (TextView) findViewById(R.id.mSexInfo);
        mDateInfo = (TextView) findViewById(R.id.mDateInfo);
        mPhoneInfo = (TextView) findViewById(R.id.mPhoneInfo);
        mWxInfo = (TextView) findViewById(R.id.mWxInfo);
        mQqInfo = (TextView) findViewById(R.id.mQqInfo);
        mAddressInfo = (TextView) findViewById(R.id.mAddressInfo);
        mTishi = (TextView) findViewById(R.id.mTishi);
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
                pop.setFocusable(true);
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
                openTakePhoto();
                break;
            case R.id.mToAlbum:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, TOALBUM);
                break;
            case R.id.mDismissPopup:
                if (pop!=null&&pop.isShowing()){
                    pop.dismiss();
                }
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
    public void  endAlphAnimotion() {
        WindowManager.LayoutParams ll = getWindow().getAttributes();
        ll.alpha = 1;
        getWindow().setAttributes(ll);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==TOPHOTOGRAPH){
            if(data==null){
                return;
            }
            if (data.getData() != null || data.getExtras() != null) { //防止没有返回结果
                originalUri = data.getData();
                if (originalUri != null) {
                    //拿到图片
                    bitmap = BitmapFactory.decodeFile(originalUri.getPath());
                    mHead.setImageResource(R.mipmap.ic_launcher);
                }
                if (bitmap == null) {
                    Bundle bundle = data.getExtras();
                    if (bundle != null) {
                        bitmap = (Bitmap) bundle.get("data");
                        Bitmap bitmap1 = new CircleBitmapTransformation(this).getBitmap(this.bitmap);
                        mHead.setImageBitmap(bitmap1);
                    } else {
                        Toast.makeText(getApplicationContext(), "找不到图片", Toast.LENGTH_SHORT).show();
                    }
                }
                //处理图片
                //裁剪图片
            }
        }
        if (requestCode==TOALBUM){
            if (data==null){
                return;
            }
            Uri uri = data.getData();
            Cursor cursor = getContentResolver().query(uri, null, null, null,null);
            if (cursor != null && cursor.moveToFirst()) {
                String path = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA));
                Glide.with(this).load(path).transform(new CircleBitmapTransformation(this)).into(mHead);
            }
        }
    }
    private void openTakePhoto() {
        /**
         * 在启动拍照之前最好先判断一下sdcard是否可用
         */
        String state = Environment.getExternalStorageState(); //拿到sdcard是否可用的状态码
        if (state.equals(Environment.MEDIA_MOUNTED)) {   //如果可用
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            startActivityForResult(intent, TOPHOTOGRAPH);
        } else {
            Toast.makeText(this, "sdcard不可用", Toast.LENGTH_SHORT).show();
        }
    }
}
