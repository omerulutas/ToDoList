package com.example.omer.todolist;

import android.widget.Toast;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import com.example.omer.todolist.model.DataSource;
import com.example.omer.todolist.adaptor.Note;

public class UpdateTask extends AppCompatActivity {


    Button save;
    Button delete;
    EditText title;
    EditText description;

    DataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_task);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        title = (EditText) findViewById(R.id.edit_title);
        description = (EditText) findViewById(R.id.edit_desc);
        save = (Button) findViewById(R.id.btn_save);
        delete = (Button) findViewById(R.id.btn_delete);

        Bundle bundle = getIntent().getExtras();
        final String stitle = bundle.getString("title");
        final String sDescription = bundle.getString("description");
        final String sID= bundle.getString("id");
        final int id = Integer.parseInt(sID);
        title.setText(stitle);

        description.setText(sDescription);


        dataSource= new DataSource(this);
        dataSource.ac();


        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Note note =new Note(title.getText().toString(), description.getText().toString(), sID);


                dataSource.notGuncelle(note);
                Toast.makeText(view.getContext(), title.getText().toString()+"  is recorded successfully", Toast.LENGTH_LONG).show();
                Intent one = new Intent(view.getContext(), MainActivity.class);
                startActivity(one);

                finish();

            }
        });





        delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {


                dataSource.notSil( id);

                Toast.makeText(view.getContext(), "Data is delete successfully", Toast.LENGTH_LONG).show();
                Intent one = new Intent(view.getContext(), MainActivity.class);
                startActivity(one);
                finish();

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }




}








