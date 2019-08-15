package com.pandapol.kontakteman.presenter;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.pandapol.kontakteman.preference.UserPreference;
import com.pandapol.kontakteman.view.MainView;

/**
 Sabtu, 3 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public class MainPresenter {

    private MainView view;
    private UserPreference prefs;

    public MainPresenter(Context context, MainView view) {
        this.view = view;
        prefs = new UserPreference(context);
    }

    public void isLogin() {
        if (prefs.userLogin() == null) view.toLogin();
    }

    public void addView() {
        view.addView();
    }

    public void changeView(Fragment fragment) {
        view.showView(fragment);
    }
}
