package cl.database.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.Array;

import cl.database.bean.BNArticulo;

public class Consulta {

    public SQLiteDatabase objDB;
    public Cursor fila;

    public long insertarRegistro(Context context, int id, String nombre, String detalle)
    {
        AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(context, "mitienda.db", null, 1);
        objDB = adm.getWritableDatabase();

        ContentValues insertar = new ContentValues();
        insertar.put("id", id);
        insertar.put("nombre", nombre);
        insertar.put("detalle", detalle);

        return objDB.insert("articulo", null, insertar);
    }

    public Boolean encontrarRegistro(Context context, int id)
    {
        AdminSQLiteOpenHelper adm = new AdminSQLiteOpenHelper(context, "mitienda.db", null, 1);
        objDB = adm.getWritableDatabase();

        fila = objDB.rawQuery("SELECT a.nombre, a.detalle FROM articulo a WHERE id = " + id, null);
        if (fila.moveToFirst()) {
            return true;
        }
        return false;
    }
}