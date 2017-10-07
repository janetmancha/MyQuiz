package com.example.janet.myquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.buttonInicio).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent preguntaActivity = new Intent(getApplicationContext(), PreguntaActivity.class);
                startActivity(preguntaActivity);
            }
        });
    }
}
