package com.in.mommade;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by sravanthi.boyina on 8/4/2016.
 */
public class AppController extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
       // Fabric.with(this, new Crashlytics());
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("assests/mavenpro_regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
