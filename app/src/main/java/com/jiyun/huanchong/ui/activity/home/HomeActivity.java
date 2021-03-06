package com.jiyun.huanchong.ui.activity.home;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.jiyun.huanchong.R;
import com.jiyun.huanchong.bean.ZhuYeBean_01;
import com.jiyun.huanchong.bean.Zhuyebean;
import com.jiyun.huanchong.ui.activity.fosterteacher.FosterteacherActivity;
import com.jiyun.huanchong.ui.activity.home.adapter.MyAdapter;
import com.jiyun.huanchong.ui.activity.home.adapter.MyAdapter_01;
import com.jiyun.huanchong.ui.activity.home.pserenter.Pserenter;
import com.jiyun.huanchong.ui.activity.home.view.IView;
import com.jiyun.huanchong.ui.activity.konw.KonwActivity;
import com.jiyun.huanchong.ui.activity.login.LoginActivity;
import com.jiyun.huanchong.ui.activity.news.NewsActivity;
import com.jiyun.huanchong.ui.activity.order.OrderActivity;
import com.jiyun.huanchong.ui.activity.personalInfomation.PersonalInfomationActivity;
import com.jiyun.huanchong.ui.activity.pet.PetActivity;
import com.jiyun.huanchong.ui.activity.setting.SettingActivity;
import com.jiyun.huanchong.ui.activity.wallet.WalletActivity;
import com.jiyun.huanchong.ui.activity.xiangqing.XiangQingActivity;
import com.jiyun.huanchong.ui.base.BaseActivity;
import com.jiyun.huanchong.utils.CircleBitmapTransformation;
import com.zaaach.citypicker.CityPickerActivity;

import java.util.ArrayList;


/**
 * Created by mengYao on 2017/12/17.
 */

public class HomeActivity extends BaseActivity implements  View.OnClickListener,IView ,CompoundButton.OnCheckedChangeListener {
    private DrawerLayout drawer_layout;
    private ImageView mMenuHead;
    private ImageView mPersonalCenter;
    private RelativeLayout mMessageContainer;
    private RelativeLayout mPetContainer;
    private RelativeLayout mOrderContainer;
    private RelativeLayout mWalletContainer;
    private RelativeLayout mKonwContainer;
    private RelativeLayout mSettingContainer;
    private Button mBtnSwitchUser;
    private RelativeLayout mInfomation;
    private TextView mMenuName;
    private TextView mMenuPhone;
    private RelativeLayout mNoLoginContainer;
    private ImageView fujinyouxuan;
    private ImageView chongwuleixing;
    private ImageView shaixuan;
    private PopupWindow mPopWindow;
    private Boolean state = false;
    private static final int REQUEST_CODE_PICK_CITY = 0;
    private TextView tv2;

    private String username;
    private String iconurl;
    private String name;
    private String phone;
    private boolean isLogin;
    private CheckBox NationalDay;

    private ListView zhuyelist;
    private Pserenter pserenter;
    private ArrayList<Zhuyebean.DescBean> list = new ArrayList<>();
    private ArrayList<ZhuYeBean_01.DescBean> list_01 = new ArrayList<>();
    private final int UPDATEREQUESTCODE = 101;


