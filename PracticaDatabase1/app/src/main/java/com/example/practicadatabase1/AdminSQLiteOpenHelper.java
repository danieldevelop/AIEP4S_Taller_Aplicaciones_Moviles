package com.example.practicadatabase1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {
    // Contructor
    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    // Base de datos de conexion en mi android studio
    public void onCreate(SQLiteDatabase DB_PRUEBA) {
        DB_PRUEBA.execSQL("CREATE TABLE IF NOT EXISTS articulo(id INT PRIMARY KEY, nombre VARCHAR(45), descripcion VARCHAR(45))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}