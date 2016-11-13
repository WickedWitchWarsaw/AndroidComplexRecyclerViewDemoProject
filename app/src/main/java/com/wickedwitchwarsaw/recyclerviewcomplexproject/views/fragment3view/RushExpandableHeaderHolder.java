package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment3view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.ImageView;
import android.widget.TextView;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-17.
 */
public class RushExpandableHeaderHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.list_expandable_header_buttonToggle)
    protected ImageView buttonToggle;
    @BindView(R.id.list_expandable_header_layout)
    protected View backgroundView;
    @BindView(R.id.list_expandable_header_name)
    protected TextView headerName;


    public Item referralItem;

    public RushExpandableHeaderHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
