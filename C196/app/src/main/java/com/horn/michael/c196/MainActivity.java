package com.horn.michael.c196;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.horn.michael.c196.POJO.Term;
import com.horn.michael.c196.SQL.DbHelper;

import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private Date getAddMonths(int toAdd)
    {
        Date current = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+toAdd));
        return cal.getTime();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        DbHelper helper = new DbHelper(getApplicationContext());

        Term t = new Term( "Term 1", new Date(), getAddMonths(6));
        helper.insertObject(t);


        setContentView(R.layout.activity_main);
    }
}
