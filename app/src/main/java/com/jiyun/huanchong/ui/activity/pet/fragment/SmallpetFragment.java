package com.jiyun.huanchong.ui.activity.pet.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jiyun.huanchong.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SmallpetFragment extends Fragment {


    public SmallpetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_smallpet, container, false);
    }

}
