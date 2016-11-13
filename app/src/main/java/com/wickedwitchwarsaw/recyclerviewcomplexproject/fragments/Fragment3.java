package com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.ActivityMaps;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.BaseActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.LocalMapActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.RushEvent;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.RushEventsService;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment3view.Item;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment3view.RushEventAdapter;

import java.util.ArrayList;
import java.util.List;

public class Fragment3 extends BaseFragments implements RushEventAdapter.RushEventListener {

    private RushEventAdapter adapter;
    private ArrayList<RushEvent> rushOneEvents;
    private ArrayList<RushEvent> rushTwoEvents;

    private Item itemOne;
    private Item itemTwo;

    private RecyclerView recyclerView;


    public static Fragment3 newInstance(){
        return new Fragment3();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_3, container, false);
        adapter = new RushEventAdapter((BaseActivity)getActivity(), this);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment3RushRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        rushOneEvents = new ArrayList<>();
        rushTwoEvents = new ArrayList<>();

        List<Item> data = adapter.getData();
        itemOne = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_HEADER, "Events ONE: ");
        itemOne.invisibleRush = new ArrayList<>();

        itemTwo = new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_HEADER, "Events TWO: ");
        itemTwo.invisibleRush = new ArrayList<>();

        bus.post(new RushEventsService.SearchRushOneEventsRequest("Hello"));
        bus.post(new RushEventsService.SearchRushTwoEventsRequest("Hello"));

        setUpAdapter();
        data.add(itemOne);
        data.add(itemTwo);

        return rootView;
    }

    private void setUpAdapter(){
        if(isAdded()){
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void OnRushEventClicked(RushEvent rushEvent) {
        if(!rushEvent.isOnCampus()){
            Intent intent = ActivityMaps.newIntent(getActivity(), rushEvent);
            startActivity(intent);
        } else {
            Intent intent = LocalMapActivity.newIntent(getActivity(), rushEvent);
            startActivity(intent);
        }

    }

    @Subscribe
    public void getOneEvents(RushEventsService.SearchRushOneEventsResponse response){
        rushOneEvents.clear();
        rushOneEvents.addAll(response.rushEventsOne);
        for(RushEvent rushEvent : rushOneEvents){
            itemOne.invisibleRush.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_EVENT, rushEvent));
        }
    }

    @Subscribe
    public void getTwoEvents(RushEventsService.SearchRushTwoEventsResponse response){
        rushTwoEvents.clear();
        rushTwoEvents.addAll(response.rushEventsTwo);
        for(RushEvent rushEvent : rushTwoEvents){
            itemTwo.invisibleRush.add(new Item(RushEventAdapter.VIEW_TYPE_EXPANDABLE_EVENT, rushEvent));
        }
    }

}
