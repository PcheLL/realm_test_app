package com.example.realmdatabaseproject.ui.presenter;

import com.example.realmdatabaseproject.data.MainRepository;
import com.example.realmdatabaseproject.ui.mvpviews.MainMvpPresenter;
import com.example.realmdatabaseproject.ui.mvpviews.MainMvpView;
import com.example.realmdatabaseproject.ui.activity.MainActivity;

public class MainPresenter implements MainMvpPresenter {
    private MainMvpView mainMvpView;
    private MainRepository mainRepository;

    public MainPresenter(MainActivity mainActivity) {
        mainMvpView = mainActivity;
        mainRepository = new MainRepository();
    }

    @Override
    public void addNewItemToDatabase(String text) {
        mainRepository.addNewItemToDatabase(text);
    }

    @Override
    public void removeItemFromDatabase(String id){
        mainRepository.removeItemFromDatabase(id);
    }

}
