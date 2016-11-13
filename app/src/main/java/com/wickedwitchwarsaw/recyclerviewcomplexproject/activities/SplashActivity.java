 package com.wickedwitchwarsaw.recyclerviewcomplexproject.activities;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.wickedwitchwarsaw.recyclerviewcomplexproject.R;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.start(SplashActivity.this);
                finish();
            }
        }, 3000);


    }
}
