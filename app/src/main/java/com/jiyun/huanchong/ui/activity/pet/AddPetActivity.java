package com.jiyun.huanchong.ui.activity.pet;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.ContentUris;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.codbking.widget.DatePickDialog;
import com.codbking.widget.bean.DateType;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static com.jiyun.huanchong.constants.Constants.REQUESTCODE;

public class AddPetActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout btnJump1;
    private RelativeLayout btnJump2;
    private ImageView back;
    private RelativeLayout paizhao;
     public  static final int  TAKE_PHOTO = 1;
     public  static final int  CHOOS_PHOTO = 2;
    private Bitmap bitmap;
    private ImageView Headportrait;
    private Uri uriForFile;
    private RelativeLayout chushengriqi;

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
       paizhao = (RelativeLayout) findViewById(R.id.paizhao);
        Headportrait = (ImageView) findViewById(R.id.Headportrait);
        chushengriqi = (RelativeLayout) findViewById(R.id.chushengriqi);

        back = (ImageView) findViewById(R.id.back);

        btnJump1.setOnClickListener(this);
        btnJump2.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    @Override
    protected void loadData() {
        chushengriqi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickDialog dialog = new DatePickDialog(AddPetActivity.this);
                //设置上下年分限制
                dialog.setYearLimt(5);
                //设置标题
                dialog.setTitle("选择时间");
                //设置类型
                dialog.setType(DateType.TYPE_ALL);
                //设置消息体的显示格式，日期格式
                dialog.setMessageFormat("yyyy-MM-dd HH:mm");
                //设置选择回调
                dialog.setOnChangeLisener(null);
                //设置点击确定按钮回调
                dialog.setOnSureLisener(null);
                dialog.show();


            }
        });
        paizhao.setOnClickListener(new View.OnClickListener() {

            private RelativeLayout album;
            private RelativeLayout photograph;
            private TextView cancel;
            private TextView text14;
            private PopupWindow pop;

            @Override
            public void onClick(View view) {
                View inflate = LayoutInflater.from(AddPetActivity.this).inflate(R.layout.popup,null);
                pop = new PopupWindow(inflate,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        WindowManager.LayoutParams.MATCH_PARENT,
                        true);
                text14 = (TextView)inflate.findViewById(R.id.textView14);
                cancel = (TextView)inflate.findViewById(R.id.cancel);
                photograph = (RelativeLayout)inflate.findViewById(R.id.photograph);
                album = (RelativeLayout)inflate.findViewById(R.id.album);
                pop.setOutsideTouchable(true);
                //pop.setBackgroundDrawable(new ColorDrawable(0x000000));
                pop.setBackgroundDrawable(new ColorDrawable(0xffffff));//支持点击Back虚拟键退出
                pop.showAtLocation(inflate,Gravity.BOTTOM, 0, 0);
                startAlphAnimotion();

                pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        endAlphAnimotion();
                    }
                });
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        pop.dismiss();
                    }
                });

photograph.setOnClickListener(new View.OnClickListener() {



    @Override
    public void onClick(View view) {
        //创建新的文件夹
        File outputImage = new File(getExternalCacheDir(), "output_img.jpg");
        try {
            if (outputImage.exists()) {
                outputImage.delete();
            }
            outputImage.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获取照片存放的url
        if (Build.VERSION.SDK_INT >= 24) {
            uriForFile = FileProvider.getUriForFile(AddPetActivity.this, "com.example.cameraalbumtest.fileprovider", outputImage);
        } else {
            uriForFile = Uri.fromFile(outputImage);
        }
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uriForFile);
        startActivityForResult(intent, TAKE_PHOTO);
        pop.dismiss();


    }
});

album.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //这个是手机相册的

        //申请手机权限
        if (ContextCompat.checkSelfPermission(AddPetActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(AddPetActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);
        }else {
            openAlbum();
        }
    }
});







            }
        });

    }  //改变屏幕透明度
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
    private void openAlbum() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        //设置照片存放的目录
        startActivityForResult(intent,CHOOS_PHOTO);//打开手机相册
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults.length>0&&grantResults[i] == PackageManager
                            .PERMISSION_GRANTED){
                        Toast.makeText(this,"You denied the permission",Toast.LENGTH_SHORT).show();
                    }else {
                        openAlbum();
                    }
                }
                break;
            default:
        }

    }


    /**
     * 用onActivityResult()接收传回的图像，当用户拍完照片，或者取消后，系统都会调用这个函数
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case TAKE_PHOTO:
                if (resultCode == RESULT_OK) {
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uriForFile));
                        Headportrait.setImageBitmap(bitmap);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case CHOOS_PHOTO:
                if (resultCode == RESULT_OK){
                    //判断手机版本号
                    if (Build.VERSION.SDK_INT >= 19){
                        //4.4及以上系统使用这个方法处理图片
                        hanleImageOnKitKat(data);
                    }else {
                        //4.4以下系统使用这个方法处理图片
                        handleImageBeforeKitKat(data);
                    }
                }
                break;
            default:
                break;

        }

    }
    @TargetApi(19)
    private void hanleImageOnKitKat(Intent data) {
        String imagePath = null;
        Uri uri = data.getData();
        if (DocumentsContract.isDocumentUri(this,uri)){
            //如果是document类型的uri，则通过document id处理
            String docid = DocumentsContract.getDocumentId(uri);
            if ("com.android.providers.media.documents".equals(uri.getAuthority())){
                String id = docid.split(":")[1];//解析出数字格式的ID
                String selection = MediaStore.Images.Media._ID+ "="+id;
                imagePath = getImagePath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,selection);
            }else if ("com.android.providers.downloads.documents".equals(uri.getAuthority())){
                Uri contentUri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"),Long.valueOf(docid));
                imagePath = getImagePath(contentUri,null);
            }
        }else if ("content".equalsIgnoreCase(uri.getScheme())){
            //如果是content类型的uri，则使用普通的处理方式
            imagePath = getImagePath(uri,null);
        }else if ("file".equalsIgnoreCase(uri.getScheme())){
            //如果是file类型的uri，直接获取图片路径即可
            imagePath = uri.getPath();
        }
        displayImage(imagePath);//根据图片路径显示图片
    }
    private void handleImageBeforeKitKat(Intent data) {
        Uri uri = data.getData();
        String imagePath = getImagePath(uri,null);
        displayImage(imagePath);
    }
    private String getImagePath(Uri uri, String selection){
        String path = null;
        //通过Uri 和 selection 来获取真实的图片路径
        Cursor cursor = getContentResolver().query(uri,null,selection,null,null);
        if (cursor != null){
            if (cursor.moveToFirst()){
                path = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
            }
            cursor.close();
        }
        return path;
    }
    private void  displayImage(String imagePath){
        if (imagePath != null){
            Bitmap bitmap = BitmapFactory.decodeFile(imagePath);
            Headportrait.setImageBitmap(bitmap);
        }else {
            Toast.makeText(this,"failed to get image", Toast.LENGTH_SHORT).show();
        }
    }






}
