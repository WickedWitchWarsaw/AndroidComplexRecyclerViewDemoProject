package com.wickedwitchwarsaw.recyclerviewcomplexproject.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;
import com.wickedwitchwarsaw.recyclerviewcomplexproject.entities.RushEvent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZuZ on 2016-10-18.
 */
public class LocalMapActivity extends BaseActivity {

    @BindView(R.id.activity_local_map)
    protected WebView localWebViewMap;

    @BindView(R.id.activity_localMap_rush_name)
    protected TextView mapName;
    @BindView(R.id.activity_localMap_rush_date)
    protected TextView mapDate;
    @BindView(R.id.activity_localMap_rush_time)
    protected TextView mapTime;
    @BindView(R.id.activity_localMap_rush_description)
    protected TextView mapDescription;
    @BindView(R.id.activity_localMap_rush_address)
    protected TextView mapLocation;

    @BindView(R.id.progressBar_activity_local_map)
    protected ProgressBar progressBarLocalMap;

    public static final String RUSH_EVENT_INFO = "RUSH_EVENT_INFO";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_map);
        ButterKnife.bind(this);

        RushEvent rushEvent = getIntent().getParcelableExtra(RUSH_EVENT_INFO);

        mapName.setText(rushEvent.getEventName());
        mapDate.setText(rushEvent.getEventDate());
        mapTime.setText(rushEvent.getEventTime());
        mapLocation.setText(rushEvent.getEventLocation());
        mapDescription.setText(rushEvent.getEventDescription());

        String googleDocs = "http://docs.google.com/gview?embedded=true&url=";

        progressBarLocalMap.setMax(100);

        localWebViewMap.getSettings().setJavaScriptEnabled(true);
        localWebViewMap.getSettings().setBuiltInZoomControls(true);
        localWebViewMap.getSettings().setSupportZoom(true);

        localWebViewMap.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if(newProgress == 100){
                    progressBarLocalMap.setVisibility(View.GONE);
                } else {
                    progressBarLocalMap.setVisibility(View.VISIBLE);
                    progressBarLocalMap.setProgress(newProgress);
                }
            }
        });

        localWebViewMap.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return false;
            }
        });

        localWebViewMap.loadUrl(googleDocs + "http://www.asu.edu/map/pdf/asu_map_tempe_2015.pdf");
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode == KeyEvent.KEYCODE_BACK && localWebViewMap.canGoBack()){
            localWebViewMap.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    public static Intent newIntent(Context context, RushEvent rushEvent){
        Intent intent = new Intent(context, LocalMapActivity.class);
        intent.putExtra(RUSH_EVENT_INFO, rushEvent);
        return intent;
    }
}
