package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment3view;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.RushEvent;

import java.util.List;

/**
 * Created by ZuZ on 2016-10-14.
 */
public class Item {
    public int type;
    public String header;
    public RushEvent rushEvent;
    public List<Item> invisibleRush;

    public Item(int type, String header) {
        this.type = type;
        this.header = header;
    }

    public Item(int type, RushEvent rushEvent) {
        this.type = type;
        this.rushEvent = rushEvent;
    }
}
