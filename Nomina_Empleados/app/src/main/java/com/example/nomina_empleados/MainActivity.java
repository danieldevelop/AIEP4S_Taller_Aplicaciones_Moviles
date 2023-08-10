package com.example.nomina_empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Metodo para ir a la interfaz de Registo de Dtos Personales
    public void RegistroDatosPersonales(View view) {
        Intent registro = new Intent(this, RegistroDatos.class);
        startActivity(registro);
    }

    public void IrCalcularSalario(View view) {
        Intent salario = new Intent(this, CalculoSueldo.class);
        startActivity(salario);
    }

    public void IrCalcularDeducciones(View view) {
        Intent deducciones = new Intent(this, CalculoDeducciones.class);
        startActivity(deducciones);
    }
}