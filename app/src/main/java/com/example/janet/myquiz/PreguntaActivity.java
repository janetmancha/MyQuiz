package com.example.janet.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by janet on 5/10/17.
 */

public class PreguntaActivity extends AppCompatActivity {

    String[][] preguntas = new String[3][5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta);
        final TextView textView = (TextView) findViewById(R.id.textView);
        final Button button = (Button) findViewById(R.id.button);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.respuestas);
        final RadioButton r1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton r3 = (RadioButton) findViewById(R.id.radioButton3);

        preguntas[0][0] = "De que color es la leche?";
        preguntas[0][1] = "Roja";
        preguntas[0][2] = "Verde";
        preguntas[0][3] = "Blanca";
        preguntas[0][4] = "Blanca";

        preguntas[1][0] = "De que color es el carbon?";
        preguntas[1][1] = "Negro";
        preguntas[1][2] = "Verde";
        preguntas[1][3] = "Azul";
        preguntas[1][4] = "Negro";

        preguntas[2][0] = "De que color es el sol?";
        preguntas[2][1] = "Negro";
        preguntas[2][2] = "Amarillo";
        preguntas[2][3] = "Rosa";
        preguntas[2][4] = "Amarillo";

        final Integer numeroPregunta = getIntent().getIntExtra("numeroPregunta",0);

        textView.setText(preguntas[numeroPregunta][0]);
        r1.setText(preguntas[numeroPregunta][1]);
        r2.setText(preguntas[numeroPregunta][2]);
        r3.setText(preguntas[numeroPregunta][3]);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Integer hitNumber = getIntent().getIntExtra("hitNumber",0);

                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(radioButtonID);

                if (radioButton == null){
                    String message = "Debes seleccionar alguna respuesta";
                    Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
                    return;
                }

                String respuesta = radioButton.getText().toString();

                Intent nextActivity;
                if (numeroPregunta < 2 ) {
                    nextActivity = new Intent(getApplicationContext(), PreguntaActivity.class);
                } else {
                    nextActivity = new Intent(getApplicationContext(), ResultActivity.class);
                }

                nextActivity.putExtra("numeroPregunta",numeroPregunta + 1);
                if (respuesta.equalsIgnoreCase(preguntas[numeroPregunta][4])){
                    nextActivity.putExtra("hitNumber",hitNumber + 1);
                } else {
                    nextActivity.putExtra("hitNumber",hitNumber);
                }
                startActivity(nextActivity);
            }
        });
    }
}

