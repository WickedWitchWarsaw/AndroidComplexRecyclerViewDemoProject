package com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.squareup.otto.Bus;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure.DemoApplication;

/**
 * Created by ZuZ on 2016-09-25.
 */
public class BaseFragments extends Fragment {
    protected DemoApplication application;
    protected Bus bus;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (DemoApplication) getActivity().getApplication();
        bus = application.getBus();
        bus.register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}

