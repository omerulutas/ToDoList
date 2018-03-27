package com.example.omer.todolist.adaptor;

/**
 * Created by OMER on 27-Mar-18.
 */

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.omer.todolist.R;

import java.util.ArrayList;


public class NoteAdapter extends ArrayAdapter<Note> {

    private final LayoutInflater inflater;
    private final Context context;
    private ViewHolder viewHolder;
    private final ArrayList<Note> notes;

    public NoteAdapter(Context context, ArrayList<Note> notes) {
        super(context, 0, notes);
        this.context = context;
        this.notes = notes;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {

        return notes.size();
    }

    @Override
    public Note getItem(int position) {

        return notes.get(position);
    }


    public long getItemId(int position) {

        return notes.get(position).hashCode();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.note, null);

            viewHolder = new ViewHolder();
            viewHolder.title = (TextView) convertView.findViewById(R.id.note_title);
            viewHolder.description = (TextView) convertView.findViewById(R.id.note_description);
            viewHolder.id = (TextView) convertView.findViewById(R.id.note_id);

            convertView.setTag(viewHolder);

        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Note word = notes.get(position);
        if(word != null){

            viewHolder.title.setText(word.getTitle());
            viewHolder.description.setText(word.getDescription());
            viewHolder.id.setText(word.getId());
        }

        return convertView;
    }


    private static class ViewHolder {

        TextView title;
        TextView description;
        TextView id;
    }
}
