package com.wickedwitchwarsaw.recyclerviewcomplexproject.services;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventPicture;

import java.util.List;

/**
 * Created by ZuZ on 2016-10-10.
 */
public class EventsPhotoService {
    private EventsPhotoService() {
    }

    public static class SearchServicePhotoRequest {
        public String fireBaseUrl;

        public SearchServicePhotoRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchServicePhotoResponse {
        public List<EventPicture> servicePhotos;
    }



    public static class SearchCategoryPhotosRequest{
        public  String fireBaseUrl;

        public SearchCategoryPhotosRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchCategoryPhotosResponse{
        public List<EventPicture> categoryPhotos;
    }



    public static class SearchEventPhotosRequest{
        public String fireBaseUrl;

        public SearchEventPhotosRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchEventPhotosResponse{
        public List<EventPicture> eventPictures;
    }
}
