package com.example.omer.todolist.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.omer.todolist.MainActivity;
import com.example.omer.todolist.R;
import com.example.omer.todolist.model.DataSource;
import com.example.omer.todolist.adaptor.Note;
import android.widget.Toast;

import java.io.File;

/**
 * Created by OMER on 26-Mar-18.
 */

public class AddNote extends Fragment{


    Button save;
    EditText title;
    EditText description;

    DataSource dataSource;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.add_note, container, false);



        title = (EditText) view.findViewById(R.id.edit_title);
        description = (EditText) view.findViewById(R.id.edit_desc);
        save = (Button) view.findViewById(R.id.btn_save);

        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                dataSource= new DataSource(view.getContext());
                dataSource.ac();

                String sTitle = title.getText().toString();
                String sDecs = description.getText().toString();

                Note note = new Note(sTitle, sDecs, "0");

                dataSource.notOlustur(note);

                Toast.makeText(view.getContext(), "Data is recorded successfully", Toast.LENGTH_LONG).show();
                Intent one = new Intent(view.getContext(), MainActivity.class);
                startActivity(one);


            }
        });


        onDestroy();
        return view;

    }






}
