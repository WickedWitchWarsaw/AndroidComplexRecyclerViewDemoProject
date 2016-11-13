package com.wickedwitchwarsaw.recyclerviewcomplexproject.inmemory;

import com.squareup.otto.Subscribe;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.Entity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure.DemoApplication;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.EntityServices;

import java.util.ArrayList;

/**
 * Created by ZuZ on 2016-09-25.
 */
public class InMemoryEntityService extends BaseInMemory {
    public InMemoryEntityService(DemoApplication demoApplication) {
        super(demoApplication);
    }

    @Subscribe
    public void getEntities(EntityServices.SearchEntityRequest request) {
        EntityServices.SearchEntitiesResponse response =
                new EntityServices.SearchEntitiesResponse();
        response.entities = new ArrayList<>();

        for (int i = 0; i < 80; i++) {
            response.entities.add(new Entity(
                    i,
                    "Entity 1 NAME + " + i,
                    "Entity 1 " + i + "description 1 || description 1",
                    "http://www.gravatar.com/avatar/" + i + "?d=identicon",
                    "Entity 1 FACT",
                    "String"
            ));
        }

        bus.post(response);
    }
}
