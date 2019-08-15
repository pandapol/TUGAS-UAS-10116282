package com.pandapol.kontakteman.presenter;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.EditText;

import com.pandapol.kontakteman.data.model.User;
import com.pandapol.kontakteman.data.repo.UserRepository;
import com.pandapol.kontakteman.preference.UserPreference;
import com.pandapol.kontakteman.view.LoginView;

/**
 Sabtu, 3 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public class LoginPresenter {

    private LoginView view;
    private UserRepository repo;
    private UserPreference prefs;

    public LoginPresenter(Context context, LoginView view) {
        this.view = view;
        repo = new UserRepository(context);
        prefs = new UserPreference(context);
    }

    public void login(LifecycleOwner owner, final String username, final String pass) {
        repo.selectUser(username, pass).observe(owner, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                if (user != null) {
                    prefs.setIsLogin(username, pass);
                    view.loginSuccess();
                } else view.loginFail();
            }
        });
    }

    public void setError(EditText editText) {
        editText.requestFocus();
        editText.setError("Isi Box Kosong !");
    }

}
