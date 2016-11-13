package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment3view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.BaseActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.RushEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZuZ on 2016-10-17.
 */
public class RushEventAdapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_LIST_HEADER = 1;
    public static final int VIEW_TYPE_EXPANDABLE_HEADER = 2;
    public static final int VIEW_TYPE_EXPANDABLE_EVENT = 3;
    private final int VIEW_TYPE_LIST_FOOTER = 4;


    private List<Item> data;
    private BaseActivity activity;
    private LayoutInflater layoutInflater;
    private RushEventListener listener;

    public RushEventAdapter(BaseActivity activity, RushEventListener listener) {
        this.activity = activity;
        this.listener = listener;
        layoutInflater = activity.getLayoutInflater();
        data = new ArrayList<>();
    }


    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW_TYPE_LIST_HEADER;
        }
        position--;
        if (position < data.size()) {
            return data.get(position).type;
        }
        position -= data.size();
        if (position < data.size()) {
            return VIEW_TYPE_LIST_FOOTER;
        }
        position--;

        throw new IllegalArgumentException("Error - check position on Adapter");
    }


    public List<Item> getData() {
        return data;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View expandableHeaderView = layoutInflater.inflate(R.layout.list_expandable_header, parent, false);
        View rushEventsView = layoutInflater.inflate(R.layout.list_rush_event, parent, false);
        View rushHeaderView = layoutInflater.inflate(R.layout.header_fragment_rush, parent, false);
        View rushFooterView = layoutInflater.inflate(R.layout.footer_rush_fragment, parent, false);

        switch (viewType) {
            case VIEW_TYPE_LIST_HEADER:
                return new RushHeaderHolder(rushHeaderView);

            case VIEW_TYPE_EXPANDABLE_EVENT:
                final RushEventsHolder holder = new RushEventsHolder(rushEventsView);
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RushEvent rushEvent = (RushEvent) holder.itemView.getTag();
                        listener.OnRushEventClicked(rushEvent);
                    }
                });
                return holder;

            case VIEW_TYPE_LIST_FOOTER:
                return new RushFooterHolder(rushFooterView);

            case VIEW_TYPE_EXPANDABLE_HEADER:
                return new RushExpandableHeaderHolder(expandableHeaderView);
        }
        throw new IllegalArgumentException("Error - check position on Adapter");
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof RushExpandableHeaderHolder) {
            position--;
            final Item item = data.get(position);
            final RushExpandableHeaderHolder itemController = (RushExpandableHeaderHolder) holder;

            itemController.referralItem = item;
            itemController.headerName.setText(item.header);

            if (item.invisibleRush == null) {
                itemController.buttonToggle.setImageResource(R.mipmap.close);
            } else {
                itemController.buttonToggle.setImageResource(R.mipmap.plus);
            }

            itemController.backgroundView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(item.invisibleRush == null){
                        item.invisibleRush = new ArrayList<Item>();
                        int count = 0;
                        int position = data.indexOf(itemController.referralItem);

                        while (data.size() > position + 1 && data.get(position + 1).type == VIEW_TYPE_EXPANDABLE_EVENT){
                            item.invisibleRush.add(data.remove(position + 1));
                            count ++;
                        }
                        notifyItemRangeRemoved(position + 1, count);
                        itemController.buttonToggle.setImageResource(R.mipmap.plus);
                    } else {
                        int position = data.indexOf(itemController.referralItem);
                        int index = position + 1;

                        for(Item item1 : item.invisibleRush){
                            data.add(index, item1);
                            index++;
                        }
                        notifyItemRangeInserted(position + 1, index - position - 1);
                        itemController.buttonToggle.setImageResource(R.mipmap.close);
                        item.invisibleRush = null;
                    }
                }
            });
        } else if (holder instanceof RushEventsHolder){
            position--;
            RushEventsHolder rushEventsHolder = (RushEventsHolder) holder;
            rushEventsHolder.populate(data.get(position).rushEvent);
        } else if (holder instanceof RushHeaderHolder){
            RushHeaderHolder rushHeaderHolder = (RushHeaderHolder) holder;
        } else if (holder instanceof RushFooterHolder){
            ((RushFooterHolder) holder).populate(activity);
        }
    }


    @Override
    public int getItemCount() {
        int count = 2;

        if(data.size() > 0){
            count += data.size();
        }
        return count;
    }


    public interface RushEventListener {
        void OnRushEventClicked(RushEvent rushEvent);
    }
}
