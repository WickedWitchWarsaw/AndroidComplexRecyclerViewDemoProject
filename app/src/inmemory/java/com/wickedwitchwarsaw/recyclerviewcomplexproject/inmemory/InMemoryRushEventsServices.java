package com.wickedwitchwarsaw.recyclerviewcomplexproject.inmemory;

import com.squareup.otto.Subscribe;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.RushEvent;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure.DemoApplication;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.RushEventsService;

import java.util.ArrayList;

/**
 * Created by ZuZ on 2016-10-17.
 */
public class InMemoryRushEventsServices extends BaseInMemory {
    public InMemoryRushEventsServices(DemoApplication demoApplication) {
        super(demoApplication);
    }


    @Subscribe
    public void getOneRushEvents(RushEventsService.SearchRushOneEventsRequest request) {
        RushEventsService.SearchRushOneEventsResponse response = new RushEventsService.SearchRushOneEventsResponse();
        response.rushEventsOne = new ArrayList<>();

        response.rushEventsOne.add(new RushEvent(
                1,
                "Rush One Event 1",
                "18/10/16",
                "8:00pm",
                "City",
                52.13,
                21.17,
                true,
                "Description of Event One here...."
        ));

        bus.post(response);
    }

    @Subscribe
    public void getTwoRushEvents(RushEventsService.SearchRushTwoEventsRequest request){
        RushEventsService.SearchRushTwoEventsResponse response = new RushEventsService.SearchRushTwoEventsResponse();
        response.rushEventsTwo = new ArrayList<>();

        response.rushEventsTwo.add(new RushEvent(
                1,
                "Rush Two Event 1",
                "26/10/16",
                "10:00pm",
                "Jana Pawła II 82, 00-175 Warszawa",
                52.23,
                21.10,
                false,
                "Description of Event Two here...."
        ));

        response.rushEventsTwo.add(new RushEvent(
                2,
                "Rush Two Event 2",
                "30/10/16",
                "7:00pm",
                "Kabaty",
                52.13,
                21.06,
                false,
                "Description of Event Two.Two here...."
        ));

        bus.post(response);
    }


}
