package com.example.practicaagenda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_nombre, et_datos;
    private Context main = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nombre = (EditText) findViewById(R.id.txt_Nombre);
        et_datos = (EditText) findViewById(R.id.txt_Datos);
    }


    // Metodo para boton Guardar
    public void Guardar(View v) 
    {
        SharedPreferences contacto = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        SharedPreferences.Editor editContacto = contacto.edit();

        editContacto.putString(String.valueOf(et_nombre.getText().toString()), String.valueOf(et_datos.getText().toString()));
        editContacto.commit();
        finish();

        Toast.makeText(main, "El contacto ha sido guardado exitosamente!!!", Toast.LENGTH_LONG).show();
    }



    // Metodo para boton Buscar
    public void Buscar(View v) 
    {
        String nombre = et_nombre.getText().toString();

        SharedPreferences contacto = getSharedPreferences("agenda", Context.MODE_PRIVATE);
        String datos = contacto.getString(nombre, "");

        if ((datos.length() == 0)) {
            // Log.w("E-DG01:  ", "Estoy dentro de la condicional");
            Toast.makeText(main, "No existe el contacto " + nombre.toUpperCase() + " en los registros almacenados", Toast.LENGTH_LONG).show();
        } else {
            // Log.i("I-DG01: ", "Recuperando información!!");
            et_datos.setText(datos);
        }
    }
}
