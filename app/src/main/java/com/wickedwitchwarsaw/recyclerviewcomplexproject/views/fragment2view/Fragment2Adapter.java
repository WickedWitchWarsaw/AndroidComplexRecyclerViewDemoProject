package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment2view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.BaseActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.EventCard;

import java.util.ArrayList;

/**
 * Created by ZuZ on 2016-10-08.
 */
public class Fragment2Adapter extends RecyclerView.Adapter {

    private final int VIEW_TYPE_MAIN_HEADER = 1;
    private final int VIEW_TYPE_SERVICE_LIST = 2;
    private final int VIEW_TYPE_CATEGORY_LIST = 3;
    private final int VIEW_TYPE_EVENT_LIST = 4;
    private final int VIEW_TYPE_LIST_HEADER = 5;

    private LayoutInflater inflater;
    private BaseActivity activity;
    private ArrayList<EventCard> serviceCards;
    private ArrayList<EventCard> eventCards;
    private ArrayList<EventCard> categoryCards;

    private Fragment2Listener listener;

    public Fragment2Adapter(BaseActivity activity, Fragment2Listener listener) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        serviceCards = new ArrayList<>();
        eventCards = new ArrayList<>();
        categoryCards = new ArrayList<>();
    }

    public ArrayList<EventCard> getServiceCards() {
        return serviceCards;
    }

    public ArrayList<EventCard> getEventCards() {
        return eventCards;
    }

    public ArrayList<EventCard> getCategoryCards() {
        return categoryCards;
    }

    @Override
    public int getItemViewType(int position) {
       if (position == 0) {
           return VIEW_TYPE_MAIN_HEADER;
        }
       position--;

        if (serviceCards.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;

            if (position < serviceCards.size()) {
                return VIEW_TYPE_SERVICE_LIST;
            }
            position -= serviceCards.size();
        }
        if (categoryCards.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;

            if (position < categoryCards.size()) {
                return VIEW_TYPE_CATEGORY_LIST;
            }
            position -= categoryCards.size();
        }

        if (eventCards.size() > 0) {
            if (position == 0) {
                return VIEW_TYPE_LIST_HEADER;
            }
            position--;
        }
        if (position < eventCards.size()) {
            return VIEW_TYPE_EVENT_LIST;
        }
        position -= eventCards.size();


        throw new IllegalArgumentException("Error, position of viewType is a end of Adapter!");

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View eventsCardView = inflater.inflate(R.layout.list_events_card, parent, false);
        final View listHeader = inflater.inflate(R.layout.simple_header, parent, false);

        if (viewType == VIEW_TYPE_MAIN_HEADER) {
            return new Fragment2MainHeaderViewHolder(inflater, parent);
        } else if (viewType == VIEW_TYPE_SERVICE_LIST) {
            final ServiceViewHolder serviceViewHolder = new ServiceViewHolder(eventsCardView);
            serviceViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard = (EventCard) serviceViewHolder.itemView.getTag();
                    listener.OnEventCardClicked(eventCard);
                }
            });
            return serviceViewHolder;

        } else if (viewType == VIEW_TYPE_CATEGORY_LIST) {
            final CategoryViewHolder categoryViewHolder = new CategoryViewHolder(eventsCardView);
            categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard = (EventCard) categoryViewHolder.itemView.getTag();
                    listener.OnEventCardClicked(eventCard);
                }
            });
            return categoryViewHolder;

        } else if (viewType == VIEW_TYPE_EVENT_LIST) {
            final EventViewHolder eventViewHolder = new EventViewHolder(eventsCardView);
            eventViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    EventCard eventCard = (EventCard) eventViewHolder.itemView.getTag();
                    listener.OnEventCardClicked(eventCard);
                }
            });
            return eventViewHolder;

        } else if (viewType == VIEW_TYPE_LIST_HEADER) {
            return new Fragment2ListHeaderViewHolder(listHeader);
        }
        throw new IllegalArgumentException(viewType + "in not supported by this Adapter");
    }


    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Fragment2MainHeaderViewHolder) {
            Fragment2MainHeaderViewHolder holder1 = (Fragment2MainHeaderViewHolder) holder;
        }
        if (holder instanceof ServiceViewHolder) {
            position--;
            if (serviceCards.size() > 0) {
                position--;
            }
            EventCard eventCard = serviceCards.get(position);
            ((ServiceViewHolder) holder).populate(activity, eventCard);
        }
        if (holder instanceof CategoryViewHolder) {
            position--;
            if (serviceCards.size() > 0) {
                position--;
                position -= serviceCards.size();
            }
            if (categoryCards.size() > 0) {
                position--;
            }
            EventCard eventCard = categoryCards.get(position);
            ((CategoryViewHolder) holder).populate(activity, eventCard);
        }

        if (holder instanceof EventViewHolder) {
            position--;
            if (serviceCards.size() > 0) {
                position--;
                position -= serviceCards.size();
            }
            if (categoryCards.size() > 0) {
                position--;
                position -= categoryCards.size();
            }
            if (eventCards.size() > 0) {
                position--;
            }
            EventCard eventCard = eventCards.get(position);
            ((EventViewHolder) holder).populate(activity, eventCard);
        }

        if (holder instanceof Fragment2ListHeaderViewHolder) {
            Fragment2ListHeaderViewHolder fragment2ListHeaderViewHolder = (Fragment2ListHeaderViewHolder) holder;

            int servicePosition = 1;
            int categoryPosition = servicePosition + serviceCards.size() + 1;
            int eventPosition = categoryPosition + categoryCards.size() + 1;

            if (position == servicePosition) {
                fragment2ListHeaderViewHolder.populate("Service Card Heading");
            }
            if (position == categoryPosition) {
                fragment2ListHeaderViewHolder.populate("Category Card Heading");
            }
            if (position == eventPosition) {
                fragment2ListHeaderViewHolder.populate("Event Card Heading");
            }
        }
    }


    @Override
    public int getItemCount() {
        int count = 1;

        if (serviceCards.size() > 0){
            count += 1 + serviceCards.size();
        }
        if (categoryCards.size() > 0){
            count += 1 + categoryCards.size();
        }
        if (eventCards.size() > 0){
            count += 1 +eventCards.size();
        }
        return count;
    }

    public interface Fragment2Listener {
        void OnEventCardClicked(EventCard eventCard);

    }
}
