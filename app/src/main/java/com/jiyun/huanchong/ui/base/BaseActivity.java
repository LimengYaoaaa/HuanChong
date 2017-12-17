package com.jiyun.huanchong.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.jiyun.huanchong.app.App;

/**
 * Created by mengYao on 2017/12/7.
 */

public abstract class BaseActivity extends AppCompatActivity{
    private BaseFragment lastFragment;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        App.context=this;
        findViewById();
        init();
        loadData();
    }

    /**
     * 获取要显示的布局
     * @return
     */
    protected abstract int getLayoutId();

    /**
     * 获取布局里的控件id
     */
    protected abstract void findViewById();

    /**
     * 初始化方法
     */
    protected abstract void init();

    /**
     * 加载数据的方法
     */
    protected abstract void loadData();

    public void changeFragment(int containerId,Class<? extends BaseFragment> clz,boolean isRelace,boolean toBack,Bundle params){
        String simpleName = clz.getSimpleName();
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        BaseFragment currentFragment = (BaseFragment) manager.findFragmentByTag(simpleName);
        if (currentFragment==null){
            try {
                currentFragment = clz.newInstance();
                transaction.add(containerId,currentFragment);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (isRelace){
            transaction.replace(containerId,currentFragment);
        }else{
            if (lastFragment!=null){
                transaction.hide(lastFragment);
                transaction.show(currentFragment);
            }
        }
        if (params!=null){
            currentFragment.setParams(params);
        }
        if (toBack){
            transaction.addToBackStack(simpleName);
        }
        transaction.commit();
        lastFragment=currentFragment;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
