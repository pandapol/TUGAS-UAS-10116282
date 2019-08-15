package com.pandapol.kontakteman.presenter;

import com.pandapol.kontakteman.view.AboutView;

/**
 Sabtu, 3 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public class AboutPresenter {

    private AboutView view;

    public AboutPresenter(AboutView view) {
        this.view = view;
    }

    public void selectionView(int tab) {
        if (tab == 0) {
            view.showApp();
        } else {
            view.showCreator();
        }
    }
}
