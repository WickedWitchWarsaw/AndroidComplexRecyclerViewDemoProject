package com.wickedwitchwarsaw.recyclerviewcomplexproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.squareup.otto.Subscribe;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventCard;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventPicture;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments.EventsPhotoFragment;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.EventsPhotoService;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-10.
 */
public class PhotoPagerActivity extends BaseActivity {
    private ArrayList<EventPicture> mEventPictures;

    @BindView(R.id.event_photo_viewPager)
    protected ViewPager viewPager;

    public static final String EXTRA_CARD_INFO = "EXTRA_CARD_INFO";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_pager);
        ButterKnife.bind(this);
        mEventPictures = new ArrayList<>();
        int cardIndex = getIntent().getIntExtra(EXTRA_CARD_INFO, 0);

        switch (cardIndex){
            case 1:
                bus.post(new EventsPhotoService.SearchServicePhotoRequest("Hello"));
                break;
            case 3:
                bus.post(new EventsPhotoService.SearchCategoryPhotosRequest("Hello"));
                break;
            case 5:
                bus.post(new EventsPhotoService.SearchEventPhotosRequest("Hello"));
                break;
        }

        viewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                EventPicture eventPicture = mEventPictures.get(position);
                return EventsPhotoFragment.newInstance(eventPicture);
            }

            @Override
            public int getCount() {
                return mEventPictures.size();
            }
        });
    }



    public static Intent newIntent(Context context, EventCard eventCard){
        Intent intent  = new Intent(context, PhotoPagerActivity.class);
        intent.putExtra(EXTRA_CARD_INFO, eventCard.getEventId());
        return intent;
    }

    @Subscribe
    public void getServicePhotos(EventsPhotoService.SearchServicePhotoResponse response){
        mEventPictures.clear();
        mEventPictures.addAll(response.servicePhotos);
    }

    @Subscribe
    public void getCategoryPhotos(EventsPhotoService.SearchCategoryPhotosResponse response){
        mEventPictures.clear();
        mEventPictures.addAll(response.categoryPhotos);
    }

    @Subscribe
    public void getEventPhotos(EventsPhotoService.SearchEventPhotosResponse response){
        mEventPictures.clear();
        mEventPictures.addAll(response.eventPictures);
    }
}
