package com.example.omer.todolist.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by OMER on 27-Mar-18.
 */

public class Database extends SQLiteOpenHelper {



    public Database(Context context) {

        super(context, "tododatabase", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table todotable (id integer primary key autoincrement," +
                " title text, description text)";

        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String sql = "drop table if exists tododatabase ";
        db.execSQL(sql);
    }
}

