package com.wickedwitchwarsaw.recyclerviewcomplexproject.services;

import android.widget.ListView;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventCard;

import java.util.List;

/**
 * Created by ZuZ on 2016-10-09.
 */
public class EventCardService {

    private EventCardService(){
    }

    public static class SearchServiceCardsRequest{
        public String fireBaseURL;

        public SearchServiceCardsRequest(String fireBaseURL) {
            this.fireBaseURL = fireBaseURL;
        }
    }

    public static class SearchServiceCardsResponse{
        public List<EventCard> serviceCards;
    }



    public static class SearchCategoryCardsRequest{
        public String fireBaseUrl;

        public SearchCategoryCardsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCategoryCardsResponse{
        public List<EventCard> categoryCards;
    }



    public static class SearchEventCardsRequest{
        public String fireBaseUrl;

        public SearchEventCardsRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchEventCardsResponse{
        public List<EventCard> eventCards;
    }
}
