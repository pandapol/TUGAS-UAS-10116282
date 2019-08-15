package com.pandapol.kontakteman.view;

import com.pandapol.kontakteman.data.model.Friends;

/**
 Minggu, 4 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public interface FriendsDetailView {
    void showDetail(Friends fr);
    void actionCall();
    void actionEmail();
    void actionInstagram();
    void onFriendDeleted();
}
