package com.jiyun.huanchong.ui.activity.fosterteacher;

import android.view.View;
import android.widget.Button;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.ui.base.BaseActivity;


/**
 * Created by mengYao on 2017/12/12.
 */

public class FosterteacherActivity extends BaseActivity implements View.OnClickListener{

    private Button comment;
    private Button appointment;



    @Override
    protected int getLayoutId() {
        return R.layout.activity_fosterteacher;
    }

    @Override
    protected void findViewById() {

    }

    @Override
    protected void init() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
//            case R.id.comment :
//                  startActivity(new Intent(this,CommentActivity.class));
//                break;
//            case R.id.appointment :
//                 startActivity(new Intent(this,AppointmentActivity.class));
//                break;
        }
    }
}
