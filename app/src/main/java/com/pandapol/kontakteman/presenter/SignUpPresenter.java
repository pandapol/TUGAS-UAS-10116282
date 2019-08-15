package com.pandapol.kontakteman.presenter;

import android.content.Context;
import android.widget.EditText;

import com.pandapol.kontakteman.data.model.User;
import com.pandapol.kontakteman.data.repo.UserRepository;
import com.pandapol.kontakteman.view.SignUpView;

/**
 Minggu, 4 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public class SignUpPresenter {

    private SignUpView view;
    private UserRepository repo;

    public SignUpPresenter(Context context, SignUpView view) {
        this.view = view;
        repo = new UserRepository(context);
    }

    public void signUp(User user) {
        try {
            repo.insertUser(user);
            view.signUpSuccess();
        } catch (Exception ex) {
            view.signUpFailed();
        }
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Isi Box Kosong!");
    }

    public void setPassError(EditText editText) {
        editText.requestFocus();
        editText.setError("Password minimal 8 karekter!");
    }
}
