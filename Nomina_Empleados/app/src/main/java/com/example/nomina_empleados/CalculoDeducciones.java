package com.example.nomina_empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import adnroid.widget.Button;
import adnroid.widget.CheckBox;
import adnroid.widget.EditText;
import adnroid.widget.RadioButton;
import adnroid.widget.TextView;

public class CalculoDeducciones extends AppCompatActivity {

    private EditText diasNoTrabajadas;
    private EditText valorDiaNoTrabajadas;
    private EditText horasNoTrabajadas;
    private EditText valorHorasTrabajadas;
    private CheckBox deduccionesDias;
    private CheckBox deduccionesHoras;
    private TextView resultadoDeducciones;

    private int noTrabajadas;
    private float precioNoTrabajadas;
    private int hrsNoTrabajadas;
    private float valHorasNoTrabajadas;
    private String result;

    @Override
    protected onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_deducciones);

        diasNoTrabajadas = (EditText) findViewById(R.id.txtNoTrabajadas);
        valorDiaNoTrabajadas = (EditText) findViewById(R.id.txtValorDia);
        horasNoTrabajadas = (EditText) findViewById(R.id.txtHrsNoTrabajadas);
        valorHorasTrabajadas = (EditText) findViewById(R.id.txtValorHoras);
        deduccionesDias = (CheckBox) findViewById(R.id.ckbDeduccionesDias);
        deduccionesHoras = (CheckBox) findViewById(R.id.ckbDeduccionesHoras);
        resultadoDeducciones = (TextView) findViewById(R.id.txtResultadoDeducciones);
    }

    // Boton Inicio
    public void IrHome(View view) {
        Intent home = new Intent(CalculoDeducciones.this, MainActivity.class);
        startActivity(home);
    }

    public void CalcularDeducciones(View view) {
        noTrabajadas = Integer.parseInt(diasNoTrabajadas.getText().toString());
        precioNoTrabajadas = Float.parseFloat(valorDiaNoTrabajadas.getText().toString());
        hrsNoTrabajadas = Integer.parseInt(horasNoTrabajadas.getText().toString());
        valHorasNoTrabajadas = Float.parseFloat(valorHorasTrabajadas.getText().toString());

        result = " ";
        if (deduccionesDias.isChecked()) {
            result = "Dia's no trabajada's son: $" + (noTrabajadas * precioNoTrabajadas) + ".";
        }

        if (deduccionesHoras.isChecked()) {
            result = result + "\nHora's no trabajada's es: $" + (hrsNoTrabajadas * valHorasTrabajadas) + ".";
        }

        // Mostraremos los resultados
        resultadoDeducciones.setText(String.valueOf(result));
    }
}