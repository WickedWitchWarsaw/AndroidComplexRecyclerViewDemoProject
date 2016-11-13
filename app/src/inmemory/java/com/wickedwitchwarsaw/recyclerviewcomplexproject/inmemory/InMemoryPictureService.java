package com.wickedwitchwarsaw.recyclerviewcomplexproject.inmemory;

import com.squareup.otto.Subscribe;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventPicture;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.infrastructure.DemoApplication;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.EventsPhotoService;

import java.util.ArrayList;

/**
 * Created by ZuZ on 2016-10-10.
 */
public class InMemoryPictureService extends BaseInMemory {
    public InMemoryPictureService(DemoApplication demoApplication) {
        super(demoApplication);
    }

    @Subscribe
    public void getServicePhotos(EventsPhotoService.SearchServicePhotoRequest request){
        EventsPhotoService.SearchServicePhotoResponse response = new EventsPhotoService.SearchServicePhotoResponse();
        response.servicePhotos = new ArrayList<>();
        response.servicePhotos.add(new EventPicture( "http://www.gravatar.com/avatar/" + 50 + "?d=identicon"));
        response.servicePhotos.add(new EventPicture( "http://www.gravatar.com/avatar/" + 52 + "?d=identicon"));
        response.servicePhotos.add(new EventPicture( "http://www.gravatar.com/avatar/" + 54 + "?d=identicon"));
        response.servicePhotos.add(new EventPicture( "http://www.gravatar.com/avatar/" + 56 + "?d=identicon"));

        bus.post(response);

    }


    @Subscribe
    public void getCategoryPhotos(EventsPhotoService.SearchCategoryPhotosRequest request){
        EventsPhotoService.SearchCategoryPhotosResponse response = new EventsPhotoService.SearchCategoryPhotosResponse();
        response.categoryPhotos = new ArrayList<>();
        response.categoryPhotos.add(new EventPicture( "http://www.gravatar.com/avatar/" + 51 + "?d=identicon"));
        response.categoryPhotos.add(new EventPicture( "http://www.gravatar.com/avatar/" + 53 + "?d=identicon"));
        response.categoryPhotos.add(new EventPicture( "http://www.gravatar.com/avatar/" + 55 + "?d=identicon"));
        response.categoryPhotos.add(new EventPicture( "http://www.gravatar.com/avatar/" + 57 + "?d=identicon"));

        bus.post(response);

    }

    @Subscribe
    public void getEventsPhotos(EventsPhotoService.SearchEventPhotosRequest request){
        EventsPhotoService.SearchEventPhotosResponse response = new EventsPhotoService.SearchEventPhotosResponse();
        response.eventPictures = new ArrayList<>();
        response.eventPictures.add(new EventPicture( "http://www.gravatar.com/avatar/" + 60 + "?d=identicon"));
        response.eventPictures.add(new EventPicture( "http://www.gravatar.com/avatar/" + 61 + "?d=identicon"));
        response.eventPictures.add(new EventPicture( "http://www.gravatar.com/avatar/" + 62 + "?d=identicon"));
        response.eventPictures.add(new EventPicture( "http://www.gravatar.com/avatar/" + 63 + "?d=identicon"));

        bus.post(response);
    }

}
