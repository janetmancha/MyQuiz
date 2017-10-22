package com.example.janet.myquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.respuestas);
        final RadioButton r1 = (RadioButton) findViewById(R.id.radioButton1);
        final RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
        final RadioButton r3 = (RadioButton) findViewById(R.id.radioButton3);
        final Pregunta preguntaActual = Preguntas.damePregunta();

        textView.setText(preguntaActual.pregunta);
        r1.setText(preguntaActual.respuestas[0]);
        r2.setText(preguntaActual.respuestas[1]);
        r3.setText(preguntaActual.respuestas[2]);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                int radioButtonID = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = radioGroup.findViewById(radioButtonID);

                if (radioButton == null){
                    String message = "Debes seleccionar alguna respuesta";
                    Toast.makeText(getApplicationContext(), message,Toast.LENGTH_SHORT).show();
                    return;
                }

                String respuesta = radioButton.getText().toString();

                Intent nextActivity;
                if (Preguntas.hayMas()) {
                    nextActivity = new Intent(getApplicationContext(), PreguntaActivity.class);
                } else {
                    nextActivity = new Intent(getApplicationContext(), ResultActivity.class);
                }
                Preguntas.hasAcertado(preguntaActual.esCorrecta(respuesta));
                startActivity(nextActivity);
            }
        });
    }
}

