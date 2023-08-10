package com.example.myapplication;

import android.content.Context;
import android.widget.Toast;

public class Test {

    public static void myToast(Context myContext) {
        Toast.makeText(myContext, "Hola, desde una Clase in JAVA", Toast.LENGTH_LONG).show();
    }

    public static void Start(Context myContext) {
        Toast.makeText(myContext, "onStart", Toast.LENGTH_LONG).show();
    }

    public static void Resume(Context myContext) {
        Toast.makeText(myContext, "onResume", Toast.LENGTH_LONG).show();
    }

    public static void Pause(Context myContext) {
        Toast.makeText(myContext, "onPause", Toast.LENGTH_LONG).show();
    }

    public static void Stop(Context myContext) {
        Toast.makeText(myContext, "onStop", Toast.LENGTH_LONG).show();
    }

    public static void Restart(Context myContext) {
        Toast.makeText(myContext, "onRestart", Toast.LENGTH_LONG).show();
    }

    public static void Destroy(Context myContext) {
        Toast.makeText(myContext, "onDestroy", Toast.LENGTH_LONG).show();
    }
}
