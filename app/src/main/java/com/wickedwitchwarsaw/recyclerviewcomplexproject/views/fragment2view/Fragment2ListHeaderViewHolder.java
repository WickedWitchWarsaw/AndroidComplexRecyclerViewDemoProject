package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment2view;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-08.
 */
public class Fragment2ListHeaderViewHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.simple_header_textView)
    protected TextView headerTextView;

    public Fragment2ListHeaderViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void populate(String header){
        headerTextView.setText(header);
    }
}
