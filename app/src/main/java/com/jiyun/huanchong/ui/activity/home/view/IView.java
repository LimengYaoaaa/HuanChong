package com.jiyun.huanchong.ui.activity.home.view;

import com.jiyun.huanchong.bean.ZhuYeBean_01;
import com.jiyun.huanchong.bean.Zhuyebean;

import java.util.ArrayList;

/**
 * Created by hp on 2017/12/18.
 */

public interface IView {


    void getlist(ArrayList<Zhuyebean.DescBean> zhuyebean);
    void  get(ZhuYeBean_01 zhuyebean_01);
}
