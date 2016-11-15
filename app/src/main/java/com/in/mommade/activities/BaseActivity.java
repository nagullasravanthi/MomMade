package com.in.mommade.activities;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by sravanthi.boyina on 7/26/2016.
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showToast(Context ctx, String msg){
        Toast.makeText(ctx,msg,Toast.LENGTH_LONG).show();
    }
}
