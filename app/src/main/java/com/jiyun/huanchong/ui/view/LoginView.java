package com.jiyun.huanchong.ui.view;

import com.jiyun.huanchong.ui.activity.bean.LoginBean;

/**
 * Created by mengYao on 2017/12/18.
 */

public interface LoginView {
    void onSuccess(LoginBean loginBean);
    void onFailure(String error);
}
