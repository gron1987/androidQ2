package com.q2;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends ListActivity {
    public static final String LOG_I_STATUS_TAG = "Status";
    public static Context context;
    private ListItem[] items;

    /**
     * Show toast message for battery status
     *
     * @param level
     */
    public static void showToast(int level) {
        Toast.makeText(
                MainActivity.context,
                context.getString(R.string.batteryStatusChanged) + Integer.toString(level),
                Toast.LENGTH_SHORT
        ).show();
    }

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_I_STATUS_TAG, "OnCreate");
        super.onCreate(savedInstanceState);

        // get info when battery capacity changed
        context = getApplicationContext();
        registerReceiver(new BatteryInfoReceiver(), new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        // start service
        Intent serviceIntent = new Intent(this, Q2Service.class);
        startService(serviceIntent);

        ArrayList<ListItem> items = new ArrayList<ListItem>();
        for(int i=0;i<10;i++){
            items.add(new ListItem(
                getResources().getDrawable(R.drawable.red),
                getResources().getDrawable(R.drawable.gray),
                "Item 1 " + Integer.toString(i),
                "Item 2 " + Integer.toString(i)
            ));
        }

        BaseAdapter adapter = new ItemAdapter(getApplicationContext(),items);
        setListAdapter(adapter);
    }

    /**
     * Called after activity created or activity restarted
     */
    public void onStart() {
        Log.i(LOG_I_STATUS_TAG, "OnStart");
        super.onStart();
    }

    /**
     * Called after activity start or when user return to activity (activity come back to main screen from foreground)
     */
    public void onResume() {
        Log.i(LOG_I_STATUS_TAG, "OnResume");
        super.onResume();
    }

    /**
     * Called when activity not visible (new activity open, home screen etc.). Called after onResume
     */
    public void onStop() {
        Log.i(LOG_I_STATUS_TAG, "OnStop");
        super.onStop();
    }

    /**
     * Called when activity finishing or being destroyed by the system. Called after onResume
     */
    public void onDestroy() {
        Log.i(LOG_I_STATUS_TAG, "OnDestroy");
        super.onDestroy();
    }

    /**
     * Called when activity start visible again after it was non-visible. Called after onStop.
     */
    public void onRestart() {
        Log.i(LOG_I_STATUS_TAG, "OnRestart");
        super.onRestart();
    }
}
