package com.jiyun.huanchong.model.biz;

import com.jiyun.huanchong.model.api.HttpCallback;

/**
 * Created by 张龙辉 on 2017/12/22.
 */

public interface BindPhoneModel  {
 <T>   void bind(String  threeId, String  userPhone, String userImage, String userName, String password, HttpCallback<T> callback);
}
