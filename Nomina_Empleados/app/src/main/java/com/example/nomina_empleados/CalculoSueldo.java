package com.example.nomina_empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class CalculoSueldo extends AppCompatActivity {

    private EditText sueldoDiario;
    private EditText valorSueldoDiario;
    private EditText horasTrabajadas;
    private EditText precioHoras;
    private RadioButton rbSueldoDiario;
    private RadioButton rbSueldoHoras;
    private TextView resultado;
    private Button btnCalcular1;

    private float suelDiario;
    private float valSueldoDiario;
    private int hrsTrabajadas;
    private float valHoras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_sueldo);

        sueldoDiario = (EditText) findViewById(R.id.txtSueldoDiario);
        valorSueldoDiario = (EditText) findViewById(R.id.txtValorSueldoDiario);
        horasTrabajadas = (EditText) findViewById(R.id.txtHorasTrabajadas); // Horas Extras
        precioHoras = (EditText) findViewById(R.id.txtPrecioHoras);
        rbSueldoDiario = (RadioButton) findViewById(R.id.rbSueldoDiario);
        rbSueldoHoras = (RadioButton) findViewById(R.id.rbSueldoHoras);
        resultado = (TextView) findViewById(R.id.txtResultado);
        btnCalcular1 = (Button) findViewById(R.id.btnCalcSueldo);


        btnCalcular1.setOnClickListener(new View.onClickListener() { 
            @Override
            public void onClick(View view) {
                suelDiario = Float.parseFloat(sueldoDiario.getText().toString());
                valSueldoDiario = Float.parseFloat(valorSueldoDiario.getText().toString());
                hrsTrabajadas = Integer.parseInt(horasTrabajadas.getText().toString());
                valHoras = Float.parseFloat(precioHoras.getText().toString());

                if (rbSueldoDiario.isChecked()) {
                    resultado.setText(String.valueOf((suelDiario * valSueldoDiario)));

                } else if (rbSueldoHoras.isChecked()) {
                    resultado.setText(String.valueOf((hrsTrabajadas * valHoras)));
                }
            }
        });

    }

    // Boton Inicio
    public void IrHome(View view) {
        Intent home = new Intent(CalculoSueldo.this, MainActivity.class);
        startActivity(home);
    }
}