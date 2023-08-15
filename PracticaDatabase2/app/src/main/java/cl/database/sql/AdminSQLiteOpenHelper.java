package cl.database.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    private String query;

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase DB_PRUEBA) {
        query ="CREATE TABLE IF NOT EXISTS articulo(";
            query+="id INT PRIMARY KEY, ";
            query+="nombre VARCHAR(45), ";
            query+="detalle VARCHAR(45)";
        query+=")";

        DB_PRUEBA.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}