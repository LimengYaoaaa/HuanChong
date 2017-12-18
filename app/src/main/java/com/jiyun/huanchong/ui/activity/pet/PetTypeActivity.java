package com.jiyun.huanchong.ui.activity.pet;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.activity.pet.fragment.CatFragment;
import com.jiyun.huanchong.ui.activity.pet.fragment.DogFragment;
import com.jiyun.huanchong.ui.activity.pet.fragment.SmallpetFragment;
import com.jiyun.huanchong.ui.activity.pet.fragment.adapter.ViewPageAdapter;
import com.jiyun.huanchong.ui.base.BaseActivity;

import java.util.ArrayList;

public class PetTypeActivity extends BaseActivity {

    private ImageView imageView;
    private TabLayout tab_demo1;
    private ViewPager viewpage;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pet_type;
    }

    @Override
    protected void findViewById() {
        imageView = (ImageView)findViewById(R.id.imageView);
        tab_demo1 = (TabLayout)findViewById(R.id.tab_demo1);
        viewpage = (ViewPager)findViewById(R.id.viewpage);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("狗");
        strings.add("猫");
        strings.add("小宠");
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new CatFragment());
        fragments.add(new DogFragment());
        fragments.add(new SmallpetFragment());
        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(), strings, fragments);
        viewpage.setAdapter(viewPageAdapter);
        tab_demo1.setupWithViewPager(viewpage);


        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



}