    private TextView Reset;
    private CheckBox AutumnFestival;
    private CheckBox DragonBoatFestival;
    private CheckBox LaborDay;
    private CheckBox QingmingFestival;
    private CheckBox SpringFestival;
    private CheckBox NewDan;
    private CheckBox Shuttle;
    private CheckBox shower;
    private ImageView mMAP;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void findViewById() {
        pserenter = new Pserenter(this);
        drawer_layout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mPersonalCenter = (ImageView) findViewById(R.id.mPersonalCenter);
        mInfomation = (RelativeLayout) findViewById(R.id.mInfomation);
        mMenuHead = (ImageView) findViewById(R.id.mMenuHead);
        zhuyelist = (ListView) findViewById(R.id.zhuyelist);
        mMAP = (ImageView)findViewById(R.id.mMap);
        mMenuName = (TextView) findViewById(R.id.mMenuName);
        mMenuPhone = (TextView) findViewById(R.id.mMenuPhone);
        mMessageContainer = (RelativeLayout) findViewById(R.id.mMessageContainer);
        mPetContainer = (RelativeLayout) findViewById(R.id.mPetContainer);
        mOrderContainer = (RelativeLayout) findViewById(R.id.mOrderContainer);
        mWalletContainer = (RelativeLayout) findViewById(R.id.mWalletContainer);
        mKonwContainer = (RelativeLayout) findViewById(R.id.mKonwContainer);
        mSettingContainer = (RelativeLayout) findViewById(R.id.mSettingContainer);
        mBtnSwitchUser = (Button) findViewById(R.id.mBtnSwitchUser);
        mNoLoginContainer = (RelativeLayout) findViewById(R.id.mNoLoginContainer);
        fujinyouxuan = (ImageView) findViewById(R.id.fujinyouxuan);
        chongwuleixing = (ImageView) findViewById(R.id.chongwuleixing);
        shaixuan = (ImageView) findViewById(R.id.shaixuan);
        mInfomation.setVisibility(View.GONE);
        mBtnSwitchUser.setVisibility(View.GONE);

        mMAP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(HomeActivity.this, CityPickerActivity.class),
                        REQUEST_CODE_PICK_CITY);
            }
        });





        SharedPreferences userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
        username = userInfo.getString("username", null);
        String phone = userInfo.getString("userphone", null);
        iconurl = userInfo.getString("iconurl", null);
        if (username != null && !username.equals("") && phone != null) {
            if (iconurl != null) {
                Glide.with(this).load(iconurl).transform(new CircleBitmapTransformation(this)).into(mMenuHead);
            }
            mMenuName.setText(username);
            mNoLoginContainer.setVisibility(View.GONE);
            mMenuPhone.setText(phone);
            mInfomation.setVisibility(View.VISIBLE);
            mBtnSwitchUser.setVisibility(View.VISIBLE);
            isLogin = true;
        }
        if (iconurl != null && name != null && !iconurl.equals("") && !name.equals("")) {
            Glide.with(this).load(this.iconurl).into(mMenuHead);
            mMenuName.setText(name);
            mNoLoginContainer.setVisibility(View.GONE);
            mInfomation.setVisibility(View.VISIBLE);
            mBtnSwitchUser.setVisibility(View.VISIBLE);
            isLogin = true;
        }
        mPersonalCenter.setOnClickListener(HomeActivity.this);
        mInfomation.setOnClickListener(this);
        mMessageContainer.setOnClickListener(this);
        mPetContainer.setOnClickListener(this);
        mOrderContainer.setOnClickListener(this);
        mWalletContainer.setOnClickListener(this);
        mKonwContainer.setOnClickListener(this);
        mSettingContainer.setOnClickListener(this);
        mBtnSwitchUser.setOnClickListener(this);
        mNoLoginContainer.setOnClickListener(this);


        fujinyouxuan.setOnClickListener(new View.OnClickListener() {

            private ListView listview;

            @Override
            public void onClick(View view) {

                if (state == false) {
                    fujinyouxuan.setImageResource(R.mipmap.live_china_detail_up);
                    View contentView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.popupw_01, null);
                    mPopWindow = new PopupWindow(contentView, DrawerLayout.LayoutParams.WRAP_CONTENT, DrawerLayout.LayoutParams.WRAP_CONTENT);
                    mPopWindow.setContentView(contentView);
                    //设置各个控件的点击响应
                    listview = (ListView) contentView.findViewById(R.id.listview);

                    final ArrayList<Person> strings = new ArrayList<>();
                    strings.add(new Person("附近优选"));
                    strings.add(new Person("好评优选"));
                    strings.add(new Person("订单优选"));
                    strings.add(new Person("价格从高到低"));
                    strings.add(new Person("价格从低到高"));

                    final ListAdapter listAdapter = new ListAdapter(strings, HomeActivity.this);
                    listview.setAdapter(listAdapter);

                    listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        int currentNum = -1;

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            String title = strings.get(i).getTitle();
                            if (title.equals("附近优先")) {
                                pserenter.get("0", "40.116384", "116.250374", "10", "distance asc");
                            } else if (title.equals("好评优先")) {
                                pserenter.get("0", "40.116384", "116.250374", "10", "score desc");
                            } else if (title.equals("订单优先")) {
                                pserenter.get("0", "40.116384", "116.250374", "10", "orderCount desc");
                            } else if (title.equals("价格从低到高")) {
                                pserenter.get("0", "40.116384", "116.250374", "10", "price asc");
                            } else if (title.equals("价格从高到低")) {
                                pserenter.get("0", "40.116384", "116.250374", "10", "price desc");
                            }


                            for (Person person : strings) { //遍历list集合中的数据
                                person.setChecked(false);//全部设为未选中
                            }

                            if (currentNum == -1) { //选中
                                strings.get(i).setChecked(true);
                                currentNum = i;
                            } else if (currentNum == i) { //同一个item选中变未选中
                                for (Person person : strings) {
                                    person.setChecked(false);
                                }
                                currentNum = -1;
                            } else if (currentNum != i) { //不是同一个item选中当前的，去除上一个选中的
                                for (Person person : strings) {
                                    person.setChecked(false);
                                }
                                strings.get(i).setChecked(true);
                                currentNum = i;
                            }
                            Toast.makeText(HomeActivity.this, strings.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                            listAdapter.notifyDataSetChanged();//刷新adapter


                        }

                    });


                    mPopWindow.setBackgroundDrawable(new ColorDrawable(0x000000));
                    mPopWindow.setOutsideTouchable(true);
                    //显示PopupWindow
                    mPopWindow.showAsDropDown(findViewById(R.id.linl));
                    // mPopWindow.showAtLocation(findViewById(R.id.linl), Gravity., 0, 0);

                    //mPopWindow.dismiss();
                    state = true;
                } else {
                    fujinyouxuan.setImageResource(R.mipmap.down_arrow);
                    mPopWindow.dismiss();

                    state = false;
                }
            }
        });

        chongwuleixing.setOnClickListener(new View.OnClickListener() {

            private ListView listview_01;

            @Override
            public void onClick(View view) {


                if (state == false) {
                    chongwuleixing.setImageResource(R.mipmap.live_china_detail_up);
                    View contentView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.popupw, null);
                    mPopWindow = new PopupWindow(contentView, DrawerLayout.LayoutParams.WRAP_CONTENT, DrawerLayout.LayoutParams.WRAP_CONTENT);
                    mPopWindow.setContentView(contentView);
                    //设置各个控件的点击响应
                    listview_01 = (ListView) contentView.findViewById(R.id.listview_01);


                    final ArrayList<Person> strings = new ArrayList<>();
                    strings.add(new Person("小型犬"));
                    strings.add(new Person("大型犬"));
                    strings.add(new Person("中型犬"));
                    strings.add(new Person("猫"));
                    strings.add(new Person("小宠"));
                    strings.add(new Person("幼犬"));

                    final ListAdapter listAdapter = new ListAdapter(strings, HomeActivity.this);
                    listview_01.setAdapter(listAdapter);

                    listview_01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        int currentNum = -1;

                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                            pserenter.getlist("0", "10", "");


                            for (Person person : strings) { //遍历list集合中的数据
                                person.setChecked(false);//全部设为未选中
                            }

                            if (currentNum == -1) { //选中
                                strings.get(i).setChecked(true);
                                currentNum = i;
                            } else if (currentNum == i) { //同一个item选中变未选中
                                for (Person person : strings) {
                                    person.setChecked(false);
                                }
                                currentNum = -1;
                            } else if (currentNum != i) { //不是同一个item选中当前的，去除上一个选中的
                                for (Person person : strings) {
                                    person.setChecked(false);
                                }
                                strings.get(i).setChecked(true);
                                currentNum = i;
                            }
                            Toast.makeText(HomeActivity.this, strings.get(i).getTitle(), Toast.LENGTH_SHORT).show();
                            listAdapter.notifyDataSetChanged();//刷新adapter


                        }

                    });


                    mPopWindow.setBackgroundDrawable(new ColorDrawable(0x000000));
                    mPopWindow.setOutsideTouchable(true);
                    mPopWindow.showAsDropDown(findViewById(R.id.linl));
                    state = true;
                } else {
                    chongwuleixing.setImageResource(R.mipmap.down_arrow);
                    mPopWindow.dismiss();

                    state = false;
                }

            }
        });
        shaixuan.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View view) {

                if (state == false) {
                    shaixuan.setImageResource(R.mipmap.live_china_detail_up);
                    View contentView = LayoutInflater.from(HomeActivity.this).inflate(R.layout.popupw_02, null);
                    mPopWindow = new PopupWindow(contentView, DrawerLayout.LayoutParams.MATCH_PARENT, DrawerLayout.LayoutParams.MATCH_PARENT);
                    mPopWindow.setContentView(contentView);
                    //设置各个控件的点击响应
                    TextView tv1 = (TextView) contentView.findViewById(R.id.Choosecity);
                    tv2 = (TextView) contentView.findViewById(R.id.Location);
                    shower = (CheckBox) contentView.findViewById(R.id.shower);
                    Shuttle = (CheckBox) contentView.findViewById(R.id.Shuttle);
                    NewDan = (CheckBox) contentView.findViewById(R.id.NewDan);
                    SpringFestival = (CheckBox) contentView.findViewById(R.id.SpringFestival);
                    QingmingFestival = (CheckBox) contentView.findViewById(R.id.QingmingFestival);
                    LaborDay = (CheckBox) contentView.findViewById(R.id.LaborDay);
                    NationalDay = (CheckBox) contentView.findViewById(R.id.NationalDay);
                    DragonBoatFestival = (CheckBox) contentView.findViewById(R.id.DragonBoatFestival);
                    AutumnFestival = (CheckBox) contentView.findViewById(R.id.AutumnFestival);
                    Reset = (TextView) contentView.findViewById(R.id.Reset);
                    shower.setOnCheckedChangeListener(HomeActivity.this);
                    Shuttle.setOnCheckedChangeListener(HomeActivity.this);
                    LaborDay.setOnCheckedChangeListener(HomeActivity.this);
                    NewDan.setOnCheckedChangeListener(HomeActivity.this);
                    NationalDay.setOnCheckedChangeListener(HomeActivity.this);
                    SpringFestival.setOnCheckedChangeListener(HomeActivity.this);
                    QingmingFestival.setOnCheckedChangeListener(HomeActivity.this);
                    DragonBoatFestival.setOnCheckedChangeListener(HomeActivity.this);
                    AutumnFestival.setOnCheckedChangeListener(HomeActivity.this);
                    Reset.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            shower.setChecked(false);
                            Shuttle.setChecked(false);
                            NewDan.setChecked(false);
                            SpringFestival.setChecked(false);
                            QingmingFestival.setChecked(false);
                            DragonBoatFestival.setChecked(false);
                            AutumnFestival.setChecked(false);
                            LaborDay.setChecked(false);
                            NationalDay.setChecked(false);
                        }
                    });


                    tv1.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

