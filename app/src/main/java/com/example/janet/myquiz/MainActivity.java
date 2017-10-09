package com.example.janet.myquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = (TextView) findViewById(R.id.textViewPresentacion);

        textView.setText("Bienvenido a mi juego de preguntas:Contesta a todas las preguntas y al final tendras el resultado.Comienza el juego pulsando el boton de inicio.");

        findViewById(R.id.buttonInicio).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent preguntaActivity = new Intent(getApplicationContext(), PreguntaActivity.class);
                startActivity(preguntaActivity);
            }
        });
    }
}
