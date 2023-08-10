package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int result = check();
        // Con este metodo mostramos un tipo de alerta sencillo
        Toast.makeText(this, "Hola desde el curso Aprendiendo Android: "+result, Toast.LENGTH_LONG).show();
        Toast.makeText(this, "Hola Sr(a). " + new Person("Alejandro Matei"), Toast.LENGTH_LONG).show();



        // Redirigir a otra ventana (Activity)
        Button button2;

        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });
    }








    private int check()
    {
        int a = 5;
        int b = 10;
        int c = 20;

        if (a > b) {
            return 0;
        } else {
            if (c > a) {
                return c;
            } else {
                return a;
            }
        }
    }

    public class Person
    {
        public String name;

        Person(String name) {
            super();
            this.name = name;
        }

        @Override
        public String toString() {
            return name.toString();
        }
    }

}