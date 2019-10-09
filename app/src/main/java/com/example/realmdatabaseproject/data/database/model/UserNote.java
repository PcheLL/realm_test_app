package com.example.realmdatabaseproject.data.database.model;


import io.realm.RealmObject;

public class UserNote extends RealmObject {
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
