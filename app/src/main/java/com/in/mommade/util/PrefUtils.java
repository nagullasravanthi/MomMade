package com.in.mommade.util;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;

/**
 * Created by kartheek.sabbisetty on 18-03-2016.
 */
public class PrefUtils {

    public static final String PREF_NAME = "MomMadePref";

    public static void saveStringInSP(Context mContext, String key, HashSet Value){
        SharedPreferences sp = mContext.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putStringSet(key,Value);
        ed.commit();
    }
    public static String getStringFromSP(Context mcontext,String key){
        SharedPreferences sp = mcontext.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        return sp.getString(key,"");
    }
}
