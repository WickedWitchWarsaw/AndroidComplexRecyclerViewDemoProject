package com.wickedwitchwarsaw.recyclerviewcomplexproject.views;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments.Fragment1;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments.Fragment2;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments.Fragment3;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.fragments.Fragment4;

/**
 * Created by ZuZ on 2016-09-24.
 */

public class MainActivityViewPagerAdapter extends FragmentStatePagerAdapter {
    public MainActivityViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment returnFragment;
        switch (position) {
            case 0:
                returnFragment = Fragment1.newInstance();
                break;
            case 1:
                returnFragment = Fragment2.newInstance();
                break;
            case 2:
                returnFragment = Fragment3.newInstance();
                break;
            case 3:
                returnFragment = Fragment4.newInstance();
                break;
            default:
                return null;
        }
        return returnFragment;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence title;
        switch (position) {
            case 0:
                title = "Fragment 1 TEST";
                break;
            case 1:
                title = "Fragment 2 DEMO";
                break;
            case 2:
                title = "Fragment 3 RUSH";
                break;
            case 3:
                title = "Fragment 4 NEW";
                break;

            default:
                return null;
        }
        return title;
    }
}
