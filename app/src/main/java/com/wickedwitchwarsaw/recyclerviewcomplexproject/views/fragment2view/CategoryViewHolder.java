package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment2view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventCard;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-08.
 */
public class CategoryViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.list_event_card_eventDescription)
    protected TextView eventDescription;
    @BindView(R.id.list_event_card_eventName)
    protected TextView eventName;
    @BindView(R.id.list_event_card_imageView)
    protected ImageView eventImage;
    @BindView(R.id.list_event_card_progressBar)
    protected ProgressBar eventProgressBar;
    @BindView(R.id.list_event_card_eventImageViewSmall)
    protected ImageView eventType;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

    public void populate(Context context, EventCard eventCard){
        itemView.setTag(eventCard);

        if(!eventCard.isEventVideo()){
            eventType.setImageResource(R.mipmap.camera);
        } else {
            eventType.setImageResource(R.mipmap.video);
        }

        eventDescription.setText(eventCard.getEventDescription());
        eventName.setText(eventCard.getEventName());

        Picasso.with(context).load(eventCard.getEventImage())
                .fit()
                .centerCrop()
                .into(eventImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        eventProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
