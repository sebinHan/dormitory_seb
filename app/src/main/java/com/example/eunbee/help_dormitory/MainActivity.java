package com.example.eunbee.help_dormitory;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity extends BaseActivity {
    private static final String TAG = "MainActivity";

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        // Obtain the FirebaseAnalytics instance.
        if (getIntent().getExtras() != null) {
            for (String key : getIntent().getExtras().keySet()) {
                Object value = getIntent().getExtras().get(key);
                Log.d(TAG, "Key: " + key + " Value: " + value);
            }
        }
        startActivity(new Intent(this,GoLoginPageActivity.class));

    }
}

