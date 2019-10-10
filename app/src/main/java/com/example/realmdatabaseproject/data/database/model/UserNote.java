package com.example.realmdatabaseproject.data.database.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class UserNote extends RealmObject {
    @PrimaryKey
    private String  key;

    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getKey() {
        return key;
    }
}
