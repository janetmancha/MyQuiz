package com.example.janet.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by janet on 8/10/17.
 */

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        final TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("Resultado");

        Integer hitNumber = getIntent().getIntExtra("hitNumber",0);
        Log.d("ResultActivity","hitNumber is " + hitNumber);

        if (hitNumber == 3) {
            textView.setText("Muy Bien");
        } else if (hitNumber == 0){
            textView.setText("Muy Mal");
        } else if (hitNumber == 1){
            textView.setText("Mal");
        }else if (hitNumber == 2){
            textView.setText("Bien");
        }
    }
}
