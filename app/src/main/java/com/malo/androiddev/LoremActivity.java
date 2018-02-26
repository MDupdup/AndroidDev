package com.malo.androiddev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.Toast;

public class LoremActivity extends AppCompatActivity {

    private Button button;

    private ScrollView scrollView;

    private static final String TAG = LoremActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lorem);

        setTitle("Lorem Ipsum Reader");

        Toast.makeText(this,"Bienvenue !",Toast.LENGTH_LONG).show();

        button = (Button) findViewById(R.id.button);

        scrollView = (ScrollView) findViewById(R.id.scroll);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                Toast.makeText(getApplicationContext(),"Vous êtes revenu au début de l'article !",Toast.LENGTH_LONG).show();
            }
        });




        Log.i(TAG, "onCreate");
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
