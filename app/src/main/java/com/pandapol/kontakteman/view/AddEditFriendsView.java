package com.pandapol.kontakteman.view;

import android.widget.EditText;

import com.pandapol.kontakteman.data.model.Friends;

/**
 Minggu, 4 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public interface AddEditFriendsView {
    void showData();
    void onFriendAdded();
    void onFriendUpdated(Friends friend);
    void showError(EditText et);
    void showFailed(String msg);
}
