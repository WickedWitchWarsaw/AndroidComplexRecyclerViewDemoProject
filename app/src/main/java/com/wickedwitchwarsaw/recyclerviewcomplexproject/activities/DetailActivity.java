package com.wickedwitchwarsaw.recyclerviewcomplexproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.Entity;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments.FragmentDetail;

/**
 * Created by ZuZ on 2016-09-25.
 */
public class DetailActivity extends BaseActivity {

    public static final String ENTITY_EXTRA_INFO = "ENTITY_EXTRA_INFO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.activity_detail_fragment_container);

        if(fragment == null){
            fragment = null;
            fragmentManager.beginTransaction()
                    .add(R.id.activity_detail_fragment_container, fragment)
                    .commit();
        }

    }

    public static Intent newIntent(Context context, Entity entity){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(ENTITY_EXTRA_INFO, entity);
        return intent;
    }
}
