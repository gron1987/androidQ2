package com.q2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends Activity
{
    public static Context context;

    /**
     * Show toast message for battery status
     * @param level
     */
    public static void showToast(int level){
        Toast.makeText(
                MainActivity.context,
                context.getString(R.string.batteryStatusChanged) + Integer.toString(level),
                Toast.LENGTH_SHORT
        ).show();
    }
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        // get info when battery capacity changed
        context = getApplicationContext();
        registerReceiver(new batteryInfoReceiver(), new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        // start service
        Intent serviceIntent = new Intent(this, Q2Service.class);
        startService(serviceIntent);
    }
}
