package com.jiyun.huanchong.ui.view;

import com.jiyun.huanchong.ui.activity.bean.RegisterBean;

/**
 * Created by mengYao on 2017/12/17.
 */

public interface RegisterView {
    void onSuccess(RegisterBean registerBean);
    void onFailure(String error);
}
