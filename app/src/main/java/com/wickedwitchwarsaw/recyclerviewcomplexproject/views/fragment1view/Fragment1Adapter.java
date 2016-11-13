package com.wickedwitchwarsaw.recyclerviewcomplexproject.views.fragment1view;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.activities.BaseActivity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.Entity;

import java.util.ArrayList;

/**
 * Created by ZuZ on 2016-09-24.
 */

public class Fragment1Adapter extends RecyclerView.Adapter<Fragment1ViewHolder>
        implements View.OnClickListener {

    private LayoutInflater inflater;
    private BaseActivity activity;
    private EntityClickerListener listener;
    private ArrayList<Entity> entities;


    public Fragment1Adapter(EntityClickerListener listener, BaseActivity activity) {
        this.activity = activity;
        this.listener = listener;
        inflater = activity.getLayoutInflater();
        entities = new ArrayList<>();
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }


    @Override
    public Fragment1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View listView = inflater.inflate(R.layout.list_recyclerview_look, parent, false);
        listView.setOnClickListener(this);
        return new Fragment1ViewHolder(listView);
    }

    @Override
    public void onBindViewHolder(Fragment1ViewHolder holder, int position) {
        holder.populate(activity, entities.get(position));
    }

    @Override
    public int getItemCount() {
        return entities.size();
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() instanceof Entity){
            Entity entity = (Entity) view.getTag();
            listener.OnEntityClicked(entity);
        }

    }

    public interface EntityClickerListener{
        void OnEntityClicked(Entity entity);
    }
}
