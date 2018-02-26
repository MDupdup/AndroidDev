package com.malo.androiddev;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Malo on 20/02/2018.
 */

public class HelloWorldActivity extends AppCompatActivity{

    private static final String TAG = HelloWorldActivity.class.getName();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_helloworld);
    }

    @Override
    protected void onStart() {
        Log.i(TAG,"onStart");

        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG,"onResume");

        super.onResume();
    }

    @Override
    protected void onStop() {
        Log.i(TAG,"onStop");

        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy");

        super.onDestroy();
    }
}
