package com.example.janet.myquiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by janet on 22/10/17.
 */

public class Preguntas {

    static private Pregunta[] preguntas = new Pregunta[4];
    static private int contador = 0;
    static private int aciertos = 0;

    static void init () {
        preguntas[0] = new Pregunta("De que color es la leche?", "Roja", "Verde", "Blanca", 2);
        preguntas[1] = new Pregunta("De que color es el carbon?", "Negro", "Verde", "Azul", 0);
        preguntas[2] = new Pregunta("De que color es el sol?", "Negro", "Amarillo", "Rosa", 1);
        preguntas[3] = new Pregunta("De que color es el cielo?", "Negro", "Amarillo", "Azul", 2);
    }
    
    static Pregunta damePregunta(){
        return preguntas[contador++];
    }

    static boolean hayMas() {
        if (contador < preguntas.length){
            return true;
        }
        else{
            return false;
        }
    }

    static void hasAcertado(boolean r) {
        if (r==true){
            aciertos++;
        }
    }

    static int puntuacion() {
        return aciertos*10/preguntas.length;
    }
}
