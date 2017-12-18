package com.jiyun.huanchong.ui.activity.pet.fragment.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by hp on 2017/12/17.
 */

public class ViewPageAdapter extends FragmentPagerAdapter {

    private ArrayList<String> list;
    private  ArrayList <Fragment>arrayList;

    public ViewPageAdapter(FragmentManager fm, ArrayList<String> list, ArrayList<Fragment> arrayList) {
        super(fm);
        this.list = list;
        this.arrayList = arrayList;
    }

    @Override
    public Fragment getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position);
    }
}
