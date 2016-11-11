package com.in.mommade.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.in.mommade.R;
import com.in.mommade.util.Constants;

/**
 * Created by sravanthi.boyina on 9/21/2016.
 */
public class SplashScreenActivity extends Activity {

    private Handler splash_time_handler;
    private Runnable r_callingMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        splash_time_handler = new Handler();
        splash_time_handler.postDelayed(r_callingMenu = new Runnable() {
            @Override
            public void run() {

                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();


            }
        }, Constants.SPLASHTIME);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        splash_time_handler.removeCallbacks(r_callingMenu);
    }

}


