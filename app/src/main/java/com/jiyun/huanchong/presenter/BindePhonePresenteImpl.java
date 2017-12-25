package com.jiyun.huanchong.presenter;

import com.jiyun.huanchong.model.api.HttpCallback;
import com.jiyun.huanchong.model.biz.BindPhoneModelmpl;
import com.jiyun.huanchong.ui.activity.bean.LoginBean;
import com.jiyun.huanchong.ui.view.BindPhoneView;

/**
 * Created by 张龙辉 on 2017/12/22.
 */

public class BindePhonePresenteImpl implements BindPhonePresenter {
    private BindPhoneView bindPhoneView;
    private final BindPhoneModelmpl modelmpl;

    public BindePhonePresenteImpl(BindPhoneView bindPhoneView){
        this.bindPhoneView=bindPhoneView;
        modelmpl = new BindPhoneModelmpl();
    }
    @Override
    public void bind(String threeId, String userPhone, String userImage, String userName, String password) {
        modelmpl.bind(threeId, userPhone, userImage, userName, password, new HttpCallback<LoginBean>() {


            @Override
            public void success(LoginBean loginBean) {
                bindPhoneView.sucess();
            }

            @Override
            public void error(String error) {

            }
        });
    }
}
