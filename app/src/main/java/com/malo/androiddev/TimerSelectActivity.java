package com.malo.androiddev;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Malo on 20/02/2018.
 */

public class TimerSelectActivity extends AppCompatActivity {

    Button submitButton;
    EditText countdownValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_select);

        setTitle("Minuteur");

        submitButton = findViewById(R.id.button_countdown);
        countdownValue = findViewById(R.id.editText);

        submitButton.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        if(!countdownValue.getText().toString().isEmpty()) {
                            Intent intent = new Intent();
                            intent.putExtra("countdownValue",Integer.parseInt(countdownValue.getText().toString()));
                            setResult(Activity.RESULT_OK,intent);
                            Log.i("mdr","ptn"+Integer.parseInt(countdownValue.getText().toString()));
                            finish();
                        } else {
                            Toast.makeText(TimerSelectActivity.this,"Veuillez remplir le champ !",Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
}
