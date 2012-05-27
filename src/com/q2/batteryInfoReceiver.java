package com.q2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;

/**
 * Created with IntelliJ IDEA.
 * User: gron
 * Date: 5/27/12
 * Time: 12:40 AM
 */
public class batteryInfoReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
        MainActivity.showToast(level);
    }
}
