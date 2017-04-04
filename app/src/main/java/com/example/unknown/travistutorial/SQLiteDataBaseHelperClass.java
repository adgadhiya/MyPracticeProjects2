package com.example.unknown.travistutorial;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by UNKNOWN on 7/1/2016.
 */
public class SQLiteDataBaseHelperClass extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "STUDENT_TABLE";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "NAME";
    public static final String COL_3 = "SURNAME";
    public static final String COL_4 = "MARKS";



    public SQLiteDataBaseHelperClass(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,NAME TEXT,SURNAME TEXT,MARKS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String surname,String marks){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME",name);
        contentValues.put("SURNAME",surname);
        contentValues.put("MARKS",marks);
        long value = db.insert(TABLE_NAME,null,contentValues);

        return value != -1;
    }

    public Cursor viewAllData(String name){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE NAME ='" + name + "'",null);
    }

    public boolean upData(String name,String sur,String marks,String id){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("MARKS",marks);
        contentValues.put("SURNAME",sur);
       int affected =  db.update(TABLE_NAME,contentValues,"SURNAME=?",new String[] {sur});

        return affected > 0;
    }

    public boolean deleteData(String id){
        SQLiteDatabase db = getWritableDatabase();
      int deleted =  db.delete(TABLE_NAME,"ID = ?",new String[] {id});
        return deleted > 0;

    }
}
