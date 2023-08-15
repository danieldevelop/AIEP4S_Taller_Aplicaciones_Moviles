package com.example.practicadatabase2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import cl.database.bean.BNArticulo;
import cl.database.function.Validar;
import cl.database.sql.AdminSQLiteOpenHelper;
import cl.database.sql.Consulta;

public class MainActivity extends AppCompatActivity {

    // Componentes layout y otros
    private Context principal = this;
    private EditText et_id;
    private EditText et_nombre;
    private EditText et_detalle;
    // Variables globales del sistema
    private boolean estado;
    private boolean verDato;
    private long resultadoConsulta;

    BNArticulo articulo = new BNArticulo();
    Validar validar = new Validar();
    Consulta consulta = new Consulta();

    private void LimpiarCampo() {
        et_id.setText(0+"");
        et_nombre.setText("");
        et_detalle.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = (EditText) findViewById(R.id.txtCodigo);
        et_nombre = (EditText) findViewById(R.id.txtNombre);
        et_detalle = (EditText) findViewById(R.id.txtDescripcion);
    }



    public void guardarRegistro(View v) 
    {
        articulo.setId(Integer.parseInt(et_id.getText().toString()));
        articulo.setNombre(et_nombre.getText().toString());
        articulo.setDetalle(et_detalle.getText().toString());

        try {
            estado = validar.validarCampoVacio(articulo.getId(), articulo.getNombre(), articulo.getDetalle());
            if (!estado) {
                resultadoConsulta = consulta.insertarRegistro(principal, articulo.getId(), articulo.getNombre(), articulo.getDetalle());

                if (resultadoConsulta != -1) {
                    Toast.makeText(this, "Los datos se guardaron", Toast.LENGTH_LONG).show();
                    consulta.objDB.close(); // Cerramos la conexion a la base de datos
                    LimpiarCampo();
                } else {
                    Toast.makeText(this, "Error en guardar los datos", Toast.LENGTH_LONG).show();
                    consulta.objDB.close(); 
                }
            } else {
                Toast.makeText(principal, "Todos los campos son obligatorios", Toast.LENGTH_LONG).show();
            }

        } catch (NullPointerException ex) {
            Log.e("E:DG-01", ex.getMessage());
        } catch (Exception ex) {
            Log.e("E:DG-02", ex.getMessage());
        }
    }

}