package com.jiyun.huanchong.ui.activity.xiangqing;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.youth.banner.Banner;

/**
 * Created by hp on 2017/12/22.
 */

public class XiangQingActivity extends BaseActivity implements View.OnClickListener {

    private ImageView ign_out;
    private Banner banner;
    private ImageView headPortrait;
    private TextView name;
    private CheckBox imageView2;
    private CheckBox imageView7;
    private CheckBox imageView5;
    private CheckBox imageView4;
    private CheckBox imageView3;
    private View view;
    private ImageView imageView6;
    private TextView textView16;
    private TextView textView17;
    private TextView number;
    private TextView textView19;
    private ImageView enter_a_review;
    private ImageView imageView;
    private TextView daPrice;
    private ImageView zhongimageView;
    private TextView zhongPrice;
    private ImageView catimageView;
    private TextView catPrice;
    private ImageView showerImg;
    private TextView daTake_a_showerPrice;
    private ImageView zhongbathe;
    private TextView zhong_Take_a_showerPrice;
    private ImageView xiaoBathe;
    private TextView xiao_Take_a_showerPrice;
    private ImageView shuttle;
    private TextView Shuttle_cat_Price;
    private ImageView xiaoShuttle;
    private TextView Study;
    private ImageView jiaAddress;
    private TextView address;
    private TextView briefIntroduction;
    private LinearLayout Contact_him;
    private Button makeAnAappointment;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_details_of_afoster_teacher;
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_afoster_teacher);
        initView();
    }

    private void initView() {
        ign_out = (ImageView) findViewById(R.id.ign_out);
        banner = (Banner) findViewById(R.id.banner);
        headPortrait = (ImageView) findViewById(R.id.headPortrait);
        name = (TextView) findViewById(R.id.name);
        imageView2 = (CheckBox) findViewById(R.id.imageView2);
        imageView7 = (CheckBox) findViewById(R.id.imageView7);
        imageView5 = (CheckBox) findViewById(R.id.imageView5);
        imageView4 = (CheckBox) findViewById(R.id.imageView4);
        imageView3 = (CheckBox) findViewById(R.id.imageView3);
        view = (View) findViewById(R.id.view);
        imageView6 = (ImageView) findViewById(R.id.imageView6);
        textView16 = (TextView) findViewById(R.id.textView16);
        textView17 = (TextView) findViewById(R.id.textView17);
        number = (TextView) findViewById(R.id.number);
        textView19 = (TextView) findViewById(R.id.textView19);
        enter_a_review = (ImageView) findViewById(R.id.enter_a_review);
        imageView = (ImageView) findViewById(R.id.imageView);
        daPrice = (TextView) findViewById(R.id.daPrice);
        zhongimageView = (ImageView) findViewById(R.id.zhongimageView);
        zhongPrice = (TextView) findViewById(R.id.zhongPrice);
        catimageView = (ImageView) findViewById(R.id.catimageView);
        catPrice = (TextView) findViewById(R.id.catPrice);
        showerImg = (ImageView) findViewById(R.id.showerImg);
        daTake_a_showerPrice = (TextView) findViewById(R.id.daTake_a_showerPrice);
        zhongbathe = (ImageView) findViewById(R.id.zhongbathe);
        zhong_Take_a_showerPrice = (TextView) findViewById(R.id.zhong_Take_a_showerPrice);
        xiaoBathe = (ImageView) findViewById(R.id.xiaoBathe);
        xiao_Take_a_showerPrice = (TextView) findViewById(R.id.xiao_Take_a_showerPrice);
        shuttle = (ImageView) findViewById(R.id.shuttle);
        Shuttle_cat_Price = (TextView) findViewById(R.id.Shuttle_cat_Price);
        xiaoShuttle = (ImageView) findViewById(R.id.xiaoShuttle);
        Study = (TextView) findViewById(R.id.Study);
        jiaAddress = (ImageView) findViewById(R.id.jiaAddress);
        address = (TextView) findViewById(R.id.address);
        briefIntroduction = (TextView) findViewById(R.id.briefIntroduction);
        Contact_him = (LinearLayout) findViewById(R.id.Contact_him);
        makeAnAappointment = (Button) findViewById(R.id.makeAnAappointment);

        makeAnAappointment.setOnClickListener(this);


//        Intent intent = getIntent();
//        ArrayList<Zhuyebean.DescBean> aa = (ArrayList<Zhuyebean.DescBean>) intent.getSerializableExtra("aa");

//        double price = aa.get(0).getPrice();
//        daPrice.setText( price);
//        zhongPrice.setText((int) price);
//        catPrice.setText((int) price);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.makeAnAappointment:

                break;
        }
    }
}
