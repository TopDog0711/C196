package com.horn.michael.c196;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.horn.michael.c196.UnitTests.DBTests;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DBTests tests = new DBTests();
        tests.validTerms(getApplicationContext());




        setContentView(R.layout.activity_main);
    }
}
