package com.malo.androiddev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Random;

public class LanceDeActivity extends AppCompatActivity {

    public int randomNumberOne = 0;
    public int randomNumberTwo = 0;
    public int randomNumberThree = 0;
    public int randomizeCount = 0;

    TextView tv1;
    TextView tv2;
    TextView tv3;

    private static final String TAG = LoremActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancede);

        setTitle("Lanceur de Dés");

        TextView tv1 = findViewById(R.id.number_one);
        TextView tv2 = findViewById(R.id.number_two);
        TextView tv3 = findViewById(R.id.number_three);
        TextView tv4 = findViewById(R.id.number_lol);

        if (savedInstanceState != null) {

            randomizeCount = savedInstanceState.getInt("randomize");

            randomizeCount = savedInstanceState.getInt("randomize") + 1;

            if(randomizeCount > 1) {
                savedInstanceState = null;
                randomizeCount = 0;
            } else {
                randomNumberOne = savedInstanceState.getInt("one");
                randomNumberTwo = savedInstanceState.getInt("two");
                randomNumberThree = savedInstanceState.getInt("three");
            }

        } else {
            Random rdm = new Random();

            randomNumberOne = rdm.nextInt(6)+1;
            randomNumberTwo = rdm.nextInt(6)+1;
            randomNumberThree = rdm.nextInt(6)+1;
        }

        tv1.setText(String.valueOf(randomNumberOne));
        tv2.setText(String.valueOf(randomNumberTwo));
        tv3.setText(String.valueOf(randomNumberThree));
        tv4.setText(String.valueOf(randomizeCount));
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

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt("one",randomNumberOne);
        savedInstanceState.putInt("two",randomNumberTwo);
        savedInstanceState.putInt("three",randomNumberThree);
        savedInstanceState.putInt("randomize",randomizeCount);

        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        randomNumberOne = savedInstanceState.getInt("one");
        randomNumberTwo = savedInstanceState.getInt("two");
        randomNumberThree = savedInstanceState.getInt("three");
        randomizeCount =  savedInstanceState.getInt("randomize");
    }
}
