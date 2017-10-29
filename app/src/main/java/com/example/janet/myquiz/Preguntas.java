package com.example.janet.myquiz;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by janet on 22/10/17.
 */

public class Preguntas {

    static private JSONArray preguntas;
    static private int contador = 0;
    static private int aciertos = 0;

    static void init (Context context) {
        InputStream is = context.getResources().openRawResource(R.raw.preguntas);
        Writer writer = new StringWriter();
        char[] buffer = new char[1024];
        try {
            Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            int n;
            while ((n = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, n);
            }
            is.close();
            preguntas = new JSONArray(writer.toString());
        } catch (Exception e) {
            Log.d("Preguntas init", e.toString());
        }
    }
    
    static JSONObject damePregunta(){
        try {
            return preguntas.getJSONObject(contador++);
        } catch (Exception e) {
            Log.d("Preguntas damePregunta", e.toString());
        }
        return null;
    }

    static boolean hayMas() {
        if (contador < preguntas.length()){
            return true;
        }
        else{
            return false;
        }
    }

    static void evaluar(JSONObject pregunta, String respuesta) {
        try {
            if (pregunta.getString("correct").equalsIgnoreCase(respuesta)) {
                aciertos++;
            }
        } catch (Exception e) {
            Log.d("Preguntas evaluar", e.toString());
        }
    }

    static int puntuacion() {
        return aciertos*10/preguntas.length();
    }
}
