package com.wickedwitchwarsaw.recyclerviewcomplexproject.services;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.RushEvent;

import java.util.List;

/**
 * Created by ZuZ on 2016-10-17.
 */
public class RushEventsService {
    public RushEventsService() {
    }

    public static class SearchRushOneEventsRequest {
        public String fireBaseUrl;

        public SearchRushOneEventsRequest(String fireBaseUrl) {

            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchRushOneEventsResponse{
        public List<RushEvent> rushEventsOne;
    }




    public static class SearchRushTwoEventsRequest{
        public String fireBaseUrl;

        public SearchRushTwoEventsRequest(String fireBaseUrl) {

            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchRushTwoEventsResponse{
      public List<RushEvent> rushEventsTwo;
    }
}
