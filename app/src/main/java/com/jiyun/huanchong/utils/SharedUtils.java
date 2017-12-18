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
    private SharedUtils(){
        throw new UnknownFormatConversionException("you can't instance me");
    }
    public static void saveUserInfo(Context context, long userPhone, String username, String userid, int usersex){
        if (username==null||username.equals(""))
            return;
        if (userid==null||userid.equals(""))
            return;
        SharedPreferences userInfo = context.getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = userInfo.edit();
        edit.putString("phone",userPhone+"");
        if (usersex==1){
            edit.putString("sex","男");
        }else{
            edit.putString("sex","女");
        }
        edit.putString("username",username);
        edit.putString("userid",userid);
        edit.commit();
    }
    public static void saveDisanfangInfo(Context context,String uid,String iconurl,String name,String gender){
        if (uid==null||uid.equals("")){
            return;
        }
        if (iconurl==null||iconurl.equals("")){
            return;
        }
        if (name==null||name.equals("")){
            return;
        }
        if (gender==null||gender.equals("")){
            return;
        }
        SharedPreferences disanfangInfo = context.getSharedPreferences("disanfangInfo", MODE_PRIVATE);
        SharedPreferences.Editor edit = disanfangInfo.edit();
        edit.putString("uid",uid);
        edit.putString("iconurl",iconurl);
        edit.putString("name",name);
        edit.putString("gender",gender);
        edit.commit();
    }
}
