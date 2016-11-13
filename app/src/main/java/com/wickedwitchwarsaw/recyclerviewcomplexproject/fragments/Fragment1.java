package com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.otto.Subscribe;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.BaseActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.EntityPagerActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.Entity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.EntityServices;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment1view.Fragment1Adapter;

import java.util.ArrayList;


public class Fragment1 extends BaseFragments implements Fragment1Adapter.EntityClickerListener {

    private final String LOG_TAG = Fragment1.class.getSimpleName();

    private Fragment1Adapter adapter;
    private RecyclerView recyclerView;
    private ArrayList<Entity> entities;


    public static Fragment1 newInstance() {
        return new Fragment1();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_1, container, false);
        adapter = new Fragment1Adapter(this, (BaseActivity) getActivity());
        entities = adapter.getEntities();
        recyclerView = (RecyclerView) rootView.findViewById(R.id.fragment1RecyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        setUpAdapter();
        bus.post(new EntityServices.SearchEntityRequest("UrlFireBase"));
        return rootView;
    }


    private void setUpAdapter() {
        if (isAdded()) {
            recyclerView.setAdapter(adapter);
        }
    }


    @Override
    public void OnEntityClicked(Entity entity) {
        Intent intent = EntityPagerActivity.newIntent(getActivity(), entity);
        startActivity(intent);
    }

    @Subscribe
    public void getEntities(EntityServices.SearchEntitiesResponse response) {
        entities.clear();
        entities.addAll(response.entities);
    }

}
