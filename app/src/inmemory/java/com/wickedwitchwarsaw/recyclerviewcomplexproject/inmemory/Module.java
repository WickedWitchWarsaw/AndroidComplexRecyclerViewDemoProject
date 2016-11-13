package com.wickedwitchwarsaw.recyclerviewcomplexproject.inmemory;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure.DemoApplication;

/**
 * Created by ZuZ on 2016-09-25.
 */
public class Module {
    public static void Register(DemoApplication demoApplication){
        new InMemoryEntityService(demoApplication);
        new InMemoryCardsService(demoApplication);
        new InMemoryPictureService(demoApplication);
        new InMemoryRushEventsServices(demoApplication);
    }
}
