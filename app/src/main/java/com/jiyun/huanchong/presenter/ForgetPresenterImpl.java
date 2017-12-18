package com.jiyun.huanchong.presenter;

import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.biz.ForgetModelImpl;
import com.jiyun.huanchong.ui.activity.bean.ForgetBean;
import com.jiyun.huanchong.ui.activity.login.ForgetPresenter;
import com.jiyun.huanchong.ui.view.ForgetView;

/**
 * Created by 张龙辉 on 2017/12/18.
 */

public class ForgetPresenterImpl implements ForgetPresenter {
    private ForgetView forgetView;
    private final ForgetModelImpl forgetModel;

    public ForgetPresenterImpl(ForgetView forgetView){
        this.forgetView=forgetView;
        forgetModel = new ForgetModelImpl();
    }
    @Override
    public void sucess(String phone, String pass) {
        forgetModel.forget(phone, pass, new HttpCallback<ForgetBean>() {



            @Override
            public void success(ForgetBean forgetBean) {
                forgetView.sucess();
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
