package com.example.brian.tarea_db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String NOMBRE_DATABASE = "Estudiantes.db";
    private static final String NOMBRE_TABLA = "Studen_table";
    private static final String Col_1 = "ID";
    private static final String Col_2 = "Nombre";
    private static final String Col_3 = "Apellido";
    private static final String Col_4 = "Telefono";

    public DataBaseHelper(Context context) {
        super(context, NOMBRE_DATABASE, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + NOMBRE_TABLA + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NOMBRE TEXT,APELLIDO TEXT,TELEFONO TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRE_TABLA);
    }

    public boolean insertarDatos(String nombre, String apellido, String telefono){
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2, nombre);
        contentValues.put(Col_3, apellido);
        contentValues.put(Col_4, telefono);
        long result = db.insert(NOMBRE_TABLA, null, contentValues);
        db.close();
            if (result == -1){
                return true;
            }else {
                return false;
            }
    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("Select * from " + NOMBRE_TABLA, null);
        return res;
    }

    public boolean updateData(String id, String nombre, String apellido, String telefono){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col_2,nombre);
        contentValues.put(Col_3,apellido);
        contentValues.put(Col_3,telefono);
        int result = db.update(NOMBRE_TABLA, contentValues, "ID = ?", new String[]{id});
        if (result > 0){
            return true;
        }else {
            return false;
        }
    }

    public Integer deleteData (String id){
        SQLiteDatabase db = this.getWritableDatabase();
        int i = db.delete(NOMBRE_TABLA, "ID=?",new String[]{id});
        return i;
    }

}
