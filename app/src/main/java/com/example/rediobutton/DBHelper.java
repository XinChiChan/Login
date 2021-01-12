package com.example.rediobutton;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.CharArrayBuffer;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.widget.CalendarView;


public class DBHelper  extends SQLiteOpenHelper {
    private static final String DB_Name = "Login.db";
    private static final int DB_Version = 1;

    public DBHelper(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Users(UserName TEXT PRIMARY KEY,PassWord TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Users");
    }

    public boolean insert(String UserName, String PassWord) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("UserName", UserName);
        cv.put("PassWord", PassWord);
        long result = db.insert("Users", null, cv);

        if (result == -1) {
            return false;
        } else return true;
    }

    public void UpData(String PassWord){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv  = new ContentValues();
        cv.put("PassWord",PassWord);
        db.update("Users",cv,"PassWord = ?",new String[]{PassWord});


    }

    public boolean CheckUserName(String UserName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Users where UserName = ?",new String[]{UserName});
        if(cursor.getCount()>0)
        { return true;
        } else return false;
    }

    public boolean CheckUserNamePassWord(String UserName, String PassWord){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from Users where UserName = ? and PassWord = ?",new String[]{UserName,PassWord});
        if(cursor.getCount()>0){
            return true;
        }else return false;
    }
}
