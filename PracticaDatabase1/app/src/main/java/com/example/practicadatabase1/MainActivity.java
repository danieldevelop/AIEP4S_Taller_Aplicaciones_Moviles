package com.example.practicadatabase1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
// import android.database.SQLException;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et_id;
    private EditText et_nombre;
    private EditText et_descripcion;

    private String code;
    private String name;
    private String description;
    private long estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = (EditText) findViewById(R.id.txtId);
        et_nombre = (EditText) findViewById(R.id.txtNombre);
        et_descripcion = (EditText) findViewById(R.id.txtDescripcion);
    }


    public void Guardar(View v) {
        try {
            // El campo compras hace referencia logica de la base de datos
            AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(this, "compras.db", null, 1);

            SQLiteDatabase objDB = adm.getWritableDatabase();
            code = et_id.getText().toString();
            name = et_nombre.getText().toString();
            description = et_descripcion.getText().toString();

            // if (!(code.isEmpty() || name.isEmpty() || description.isEmpty())) {
            if (!code.isEmpty() && !name.isEmpty() && !description.isEmpty()) {

                ContentValues registro = new ContentValues();
                registro.put("id", code);
                registro.put("nombre", name);
                registro.put("descripcion", description);

                estado = objDB.insert("articulo", null, registro);
                if (estado != -1 ){
                    Toast.makeText(this, "LOS DATOAS SE GUARDARON EXITOSAMENTE", Toast.LENGTH_LONG).show();
                    objDB.close();

                    // Limpiamos los campos
                    et_id.setText("");
                    et_nombre.setText("");
                    et_descripcion.setText("");
                } else {
                    Toast.makeText(this, "ERROR, LOS DATOS NO SE GUARDARON", Toast.LENGTH_LONG).show();
                    objDB.close();
                }

            } else {
                Toast.makeText(this, "!Todos los campos son obligatorios!!", Toast.LENGTH_LONG).show();
            }

        } catch (NullPointerException ex) {
            Log.e("E:DG-01", ex.getMessage());
        } catch (SQLiteConstraintException ex) {
            Log.e("E:DG-02", "EL CODIGO YA EXISTE EN LA BASE DE DATOS");
        } catch (Exception ex) {
            Log.e("E:DG-03", ex.getMessage());
        }
    }


    public void Buscar(View v) {
        try {
            AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(this, "compras.db", null, 1);

            SQLiteDatabase objDB = adm.getWritableDatabase();
            code = et_id.getText().toString();

            if (!code.isEmpty()) {
                Cursor fila = objDB.rawQuery("SELECT u.nombre, u.descripcion FROM articulo u WHERE id = " + code, null);

                if (fila.moveToFirst()) {
                    // Muestra segun la orden de la consulta SQL
                    et_nombre.setText(fila.getString(0));
                    et_descripcion.setText(fila.getString(1));
                    objDB.close();

                } else {
                    Toast.makeText(this, "El codigo " + code + " no existe", Toast.LENGTH_LONG).show();
                    objDB.close();
                }

            } else {
                Toast.makeText(this, "El campo codigo es obligatorio!!", Toast.LENGTH_LONG).show();
            }

        } catch (Exception ex) {
            Log.e("E:DG-04", ex.getMessage());
        }
    }


    public void Actualizar(View v) {
        try {
            AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(this, "compras.db", null, 1);

            SQLiteDatabase objDB = adm.getWritableDatabase();
            code = et_id.getText().toString();
            name = et_nombre.getText().toString();
            description = et_descripcion.getText().toString();

            if (!code.isEmpty()) {
                ContentValues update = new ContentValues();
                update.put("id", code);
                update.put("nombre", name);
                update.put("descripcion", description);

                estado = objDB.update("articulo", null, update, "id = " + code, null);
                if (estado == 1 ){
                    Toast.makeText(this, "LOS DATOAS SE ACTUALIZARON EXITOSAMENTE", Toast.LENGTH_LONG).show();
                    objDB.close();

                    // Limpiamos los campos
                    et_nombre.setText(""); or

                    et_descripcion.setText("");
                } else {
                    Toast.makeText(this, "ERROR, LOS DATOS NO SE ACTUALIZARON", Toast.LENGTH_LONG).show();
                    objDB.close();
                }

            } else {
                Toast.makeText(this, "!Necesito que ingrese el codigo para actualizar los datos!!", Toast.LENGTH_LONG).show();
            }


        } catch (Exception ex) {
            Log.e("E:DG-05", ex.getMessage());
        }
    }


    public void Eliminar(View v) {
        try {
            AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(this, "compras.db", null, 1);

            SQLiteDatabase objDB = adm.getWritableDatabase();
            code = et_id.getText().toString();

            if (!code.isEmpty()) {
                estado = objDB.delete("articulo", "id = " + code, null);

                if (estado == 1) {
                    Toast.makeText(this, "LOS DATOAS SE ELIMINARON EXITOSAMENTE", Toast.LENGTH_LONG).show();
                    objDB.close();

                    // Limpiamos los campos
                    et_nombre.setText("");
                    et_descripcion.setText("");
                } else {
                    Toast.makeText(this, "ERROR, LOS DATOS NO SE ELIMINARON", Toast.LENGTH_LONG).show();
                    objDB.close();
                }

            } else {
                Toast.makeText(this, "Necesito el Codigo", Toast.LENGTH_LONG).show();
            }

        } catch (Exception ex) {
            Log.e("E:DG-06", ex.getMessage());
        }
    }
}