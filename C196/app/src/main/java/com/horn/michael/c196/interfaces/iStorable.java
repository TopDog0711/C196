package com.horn.michael.c196.interfaces;

import android.content.ContentValues;
import android.provider.BaseColumns;

/**
 * Created by Mike on 4/14/2017.
 */

public interface iStorable  extends BaseColumns {

    public abstract String getTableName();
    public  abstract String createTable();
    public abstract String deleteTable();

    public abstract ContentValues getValues();

}
