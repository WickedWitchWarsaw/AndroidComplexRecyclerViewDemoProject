package com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.Entity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-09-25.
 */

public class FragmentDetail extends BaseFragments {


    @BindView(R.id.textViewDetailsName)
    protected TextView nameDetail;
    @BindView(R.id.textViewDescription)
    protected TextView descriptionDetail;
    @BindView(R.id.textViewFact)
    protected TextView factDetail;
    @BindView(R.id.hardCodedStringText)
    protected TextView hardCodedString;
    @BindView(R.id.textViewString)
    protected TextView stringDetail;
    @BindView(R.id.imageViewDetailsPic)
    protected ImageView pictureDetail;
    @BindView(R.id.progressBarDetails)
    protected ProgressBar progressBarDetail;

    private Entity entity;
    public static final String ENTITY_EXTRA_INFO = "ENTITY_EXTRA_INFO";

    public static FragmentDetail newInstance(Entity entity) {
        Bundle arguments = new Bundle();
        arguments.putParcelable(ENTITY_EXTRA_INFO, entity);
        FragmentDetail fragmentDetail = new FragmentDetail();
        fragmentDetail.setArguments(arguments);
        return fragmentDetail;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        entity = getArguments().getParcelable(ENTITY_EXTRA_INFO);
       // entity = getActivity().getIntent().getParcelableExtra(ENTITY_EXTRA_INFO);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.single_fragment_details, container, false);
        ButterKnife.bind(this, rootView);
        nameDetail.setText(entity.getEntityName());
        descriptionDetail.setText(getString(R.string.descriptionDetails, entity.getEntityDescription()));
        factDetail.setText(entity.getEntityFact());
        stringDetail.setText(entity.getEntityString());
        hardCodedString.setText(getString(R.string.string));

        Picasso.with(getActivity()).load(entity.getEntityPicture())
                .fit()
                .centerCrop()
                .into(pictureDetail, new Callback() {
                    @Override
                    public void onSuccess() {
                        progressBarDetail.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
        return rootView;

    }
}
