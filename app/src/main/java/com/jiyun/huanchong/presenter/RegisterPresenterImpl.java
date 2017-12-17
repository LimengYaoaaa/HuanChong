package com.jiyun.huanchong.presenter;

import android.util.Log;

import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.biz.RegisterModel;
import com.jiyun.huanchong.model.biz.RegisterModelImpl;
import com.jiyun.huanchong.ui.activity.bean.RegisterBean;
import com.jiyun.huanchong.ui.view.RegisterView;

/**
 * Created by mengYao on 2017/12/17.
 */

public class RegisterPresenterImpl implements RegisterPresenter {
    private RegisterModel registerModel;
    private RegisterView registerView;
    public RegisterPresenterImpl(RegisterView registerView){
        registerModel=new RegisterModelImpl();
        this.registerView=registerView;
    }
    @Override
    public void register(String phone, String username, String password) {
        registerModel.register(phone, username, password, new HttpCallback<RegisterBean>() {

            @Override
            public void success(RegisterBean registerBean) {
                registerView.onSuccess(registerBean);
            }

            @Override
            public void error(String error) {
                registerView.onFailure(error);
            }
        });
    }
}
