package com.wickedwitchwarsaw.recyclerviewcomplexproject.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.squareup.otto.Bus;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure.DemoApplication;


public class BaseActivity extends AppCompatActivity {
    protected DemoApplication application;
    protected Bus bus;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (DemoApplication) getApplication();
        bus = application.getBus();
        bus.register(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        bus.unregister(this);
    }
}
