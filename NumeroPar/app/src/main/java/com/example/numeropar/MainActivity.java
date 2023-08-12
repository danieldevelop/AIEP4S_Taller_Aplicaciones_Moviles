package com.example.numeropar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numero;
    private TextView resultado;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero = (EditText)findViewById(R.id.inpNumero);
        resultado = (TextView)findViewById(R.id.lblResultado);
    }

    public void calcular(View v) {
        if (!String.valueOf(numero.getText()).isEmpty()) {
            int num = Integer.parseInt(String.valueOf(numero.getText()));

            if ((num % 2) == 0) {
                resultado.setText("El número " + num + " es par");
            }
        } else {
            Toast.makeText(this, "!debe ingresar algo", Toast.LENGTH_LONG).show();
        }
    }
}
