package com.wickedwitchwarsaw.recyclerviewcomplexproject.services;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.Entity;

import java.util.List;

/**
 * Created by ZuZ on 2016-09-25.
 */
public class EntityServices {

    public EntityServices(){
    }

    public static class SearchEntityRequest{
        public String fireBaseUrl;

        public SearchEntityRequest(String fireBaseUrl) {
            this.fireBaseUrl = fireBaseUrl;
        }
    }

    public static class SearchEntitiesResponse{
        public List<Entity> entities;
    }
}
