package com.malo.androiddev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TimerActivity extends AppCompatActivity {

    TextView decompte;
    Button cached;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        setTitle("Minuteur");

        decompte = findViewById(R.id.decompte);
        cached = findViewById(R.id.hidden_button);
    }

    public void timer(View view) {
        Intent intent = new Intent(TimerActivity.this, TimerSelectActivity.class);
        startActivityForResult(intent, 3);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        cached.setVisibility(View.VISIBLE);
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 3 && resultCode == Activity.RESULT_OK) {
            int countdownValue = data.getIntExtra("countdownValue",0);
            decompte.setText(String.valueOf(countdownValue));



            new CountDownTimer(countdownValue*1000,1000) {

                @Override
                public void onTick(long millisLeft) {
                    final long instantMilli= millisLeft;
                    decompte.setText(String.valueOf(millisLeft/1000) + " s");
                    cached.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            Toast.makeText(TimerActivity.this, "Vous êtes à " + String.valueOf(instantMilli/1000) + " s", Toast.LENGTH_LONG).show();
                        }
                    });
                }

                @Override
                public void onFinish() {
                    decompte.setText("Créer un décompte");
                    cached.setVisibility(View.INVISIBLE);
                }
            }.start();

        }
    }
}
