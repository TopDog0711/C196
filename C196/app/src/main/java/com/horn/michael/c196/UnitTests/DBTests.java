package com.horn.michael.c196.UnitTests;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.horn.michael.c196.POJO.Term;
import com.horn.michael.c196.SQL.DbHelper;
import com.horn.michael.c196.interfaces.iStorable;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Mike on 4/15/2017.
 */



public class DBTests {

    private Date getAddMonths(int toAdd)
    {
        Date current = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(current);
        cal.set(Calendar.MONTH, (cal.get(Calendar.MONTH)+toAdd));
        return cal.getTime();
    }

    public boolean validTerms(Context inContext)
    {
        DbHelper helper = new DbHelper(inContext);
        SQLiteDatabase db = helper.getWritableDatabase();

        Term.INSTANCE.deleteTable(db);
        Term.INSTANCE.createTable(db);





        Term t1 = new Term( "Term 1", new Date(), getAddMonths(6));
        Term t2 = new Term( "Term 2", new Date(), getAddMonths(6));
        Term t3 = new Term( "Term 3", new Date(), getAddMonths(6));
        Term t4 = new Term( "Term 4", new Date(), getAddMonths(6));
        Term.INSTANCE.insert(t1, db);
        Term.INSTANCE.insert(t2, db);
        Term.INSTANCE.insert(t3, db);
        Term.INSTANCE.insert(t4, db);


        List<iStorable> terms = Term.INSTANCE.readList(db);

        Term updatedterm = (Term)terms.get(1);
        if(updatedterm != null) {
            updatedterm.setTitle("UPDATED");
            Term.INSTANCE.update(updatedterm, db);
        }

        terms = Term.INSTANCE.readList(db);

        Term.INSTANCE.delete(updatedterm.getID(), db);
        terms = Term.INSTANCE.readList(db);

        return true;
    }


}
