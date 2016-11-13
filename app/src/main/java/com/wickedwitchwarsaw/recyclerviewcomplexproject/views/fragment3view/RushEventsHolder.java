package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment3view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.RushEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-14.
 */
public class RushEventsHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_rush_event_name)
    protected TextView rushName;
    @BindView(R.id.list_rush_event_date)
    protected TextView rushDate;
    @BindView(R.id.list_rush_event_location)
    protected TextView rushLocation;
    @BindView(R.id.list_rush_event_time)
    protected TextView rushTime;

    public RushEventsHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(RushEvent rushEvent) {
        itemView.setTag(rushEvent);
        rushName.setText(rushEvent.getEventName());
        rushLocation.setText(rushEvent.getEventLocation());
        rushDate.setText(rushEvent.getEventDate());
        rushTime.setText(rushEvent.getEventTime());
    }
}
