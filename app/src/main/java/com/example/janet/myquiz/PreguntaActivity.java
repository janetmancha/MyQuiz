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

    Pregunta[] preguntas = new Pregunta[3];

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

        preguntas[0] = new Pregunta("De que color es la leche?", "Roja", "Verde", "Blanca", 2);
        preguntas[1] = new Pregunta("De que color es el carbon?", "Negro", "Verde", "Azul", 0);
        preguntas[2] = new Pregunta("De que color es el sol?", "Negro", "Amarillo", "Rosa", 1);

        final Integer numeroPregunta = getIntent().getIntExtra("numeroPregunta",0);

        final Pregunta preguntaActual = preguntas[numeroPregunta];

        textView.setText(preguntaActual.pregunta);
        r1.setText(preguntaActual.respuestas[0]);
        r2.setText(preguntaActual.respuestas[1]);
        r3.setText(preguntaActual.respuestas[2]);

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
                if (preguntaActual.esCorrecta(respuesta)) {
                    nextActivity.putExtra("hitNumber",hitNumber + 1);
                } else {
                    nextActivity.putExtra("hitNumber",hitNumber);
                }
                startActivity(nextActivity);
            }
        });
    }
}

