package com.gre.hassanshah.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;

public class MainActivity extends Activity {

    SharedPreferences shared_prefs;

    private static String CONSUMER_KEY = "0rk4eWtkpCvlgyG83UJQhJ0aL";
    private static String CONSUMER_SECRET = "K95loCqsQ7MDONiLenQcxNzajOpY1Yoi7oN8q09FnhKnNYK8T2";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        shared_prefs = getPreferences(0);
        SharedPreferences.Editor edit = shared_prefs.edit();

        // if consumer key and consumer secret key are not set
        if ((shared_prefs.getString("CONSUMER_KEY", null) == null) || (shared_prefs.getString("CONSUMER_SECRET", null) == null)) {
            edit.putString("CONSUMER_KEY", CONSUMER_KEY);
            edit.putString("CONSUMER_SECRET", CONSUMER_SECRET);
            edit.commit();
        }

        /* if user's access token and and secret key are not then show login fragment or else show
           profile page */
        if ((shared_prefs.getString("ACCESS_TOKEN", null) == null) || (shared_prefs.getString("ACCESS_TOKEN_SECRET", null) == null)) {
            Fragment loginFrag = new LoginFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, loginFrag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        } else {
            // TODO: else set up timeline instead of profile
            Fragment profileFrag = new ProfileFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, profileFrag);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();
        }

    }
}
