package com.wickedwitchwarsaw.recyclerviewcomplexproject.inmemory;

import com.squareup.otto.Bus;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure.DemoApplication;

/**
 * Created by ZuZ on 2016-09-25.
 */
public class BaseInMemory {
    protected final Bus bus;
    protected final DemoApplication demoApplication;

    public BaseInMemory(DemoApplication demoApplication) {

        this.demoApplication = demoApplication;
        this.bus = demoApplication.getBus();
        bus.register(this);
    }
}
