package com.example.realmdatabaseproject.data;

import com.example.realmdatabaseproject.data.database.model.UserNote;

import io.realm.Realm;

public class MainRepository {

    public void addNewItemToDatabase(String text) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        UserNote userNote = realm.createObject(UserNote.class);
        userNote.setText(text);
        realm.commitTransaction();
    }


}
