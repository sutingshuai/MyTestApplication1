package com.example.suts.mytestapplication1.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.suts.mytestapplication1.R;

/**
 * Created by suts on 2017/9/27.
 */

public class FragmentTest1 extends Fragment {

    View thisview;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        thisview = inflater.inflate(R.layout.fragment_test_1, container, false);

        return thisview;
    }


}
