package com.example.realmdatabaseproject.data;

import com.example.realmdatabaseproject.data.database.model.UserNote;

import java.util.UUID;

import io.realm.Realm;

public class MainRepository {

    public void addNewItemToDatabase(String text) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        UserNote userNote = realm.createObject(UserNote.class, UUID.randomUUID().toString());
        userNote.setText(text);
        realm.commitTransaction();
    }


    public void removeItemFromDatabase(String key) {
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        realm.where(UserNote.class).equalTo("key",key).findFirst().deleteFromRealm();
        realm.commitTransaction();
    }
}
