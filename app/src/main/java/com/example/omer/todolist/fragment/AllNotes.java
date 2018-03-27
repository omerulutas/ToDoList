package com.example.omer.todolist.fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omer.todolist.MainActivity;
import com.example.omer.todolist.UpdateTask;
import com.example.omer.todolist.model.DataSource;

import com.example.omer.todolist.R;
import com.example.omer.todolist.adaptor.Note;
import com.example.omer.todolist.adaptor.NoteAdapter;

import java.util.ArrayList;

/**
 * Created by OMER on 27-Mar-18.
 */

public class AllNotes extends Fragment {

    private ArrayList<Note> notes;
    private ListView listView;
    private NoteAdapter adapter;


    private static final String TAG_PID = "pid";

    DataSource dataSource;

    FragmentManager fragmentManager;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.all_notes, container, false);

        this.listView = (ListView) view.findViewById(R.id.tv_notes);
        notes = new ArrayList<Note>();

        dataSource= new DataSource(view.getContext());
        dataSource.ac();

        notes= dataSource.listele();
        adapter = new NoteAdapter(view.getContext(), notes);
        listView.setAdapter(adapter);

        //Listview elemanlarından birine basınca yeni intent ile görüntleyebilir, düzenleyebilir, silebilirsiniz
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                String title = ((TextView) view.findViewById(R.id.note_title)).getText().toString();
                String description = ((TextView) view.findViewById(R.id.note_description)).getText().toString();
                String noteID= ((TextView) view.findViewById(R.id.note_id)).getText().toString();

                Intent one = new Intent(view.getContext(), UpdateTask.class);
                one.putExtra("title", title);
                one.putExtra("description", description);
                one.putExtra("id", noteID);
                startActivity(one);


            }
        });


        dataSource.kapa();

        onDestroy();
        return view;
    }



}
