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
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.Entity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments.FragmentDetail;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.services.EntityServices;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-07.
 */
public class EntityPagerActivity extends BaseActivity {
    public static final String ENTITY_EXTRA_INFO = "ENTITY_EXTRA_INFO";
    private ArrayList<Entity> entities;

    @BindView(R.id.activity_entity_viewPager)
    protected ViewPager entityViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entity_pager);
        ButterKnife.bind(this);

        entities = new ArrayList<>();
        bus.post(new EntityServices.SearchEntityRequest("Hello"));
        entityViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Entity entity = entities.get(position);
                return FragmentDetail.newInstance(entity);
            }

            @Override
            public int getCount() {
                return entities.size();
            }
        });

        Entity entity = getIntent().getParcelableExtra(ENTITY_EXTRA_INFO);
        int entityId = entity.getEntityId();
        for(int i = 0; i < entities.size(); i++){
            if (entities.get(i).getEntityId() == entityId){
                entityViewPager.setCurrentItem(i);
                break;
            }
        }
    }

    @Subscribe
    public void getEntities(EntityServices.SearchEntitiesResponse response) {
        entities.clear();
        entities.addAll(response.entities);
    }

    public static Intent newIntent(Context context, Entity entity){
        Intent intent = new Intent(context, EntityPagerActivity.class);
        intent.putExtra(ENTITY_EXTRA_INFO, entity);
        return intent;
    }
}
