package com.example.omer.todolist.adaptor;

/**
 * Created by OMER on 27-Mar-18.
 */

public class Note {

    private String title;
    private String description;
    private String id;



    public Note(String title, String description, String id) {
        this.title = title;
        this.description = description;
        this.id = id;

    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
