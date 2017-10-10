package com.example.janet.myquiz;

/**
 * Created by janet on 10/10/17.
 */

public class Pregunta {
    String pregunta;
    String [] respuestas = new String[3];
    Integer respuestaCorrecta;

    Pregunta(String pregunta, String respuesta1, String respuesta2, String respuesta3, Integer respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuestas[0] = respuesta1;
        this.respuestas[1] = respuesta2;
        this.respuestas[2] = respuesta3;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public boolean esCorrecta(String respuesta) {
        return respuesta.equalsIgnoreCase(this.respuestas[respuestaCorrecta]);
    }

}
