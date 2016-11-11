package com.in.mommade.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;

import com.in.mommade.R;
import com.in.mommade.databinding.ActivityMainBinding;

/**
 * Created by sravanthi.boyina on 11/11/2016.
 */

public class MainActivity extends BaseActivity {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle toogle;
    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        drawer = binding.drawerLayout;
        toogle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
            }
        };
        drawer.setDrawerListener(toogle);
        toogle.syncState();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }
}
