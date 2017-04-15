package com.horn.michael.c196.POJO;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.horn.michael.c196.SQL.*;
import com.horn.michael.c196.interfaces.iStorable;

import java.lang.reflect.Field;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mike on 4/14/2017.
 */

public class Term extends iStorable {

    private String title;
    private Date startDate;
    private Date endDate;

    public static final Term INSTANCE = new Term();

    public Term(String title, Date startDate, Date endDate) {
        this();
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Term() {
        this.ID = -1;

    }

    @Override
    public  String getTableName()
    {
        return "Term";
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }


    public  String createTableFields() {


        String retVal = "";


        retVal += " , title TEXT ";
        retVal += " , startDate DATE ";
        retVal += " , endDate DATE ";



        return retVal;
    }

    public  List<iStorable> readList(SQLiteDatabase db)
    {
        Term t = new Term();
        List<iStorable> terms = new ArrayList();


        Cursor cursor = db.query(
                t.getTableName(),                     // The table to query
                t.getFields(),                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        while(cursor.moveToNext())
        {
            terms.add( fromCursor(cursor));
        }


        return terms;
    }

    public ContentValues getValues()
    {
        ContentValues values = new ContentValues();
        SimpleDateFormat df =  new SimpleDateFormat("yyyyMMddHHmmss");

        values.put("title", this.getTitle());
        values.put("startDate",  df.format(this.getStartDate()));
        values.put("endDate", df.format(this.getEndDate()));
        return values;
    }

    public  String[] getFields()
    {
        String[] fields = {
         "ID", "title", "startDate", "endDate"
        };

        return fields;
    }

    public  Term fromCursor(Cursor c)
    {
        Term t = new Term();

        try {
            t.setID( c.getLong(c.getColumnIndex("ID")));
            t.setTitle(c.getString(c.getColumnIndex("title")));
            t.setStartDate(new SimpleDateFormat("yyyyMMddHHmmss").parse(c.getString(c.getColumnIndex("startDate"))));
            t.setEndDate(new SimpleDateFormat("yyyyMMddHHmmss").parse(c.getString(c.getColumnIndex("endDate"))));
        }
        catch(ParseException ex)
        {
            return null;
        }
        return t;
    }

    public  Term read(int id , SQLiteDatabase db)
    {
        Term t = new Term();
        String whereClause = "ID= " + id;
        Cursor cursor = db.query(
                t.getTableName(),                     // The table to query
                t.getFields(),                               // The columns to return
                whereClause,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        boolean avail = cursor.moveToNext();
        if(avail) {
            t = fromCursor(cursor);
        }
        return t;
    }
}
