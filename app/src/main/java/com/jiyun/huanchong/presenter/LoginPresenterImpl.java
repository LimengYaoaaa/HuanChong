package com.jiyun.huanchong.presenter;

import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.biz.RegisterModelImpl;
import com.jiyun.huanchong.ui.activity.bean.LoginBean;
import com.jiyun.huanchong.ui.view.LoginView;
import com.jiyun.huanchong.utils.RegexUtils;

/**
 * Created by mengYao on 2017/12/17.
 */

public class LoginPresenterImpl implements LoginPresenter {
    private RegisterModelImpl model;
    private LoginView loginView;
    public LoginPresenterImpl(LoginView loginView){
        this.loginView=loginView;
        model=new RegisterModelImpl();
    }
    @Override
    public void login(String phone, String password) {
        if (!RegexUtils.isMobileExact(phone)){
            return;
        }
        if (!RegexUtils.isUsername(password)){
            return;
        }
        model.login(phone, password, new HttpCallback<LoginBean>() {

            @Override
            public void success(LoginBean loginBean) {
                loginView.onSuccess(loginBean);
            }

            @Override
            public void error(String error) {
                loginView.onFailure(error);
            }
        });
    }
}
