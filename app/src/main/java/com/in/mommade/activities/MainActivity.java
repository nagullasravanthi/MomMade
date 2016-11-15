package com.in.mommade.activities;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.in.mommade.R;
import com.in.mommade.databinding.ActivityMainBinding;


/**
 * Created by sravanthi.boyina on 11/11/2016.
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private DrawerLayout drawer;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    ActivityMainBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initNavigationDrawer();
        initViews();
    }

    private void initViews(){
        binding.ivMenu.setOnClickListener(this);
    }
    public void initNavigationDrawer() {

        NavigationView navigationView =binding.navigationView;
        View header = navigationView.getHeaderView(0);
        TextView tv_email = (TextView) header.findViewById(R.id.user_email);
        tv_email.setText("raj.amalw@learn2crack.com");
        drawer = binding.drawerLayout;

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close) {

            @Override
            public void onDrawerClosed(View v) {
                super.onDrawerClosed(v);
            }

            @Override
            public void onDrawerOpened(View v) {
                super.onDrawerOpened(v);
            }
        };
        drawer.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.home:
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawers();
                        break;
                    case R.id.settings:
                        Toast.makeText(getApplicationContext(), "Settings", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.addresses:
                        Toast.makeText(getApplicationContext(), "addresses", Toast.LENGTH_SHORT).show();
                        drawer.closeDrawers();
                        break;
                    case R.id.logout:
                        finish();

                }
                return true;
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
             case R.id.iv_menu:
                if (drawer.isDrawerOpen(Gravity.LEFT)) {
                    drawer.closeDrawer(Gravity.LEFT);
                } else{
                    drawer.openDrawer(Gravity.LEFT);}
                break;
        }
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }
}
