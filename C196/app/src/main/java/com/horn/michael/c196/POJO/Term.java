package com.horn.michael.c196.POJO;
import android.content.ContentValues;

import com.horn.michael.c196.SQL.*;
import com.horn.michael.c196.interfaces.iStorable;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by Mike on 4/14/2017.
 */

public class Term implements iStorable {
    private String title;
    private Date startDate;
    private Date endDate;

    public Term(String title, Date startDate, Date endDate) {
        this.title = title;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Term() {
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

    @Override
    public String getTableName() {
        return this.getClass().getSimpleName();

    }

    @Override
    public String createTable() {
        Field[] fields = this.getClass().getDeclaredFields();
        String retVal = "CREATE TABLE " + getTableName() + " (";
        retVal +=  _ID + " INTEGER PRIMARY KEY";

        for(Field f: fields)
        {
            if(f.getName().startsWith("$")) continue;
            if(f.getName() == "serialVersionUID") continue;

            retVal += ", " +  f.getName() + " " +  DbHelper.typeToDBType(f.getGenericType().toString() );
        }

        retVal += ")";

        return retVal;
    }

    @Override
    public String deleteTable() {
        return "DROP TABLE IF EXISTS " + getTableName();
    }


    @Override
    public ContentValues getValues() {
        ContentValues values = new ContentValues();

        values.put("title", this.getTitle());
        values.put("startDate", this.getStartDate().toString());
        values.put("endDate", this.getEndDate().toString());

        return values;
    }
}
