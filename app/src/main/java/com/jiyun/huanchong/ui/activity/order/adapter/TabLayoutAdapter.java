package com.jiyun.huanchong.ui.activity.order.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by hp on 2017/12/19.
 */

public class TabLayoutAdapter extends FragmentPagerAdapter {
    private ArrayList<String> arrayList;
    private  ArrayList<Fragment> list;

    public TabLayoutAdapter(FragmentManager fm, ArrayList<String> arrayList, ArrayList<Fragment> list) {
        super(fm);
        this.arrayList = arrayList;
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return arrayList.get(position);
    }
}
