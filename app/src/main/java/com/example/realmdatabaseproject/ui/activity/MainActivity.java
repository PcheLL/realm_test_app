package com.example.realmdatabaseproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.realmdatabaseproject.R;
import com.example.realmdatabaseproject.data.database.model.UserNote;
import com.example.realmdatabaseproject.ui.adapter.RecyclerViewAdapter;
import com.example.realmdatabaseproject.ui.mvpviews.MainMvpPresenter;
import com.example.realmdatabaseproject.ui.mvpviews.MainMvpView;
import com.example.realmdatabaseproject.ui.presenter.MainPresenter;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class    MainActivity extends AppCompatActivity implements MainMvpView {
    private MainMvpPresenter mainMvpPresenter;
    private RecyclerViewAdapter adapter;
    private Realm realm;
    @BindView(R.id.editText) EditText editText;
    @BindView(R.id.button) Button button;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initRealmConfiguration();
        mainMvpPresenter = new MainPresenter(this);
    }

    private void initRealmConfiguration() {
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        updateList(realmConfiguration);
    }

    private void updateList(RealmConfiguration realmConfiguration) {
        realm = Realm.getInstance(realmConfiguration);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new RecyclerViewAdapter(realm.where(UserNote.class).findAll()));
    }

    @OnClick(R.id.button)
    void onButtonClick(View v){
        String text = String.valueOf(editText.getText());
        if (text.equals("")){
            errorInputText();
        }
        else{
            mainMvpPresenter.addNewElement(text);
            editText.setText("");
        }
    }

    @Override
    public void updateUI() {

    }

    @Override
    public void errorInputText() {
        Toast.makeText(this, "Введите корректные данные", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}
