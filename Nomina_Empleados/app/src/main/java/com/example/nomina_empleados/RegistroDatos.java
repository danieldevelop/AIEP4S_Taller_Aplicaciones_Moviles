package com.example.nomina_empleados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroDatos extends AppCompatActivity {

    private EditText Username;
    private EditText LastName;
    private EditText miEmail;
    private EditText miEdad;
    private EditText miPhone;

    private String nombre;
    private String apellido;
    private String correo;
    private String edad;
    private String telefono;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_datos);

        Username = (EditText) fintViewById(R.id.txtNombre);
        LastName = (EditText) fintViewById(R.id.txtApellido);
        miEmail = (EditText) fintViewById(R.id.txtCorreo);
        miEdad = (EditText) fintViewById(R.id.txtEdad);
        miPhone = (EditText) fintViewById(R.id.txtTelefono);
    }

    // Boton Inicio
    public void IrHome(View view) {
        Intent home = new Intent(RegistroDatos.this, MainActivity.class);
        startActivity(home);
    }

    // Metodo para el boton registrar
    public void RegistroDatosPersonales(View view) {
        Toast.makeText(this, "Registro de Datos Personales Exitoso", Toast.LENGTH_LONG).show();
    }

}