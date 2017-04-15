package com.horn.michael.c196.SQL;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.horn.michael.c196.POJO.*;
import com.horn.michael.c196.interfaces.iStorable;

import java.lang.reflect.Type;


/**
 * Created by Mike on 4/14/2017.
 */

public  class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "WGUHelper.db";

    public DbHelper(Context context) {

        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL( new Term().createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL( new Term().deleteTable());

        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
    }

    public void insertObject(iStorable o)
    {
        SQLiteDatabase db = getWritableDatabase();
        long rowID = db.insert(o.getTableName(), null, o.getValues());
    }




    @NonNull
    public static String typeToDBType(String type)
    {
        if(type.toUpperCase().contains("STRING")) return "TEXT";
        if(type.toUpperCase().contains("INTEGER")) return "NUMBER";
        if(type.toUpperCase().contains("DATE")) return "DATE";

        return "";
    }

}
