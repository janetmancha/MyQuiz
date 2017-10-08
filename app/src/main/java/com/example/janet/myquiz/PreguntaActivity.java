package com.example.janet.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by janet on 5/10/17.
 */

public class PreguntaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button button = (Button) findViewById(R.id.button);
        final RadioButton r1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton r3 = (RadioButton) findViewById(R.id.radioButton3);

        textView.setText("Pregunta 1");
        r1.setText("Respuesta 1A");
        r2.setText("Respuesta 1B");
        r3.setText("Respuesta 1C");

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer countNumber = 0;
                String message;

                Intent pregunta2Activity = new Intent(getApplicationContext(), Pregunta2Activity.class);
                if (r1.isChecked()) {
                    countNumber = countNumber + 1;
                }

                if (!r1.isChecked() && !r2.isChecked() && !r3.isChecked()){
                    message = "Debes seleccionar alguna respuesta";
                    Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
                    return;
                }

                Log.d("PreguntaActivity","countNumber is " + countNumber);
                pregunta2Activity.putExtra("countNumber",countNumber);
                startActivity(pregunta2Activity);
            }
        });
    }
}

