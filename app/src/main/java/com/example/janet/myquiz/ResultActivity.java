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

        if (Preguntas.puntuacion()<5) {
            textView.setText("Suspenso");
        } else {
            textView.setText("Aprobado");
        }
    }
}
