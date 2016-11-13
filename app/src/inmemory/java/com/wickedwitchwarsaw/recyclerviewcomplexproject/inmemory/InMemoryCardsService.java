package com.wickedwitchwarsaw.recyclerviewcomplexproject.inmemory;

import com.squareup.otto.Subscribe;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventCard;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure.DemoApplication;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.EventCardService;

import java.util.ArrayList;

/**
 * Created by ZuZ on 2016-10-09.
 */
public class InMemoryCardsService extends BaseInMemory {
    public InMemoryCardsService(DemoApplication demoApplication) {
        super(demoApplication);
    }

    @Subscribe
    public void searchServiceCards (EventCardService.SearchServiceCardsRequest request){
        EventCardService.SearchServiceCardsResponse response = new EventCardService.SearchServiceCardsResponse();
        response.serviceCards = new ArrayList<>();

        response.serviceCards.add(new EventCard(
                1,
                "Service Card 1",
                "Service Card 1 Description",
                "http://www.gravatar.com/avatar/" + 1 + "?d=identicon",
                false,
                "null"
        ));

        response.serviceCards.add(new EventCard(
                2,
                "Service Card 2",
                "Service Card 2 Description",
                "http://www.gravatar.com/avatar/" + 2 + "?d=identicon",
                true,
                "ARE1WzGskaw"
        ));

        bus.post(response);

    }

    @Subscribe
    public void searchCategoryCards (EventCardService.SearchCategoryCardsRequest request){
        EventCardService.SearchCategoryCardsResponse response = new EventCardService.SearchCategoryCardsResponse();
        response.categoryCards = new ArrayList<>();

        response.categoryCards.add(new EventCard(
                3,
                "Category Card 1",
                "Category Card 1 Description",
                "http://www.gravatar.com/avatar/" + 3 + "?d=identicon",
                false,
                "null"
        ));

        response.categoryCards.add(new EventCard(
                4,
                "Category Card 2",
                "Category Card 2 Description",
                "http://www.gravatar.com/avatar/" + 4 + "?d=identicon",
                true,
                "qJeqUW-T5hE"
        ));

        bus.post(response);

    }

    @Subscribe
    public void searchEventCards (EventCardService.SearchEventCardsRequest request){
        EventCardService.SearchEventCardsResponse response = new EventCardService.SearchEventCardsResponse();
        response.eventCards = new ArrayList<>();

        response.eventCards.add(new EventCard(
                5,
                "Event Card 1",
                "Event Card 1 Description",
                "http://www.gravatar.com/avatar/" + 5 + "?d=identicon",
                false,
                "null"
        ));

        response.eventCards.add(new EventCard(
                6,
                "Event Card 2",
                "Event Card 2 Description",
                "http://www.gravatar.com/avatar/" + 6 + "?d=identicon",
                true,
                "hTdhXxxWREo"
        ));

        bus.post(response);

    }
}
