package com.ahsan.myislamicseminary;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper{

    public DBHelper(Context context) {
        super(context, "UserDb", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase Db) {
        Db.execSQL("create Table UserDetails(name TEXT primary key, age TEXT, classs TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase Db, int i, int j) {
        Db.execSQL("drop Table if exists UserDetails");
    }

    public boolean insertUserData(String name, String age, String cl){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put("name",name);
        cv.put("age",age);
        cv.put("classs",cl);

        long result=db.insert("UserDetails",null,cv);
        if(result==-1){
            return false;
        }
        else{
            return true;
        }
    }

    public Cursor getData(){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor cr= db.rawQuery("select * from UserDetails",null);
        return cr;
    }

    public Cursor getSearchedData(String nm){
        SQLiteDatabase db=this.getWritableDatabase();
        String n=nm;
        Cursor cr= db.rawQuery("select * from UserDetails where name like "+n+"",null);
        return cr;
    }
}
