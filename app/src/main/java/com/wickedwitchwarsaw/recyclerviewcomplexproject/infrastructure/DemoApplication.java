package com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure;


import android.app.Application;

import com.squareup.otto.Bus;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.inmemory.Module;

public class DemoApplication extends Application {
    private Bus bus;

    public DemoApplication() {
        bus = new Bus();
    }

    public static final String YOUTUBE_KEY = "AIzaSyAREqg2DrwZWVLFoaEInIFi6W7gAYGCVYw";

    @Override
    public void onCreate() {
        super.onCreate();
        Module.Register(this);
    }

    public Bus getBus() {
        return bus;
    }
}
