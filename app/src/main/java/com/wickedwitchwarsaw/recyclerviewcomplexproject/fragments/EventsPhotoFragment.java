package com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventPicture;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-10.
 */
public class EventsPhotoFragment extends BaseFragments {
    @BindView(R.id.fragment_event_picture_image)
    ImageView eventsImage;
    @BindView(R.id.fragment_event_picture_progressBar)
    ProgressBar eventProgressBar;

    public static final String EVENT_PHOTO_INFO = "EVENT_PHOTO_INFO";
    private String photoUrl;


    public static EventsPhotoFragment newInstance(EventPicture eventPicture) {
        Bundle arguments = new Bundle();
        arguments.putString(EVENT_PHOTO_INFO, eventPicture.getPictureUrl());
        EventsPhotoFragment eventsPhotoFragment = new EventsPhotoFragment();
        eventsPhotoFragment.setArguments(arguments);
        return eventsPhotoFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        photoUrl = getArguments().getString(EVENT_PHOTO_INFO);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_event_picture, container, false);
        ButterKnife.bind(this, rootView);
        Picasso.with(getActivity()).load(photoUrl)
                .centerCrop()
                .fit()
                .into(eventsImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        return rootView;
    }
}
