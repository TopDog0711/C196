package com.horn.michael.c196.SQL;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.horn.michael.c196.POJO.*;
import com.horn.michael.c196.interfaces.iStorable;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Mike on 4/14/2017.
 */

public  class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 8;
    public static final String DATABASE_NAME = "WGUHelper.db";

    public DbHelper(Context context) {

        super(context , DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       Term.INSTANCE.createTable(db);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Term.INSTANCE.deleteTable(db);

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
        try{
            long rowID = db.insert(o.getTableName(), null, getValues(o));
        }catch(Exception ex)
        {

        }

    }



    public static ContentValues getValues(final Object obj) throws Exception {
        ContentValues values = new ContentValues();

        Field[] fields = obj.getClass().getDeclaredFields();


        for(Field f: fields)
        {
            if(f.getName().startsWith("$")) continue;
            if(f.getName() == "serialVersionUID") continue;
            f.setAccessible(true);

            Class<?> fieldType = f.getType();
            if(String.class.isAssignableFrom(fieldType)) values.put(f.getName(), (String) f.get(obj));
            else if(Integer.class.isAssignableFrom(fieldType)) values.put(f.getName(), (Integer) f.get(obj));
            else if(Date.class.isAssignableFrom(fieldType)) {
                values.put(f.getName(), ((Date) f.get(obj)).toString());
            }

        }



        return values;
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
