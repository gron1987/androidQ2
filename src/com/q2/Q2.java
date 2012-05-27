package com.q2;

import android.R;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created with IntelliJ IDEA.
 * User: gron
 * Date: 5/27/12
 * Time: 12:42 AM
 */
public class Q2 extends Service {

    private static final int NOTIFICATION_ID = 1;

    public void onCreate() {
        // create notification manager and notification
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification = new Notification(R.drawable.btn_plus, "Top message", System.currentTimeMillis());

        // data for notification
        Context context = getApplicationContext();
        CharSequence notificationTitle = "Notification";
        CharSequence notificationText = "Notification main text";
        Intent notificationIntent = new Intent(this, NotificationActivity.class);
        // extra data which we will use in notification activity
        notificationIntent.putExtra(
                NotificationActivity.NOTIFICATION_STRING,
                "Some text data " + Long.toString(System.currentTimeMillis())
        );

        // start this activity after click on notification
        PendingIntent contentIntent = PendingIntent.getActivity(
                this,
                0,
                notificationIntent,
                PendingIntent.FLAG_CANCEL_CURRENT
        );

        // set notification and notify
        notification.setLatestEventInfo(context, notificationTitle, notificationText, contentIntent);
        nm.notify(NOTIFICATION_ID, notification);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
