package com.jiyun.huanchong.ui.activity.bean;

/**
 * Created by mengYao on 2017/12/18.
 */

public class LoginErrorBean {

    /**
     * ret : false
     * desc : 密码错误
     */

    private boolean ret;
    private String desc;

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
