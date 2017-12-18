package com.jiyun.huanchong.utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.UnknownFormatConversionException;

import static android.content.Context.MODE_PRIVATE;
import static com.jiyun.huanchong.app.App.context;

/**
 * Created by mengYao on 2017/12/17.
 */

public class SharedUtils {
    private static SharedUtils sharedUtils;
    private SharedPreferences userInfo;
    private SharedPreferences.Editor edit;

    private SharedUtils(Context context){
        userInfo = context.getSharedPreferences("userInfo", MODE_PRIVATE);
        edit = userInfo.edit();
    }
    public static SharedUtils getInstance(Context context){
        if (sharedUtils==null){
            sharedUtils=new SharedUtils(context);
        }
        return sharedUtils;
    }
    public void addHeadImage(String iconurl){
        edit.putString("iconurl",iconurl);
        edit.commit();
    }
    public void addUserid(String userid){
        edit.putString("userid",userid);
        edit.commit();
    }
    public void addUserPhone(String userphone){
        edit.putString("userphone",userphone);
        edit.commit();
    }
    public void addUserSex(String usersex){
        edit.putString("usersex",usersex);
        edit.commit();
    }
    public void addUserName(String username){
        edit.putString("username",username);
        edit.commit();
    }
    public void clear(){
        edit.clear();
        edit.commit();
    }
}
