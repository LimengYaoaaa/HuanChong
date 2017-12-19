package com.jiyun.huanchong.ui.activity.pet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.huanchong.R;
import com.jiyun.huanchong.utils.SideBar;


/**
 * A simple {@link Fragment} subclass.
 */
public class CatFragment extends Fragment {


    private SideBar sidrbar;

    public CatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_cat, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        sidrbar = (SideBar) inflate.findViewById(R.id.sidrbar);

    }
}
