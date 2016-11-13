package com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;

/**
 * Created by ZuZ on 2016-09-24.
 */
public class Fragment4 extends BaseFragments {
    public static Fragment4 newInstance() {
        return new Fragment4();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_4, container, false);
        return rootView;
    }
}
