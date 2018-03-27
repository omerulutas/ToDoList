package com.example.omer.todolist.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.omer.todolist.R;

/**
 * Created by OMER on 26-Mar-18.
 */

public class Category extends Fragment {

    View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.categories, container, false);
        return view;
    }
}
