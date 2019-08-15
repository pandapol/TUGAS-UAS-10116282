package com.pandapol.kontakteman.view;

import com.pandapol.kontakteman.data.model.User;

/**
 Minggu, 4 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public interface HomeView {
    void showUser(User user);
    void onSignOut();
}
