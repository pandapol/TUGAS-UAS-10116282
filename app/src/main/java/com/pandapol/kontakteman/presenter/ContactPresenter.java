package com.pandapol.kontakteman.presenter;

import com.pandapol.kontakteman.view.ContactView;

/**
 Sabtu, 3 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public class ContactPresenter {

    private ContactView view;

    public ContactPresenter(ContactView view) {
        this.view = view;
    }

    public void makeCall() {
        view.actionCall();
    }

    public void sendEmail() {
        view.actionEmail();
    }

    public void openInstagram() {
        view.actionInstagram();
    }

    public void openTwitter() {
        view.actionTwitter();
    }
}
