package com.example.indice_masa_corporal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Variables tipo Componente/Widget's
    private EditText peso;
    private EditText altura;
    private TextView resultado;
    // Variables tipos de datos
    private double miPeso;
    private double miAltura;
    private double imc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        peso = (EditText) findViewById(R.id.txtPeso);
        altura = (EditText) findViewById(R.id.txtAltura);
        resultado = (TextView) findViewById(R.id.lblResult);
    }

    public void ObtenerIMC(View v) 
    {
        if (!String.valueOf(peso).isEmpty() && !String.valueOf(altura).isEmpty()) {
            miPeso = Double.parseDouble(peso.getText().toString());
            miAltura = Double.parseDouble(altura.getText().toString());

            imc = (miPeso / Math.pow(miAltura, 2));

            if (imc < 18.5) {
                resultado.setText("Su IMC es: " + String.valueOf(String.format("%.3f", imc)) + "\nEstado: 'BAJO PESO'");
            } else if (imc >= 18.5 && imc <= 24.9) {
                resultado.setText("Su IMC es: " + String.valueOf(String.format("%.3f", imc)) + "\nEstado: 'SALUDABLE'");
            } else if (imc 25.0 && imc <= 30) {
                resultado.setText("Su IMC es: " + String.valueOf(String.format("%.3f", imc)) + "\nEstado: 'SOBREPESO'");
            } else {
                resultado.setText("Su IMC es: " + String.valueOf(String.format("%.3f", imc)) + "\nEstado: 'OBESIDAD'");
            }

        } else {
            Toast.makeText(this, "!Debe ingresar peso y altura", Toast.LENGTH_LONG).show();
        }
    }
}