//启动
                            startActivityForResult(new Intent(HomeActivity.this, CityPickerActivity.class),
                                    REQUEST_CODE_PICK_CITY);
                        }
                    });
                    mPopWindow.setBackgroundDrawable(new ColorDrawable(0x000000));
                    mPopWindow.setOutsideTouchable(true);
                    //显示PopupWindow
                    mPopWindow.showAsDropDown(findViewById(R.id.linl));
                    // mPopWindow.showAtLocation(findViewById(R.id.linl), Gravity., 0, 0);

                    //mPopWindow.dismiss();
                    state = true;
                } else {


                    shaixuan.setImageResource(R.mipmap.down_arrow);
                    mPopWindow.dismiss();

                    state = false;
                }
            }
        });


    }

    //重写onActivityResult方法
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_PICK_CITY && resultCode == RESULT_OK) {
            if (data != null) {
                String city = data.getStringExtra(CityPickerActivity.KEY_PICKED_CITY);
                tv2.setText("当前选择：" + city);
            }
        }
        if (requestCode == UPDATEREQUESTCODE) {
            if (data != null) {
                String head = data.getStringExtra("head");
                String name = data.getStringExtra("name");
                String phone = data.getStringExtra("phone");
                Glide.with(this).load(head).transform(new CircleBitmapTransformation(this)).into(mMenuHead);
                mMenuName.setText(name);
                mMenuPhone.setText(phone);
            }
        }
    }

    @Override
    protected void init() {

        pserenter.get("0", "116.249706", "40.116585", "10", "distance asc");


    }

    @Override
    protected void loadData() {
        mPersonalCenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (drawer_layout.isDrawerOpen(Gravity.LEFT)) {
                    drawer_layout.closeDrawer(Gravity.LEFT);

                } else {
                    drawer_layout.openDrawer(Gravity.LEFT);
                }

            }
        });
    }

    @Override
    public void onClick(View v) {
//        SharedPreferences userInfo = getSharedPreferences("userInfo", MODE_PRIVATE);
//        SharedPreferences disanfangInfo = getSharedPreferences("disanfangInfo", MODE_PRIVATE);
//        username = userInfo.getString("username", null);
//        phone = userInfo.getString("phone", null);
//        iconurl = disanfangInfo.getString("iconurl", null);
//        name = disanfangInfo.getString("name", null);
        switch (v.getId()) {
            case R.id.mInfomation:
                startActivityForResult(new Intent(this, PersonalInfomationActivity.class), UPDATEREQUESTCODE);
                break;
            case R.id.mMessageContainer:
                if (isLogin) {
                    startActivity(new Intent(this, NewsActivity.class));
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.mPetContainer:
                if (isLogin) {
                    startActivity(new Intent(this, PetActivity.class));
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.mOrderContainer:

                if (isLogin) {
                    startActivity(new Intent(this, OrderActivity.class));
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.mWalletContainer:
                if (isLogin) {
                    startActivity(new Intent(this, WalletActivity.class));
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.mKonwContainer:
                if (isLogin) {
                    startActivity(new Intent(this, KonwActivity.class));
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.mSettingContainer:
                if (isLogin) {
                    startActivity(new Intent(this, SettingActivity.class));
                } else {
                    startActivity(new Intent(this, LoginActivity.class));
                }
                break;
            case R.id.mBtnSwitchUser:
                startActivity(new Intent(this, FosterteacherActivity.class));
                break;
            case R.id.mNoLoginContainer:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case  R.id.Reset:


                break;


        }
    }


    @Override
    public void getlist(final ArrayList<Zhuyebean.DescBean> zhuyebean) {
        list.clear();
        list.addAll(zhuyebean);
        final Zhuyebean zhuyebean1 = new Zhuyebean();
        MyAdapter myAdapter = new MyAdapter(list, this);
        zhuyelist.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        zhuyelist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(HomeActivity.this, XiangQingActivity.class);
//                intent.putExtra("aa",list);

                startActivity(intent);
            }
        });
    }

    @Override
    public void get(ZhuYeBean_01 zhuyebean_01) {

        list.clear();
        ArrayList<ZhuYeBean_01.DescBean> desc = (ArrayList<ZhuYeBean_01.DescBean>) zhuyebean_01.getDesc();
        list_01.addAll(desc);
        MyAdapter_01 myAdapter = new MyAdapter_01(list_01, this);
        zhuyelist.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();

    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (shower.isChecked()) {

            shower.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            shower.setBackgroundResource(R.drawable.login_item_shap);
        }
        if (Shuttle.isChecked()) {

            Shuttle.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            Shuttle.setBackgroundResource(R.drawable.login_item_shap);
        }
        if (NewDan.isChecked()) {

            NewDan.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            NewDan.setBackgroundResource(R.drawable.login_item_shap);
        }
        if (SpringFestival.isChecked()) {

            SpringFestival.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            SpringFestival.setBackgroundResource(R.drawable.login_item_shap);
        }
        if (QingmingFestival.isChecked()) {

            QingmingFestival.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            QingmingFestival.setBackgroundResource(R.drawable.login_item_shap);
        }
        if (DragonBoatFestival.isChecked()) {

            DragonBoatFestival.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            DragonBoatFestival.setBackgroundResource(R.drawable.login_item_shap);
        }
        if (AutumnFestival.isChecked()) {

            AutumnFestival.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            AutumnFestival.setBackgroundResource(R.drawable.login_item_shap);
        }
        if (LaborDay.isChecked()) {

            LaborDay.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            LaborDay.setBackgroundResource(R.drawable.login_item_shap);
        }
        if (NationalDay.isChecked()) {

            NationalDay.setBackgroundResource(R.drawable.login_btn_shape);
        } else {
            NationalDay.setBackgroundResource(R.drawable.login_item_shap);
        }




    }


}



