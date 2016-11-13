package com.wickedwitchwarsaw.recyclerviewcomplexproject.entities;

/**
 * Created by ZuZ on 2016-10-07.
 */
public class EventCard {
    private int eventId;
    private String eventName;
    private String eventDescription;
    private String eventImage;
    private boolean eventVideo;
    private String youTubeEnding;

    public int getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public String getEventImage() {
        return eventImage;
    }

    public boolean isEventVideo() {
        return eventVideo;
    }

    public String getYouTubeEnding() {
        return youTubeEnding;
    }

    public EventCard(int eventId, String eventName, String eventDescription, String eventImage, boolean eventVideo, String youTubeEnding) {

        this.eventId = eventId;
        this.eventName = eventName;
        this.eventDescription = eventDescription;
        this.eventImage = eventImage;
        this.eventVideo = eventVideo;
        this.youTubeEnding = youTubeEnding;
    }
}
