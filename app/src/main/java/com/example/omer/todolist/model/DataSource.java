package com.example.omer.todolist.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.omer.todolist.adaptor.Note;

import java.util.ArrayList;

/**
 * Created by OMER on 27-Mar-18.
 */

public class DataSource {

    SQLiteDatabase db;
    Database benimdb;

    private static final String DATABASE_TABLE ="todotable";
    public static final String KEY_ROWID = "id";

    public DataSource(Context context) {

        benimdb = new Database(context);

    }

    public void ac(){
        db =benimdb.getWritableDatabase();


    }

    public void kapa(){
        benimdb.close();

    }

    public void notOlustur(Note note){

        ContentValues contentValues = new ContentValues();
        contentValues.put("title", note.getTitle());
        contentValues.put("description", note.getDescription());

        db.insert(DATABASE_TABLE, null, contentValues );
    }


    public void notSil(int id){

        db.delete(DATABASE_TABLE, "id" + "=" + id, null);


    }

    public void notGuncelle(Note note){

        String strFilter = "id=" + note.getId();
        ContentValues args = new ContentValues();
        args.put("id", note.getId());
        args.put("title", note.getTitle());
        args.put("description", note.getDescription());
        db.update(DATABASE_TABLE, args, strFilter, null);
    }

    //veritabanından notları okuyup array list yapısına atıyor. daha sonra lisview de kullanılacak
    public ArrayList<Note> listele(){
        String kolonlar[]={"id", "title", "description"};
        Cursor c = db.query("TODOTABLE", kolonlar, null, null, null, null, null);
        c.moveToFirst();

        ArrayList<Note> wordList = new ArrayList<>();
        while (!c.isAfterLast()){
            String id = c.getString(0);
            String title = c.getString(1);
            String desc = c.getString(2);

            Note word = new Note(title, desc, id);
            wordList.add(word);
            c.moveToNext();

        }
        c.close();
        return wordList;
    }
}
