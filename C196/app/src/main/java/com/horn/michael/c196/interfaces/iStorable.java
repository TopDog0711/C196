package com.horn.michael.c196.interfaces;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import com.horn.michael.c196.SQL.DbHelper;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Mike on 4/14/2017.
 */

public abstract class iStorable {

    protected long ID;



    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }



    public abstract String getTableName();
    public abstract String createTableFields();


    public  String createTableScript()
    {

        String retVal = "CREATE TABLE " + getTableName() + " (";
        retVal +=  "ID INTEGER PRIMARY KEY";

        retVal += createTableFields();

        retVal += ")";

        return retVal;
    }

    public  String deleteTableScript()
    {
        return "DROP TABLE IF EXISTS " + getTableName();
    }

    public  void deleteTable(SQLiteDatabase db)
    {
        String script = deleteTableScript();
        db.execSQL( script);
    }

    public  void createTable(SQLiteDatabase db)
    {

        String script = createTableScript();

        db.execSQL( script);
    }


    public  List<iStorable> readList(SQLiteDatabase db)
    {
        return null;
    }

    public  iStorable read(int id , SQLiteDatabase db)
    {
       return null;
    }

    public  void delete(long id, SQLiteDatabase db)
    {
        String filter = "ID=" + id;
        db.delete(getTableName(), filter, null);
    }

    public long insert(iStorable obj, SQLiteDatabase db)
    {
        if(obj.ID == -1)// new
        {

            obj.ID = db.insert(obj.getTableName(), null, obj.getValues() );


        }else {
            obj.update(obj, db);
        }

        return obj.ID;
    }

    public  long update(iStorable obj, SQLiteDatabase db)
    {
        String filter = "ID=" + obj.ID;
        db.update(getTableName(), obj.getValues(), filter, null);
        return obj.ID;
    }

    public  String[] getFields()
    {
        return null;
    }

    public  iStorable fromCursor(Cursor c)
    {
        return null;
    }

    public ContentValues getValues()
    {
        return null;
    }

}
