package com.q2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created with IntelliJ IDEA.
 * User: gron
 * Date: 5/27/12
 * Time: 1:30 PM
 */
public class NotificationActivity extends Activity {

    public static final String NOTIFICATION_STRING="NotificationString";

    public void onCreate(Bundle savedInstanceState) {
        // set view
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification);

        // change textview text from intent
        Bundle bundle = getIntent().getExtras();
        String newData = bundle.getString(NOTIFICATION_STRING);
        if(newData != null){
            TextView tv = (TextView) findViewById(R.id.tv);
            tv.setText(newData);
        }
    }
}