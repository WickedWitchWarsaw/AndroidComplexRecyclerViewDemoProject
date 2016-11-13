package com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.BaseActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.PhotoPagerActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.YouTubeActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventCard;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.EventCardService;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment2view.Fragment2Adapter;

import java.util.ArrayList;

public class Fragment2 extends BaseFragments implements Fragment2Adapter.Fragment2Listener {

    private ArrayList<EventCard> serviceCards;
    private ArrayList<EventCard> categoryCards;
    private ArrayList<EventCard> eventCards;

    private RecyclerView recyclerView;
    private Fragment2Adapter fragment2Adapter;


    public static Fragment2 newInstance(){
        return new Fragment2();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_2, container, false);
        fragment2Adapter = new Fragment2Adapter((BaseActivity) getActivity(), this);
        serviceCards = fragment2Adapter.getServiceCards();
        categoryCards = fragment2Adapter.getCategoryCards();
        eventCards = fragment2Adapter.getEventCards();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment2recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        setUpAdapter();
        bus.post(new EventCardService.SearchServiceCardsRequest("Hello"));
        bus.post(new EventCardService.SearchCategoryCardsRequest("Hello"));
        bus.post(new EventCardService.SearchEventCardsRequest("Hello"));

        return rootView;
    }

    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(fragment2Adapter);
        }
    }



    @Override
    public void OnEventCardClicked(EventCard eventCard) {
        if(!eventCard.isEventVideo()){
            Intent intent = PhotoPagerActivity.newIntent(getActivity(), eventCard);
            startActivity(intent);
        } else {
            Intent intent = YouTubeActivity.newIntent(getActivity(), eventCard);
            startActivity(intent);
        }
    }

    @Subscribe
    public void getServiceEvents(EventCardService.SearchServiceCardsResponse response){
        serviceCards.clear();
        serviceCards.addAll(response.serviceCards);
    }

    @Subscribe
    public void getCategoryEvents(EventCardService.SearchCategoryCardsResponse response){
        categoryCards.clear();
        categoryCards.addAll(response.categoryCards);
    }

    @Subscribe
    public void getEventEvents(EventCardService.SearchEventCardsResponse response){
        eventCards.clear();
        eventCards.addAll(response.eventCards);
    }
}
