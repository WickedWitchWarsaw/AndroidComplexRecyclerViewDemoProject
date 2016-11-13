package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment1view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.Entity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-09-24.
 */


public class Fragment1ViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.listRelativeViewImage)
    protected ImageView fragment1RelativeViewImage;
    @BindView(R.id.progressBar)
    protected ProgressBar fragment1ProgressBar;

    public Fragment1ViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(Context context, Entity entity){
        itemView.setTag(entity);
        Picasso.with(context).load(entity.getEntityPicture())
                .fit()
                .centerCrop()
                .into(fragment1RelativeViewImage, new Callback() {
                    @Override
                    public void onSuccess() {
                        fragment1ProgressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
    }

}


