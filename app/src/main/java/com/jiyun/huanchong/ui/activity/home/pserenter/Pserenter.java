package com.jiyun.huanchong.ui.activity.home.pserenter;

import com.jiyun.huanchong.bean.ZhuYeBean_01;
import com.jiyun.huanchong.bean.Zhuyebean;
import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.ui.activity.home.model.IModel;
import com.jiyun.huanchong.ui.activity.home.model.Model;
import com.jiyun.huanchong.ui.activity.home.view.IView;

import java.util.ArrayList;

/**
 * Created by hp on 2017/12/18.
 */

public class Pserenter implements  IPserenter {
    private IModel iModel;
    private IView iView;

    public Pserenter( IView iView) {
        this.iModel =new Model();
        this.iView = iView;
    }

    @Override
    public void get(String beginIndex, String coordX, String coordY, String endIndex, String orderBy) {

        iModel.get(beginIndex, coordX, coordY, endIndex, orderBy, new HttpCallback<Zhuyebean>() {


            @Override
            public void success(Zhuyebean zhuyebean) {
                ArrayList<Zhuyebean.DescBean> desc = (ArrayList<Zhuyebean.DescBean>) zhuyebean.getDesc();
                iView.getlist(desc);
            }

            @Override
            public void error(String error) {

            }
        });

    }

    @Override
    public void getlist(String beginIndex, String endIndex, String petTypeCode) {
        iModel.getlist(beginIndex, endIndex, petTypeCode, new HttpCallback<ZhuYeBean_01>() {


            @Override
            public void success(ZhuYeBean_01 descBean) {

                iView.get(descBean);
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
