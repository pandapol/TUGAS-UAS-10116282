package com.pandapol.kontakteman.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pandapol.kontakteman.R;
import com.pandapol.kontakteman.data.model.Friends;
import com.pandapol.kontakteman.presenter.AddEditFriendsPresenter;
import com.pandapol.kontakteman.view.AddEditFriendsView;

import java.util.Objects;

/**
 Selasa, 6 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public class AddEditEditFriendsActivity extends AppCompatActivity implements AddEditFriendsView {

    Toolbar toolbar;
    TextView tvTitle;
    EditText etName, etNIM, etClass, etPhone, etEmail, etIG;
    AddEditFriendsPresenter presenter;
    int type;

    @Override
    public void showData() {
        tvTitle.setText(getResources().getString(R.string.edit_friend));

        Friends f = getIntent().getParcelableExtra("friend");
        etName.setText(f.getName());
        etNIM.setText(f.getNim());
        etClass.setText(f.getClass_());
        etPhone.setText(f.getPhone());
        etEmail.setText(f.getEmail());
        etIG.setText(f.getIg());
    }

    @Override
    public void onFriendAdded() {
        Toast.makeText(this, "Friend Added", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onFriendUpdated(Friends friend) {
        Intent i = new Intent();
        i.putExtra("newData", friend);
        setResult(Activity.RESULT_OK, i);

        Toast.makeText(this, "Friend Updated", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void showError(EditText et) {
        et.requestFocus();
        et.setError("Isi Box Kosong !");
    }

    @Override
    public void showFailed(String msg) {
        Snackbar.make(etNIM, msg, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_friends);
        initView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        type = getIntent().getIntExtra("type", 0);

        presenter = new AddEditFriendsPresenter(this, this);
        presenter.isEdit(type);
    }

    private void initView() {
        toolbar = findViewById(R.id.toolbarAddFriends);
        tvTitle = findViewById(R.id.tvTitle);
        etName = findViewById(R.id.etName);
        etNIM = findViewById(R.id.etNIM);
        etClass = findViewById(R.id.etClass);
        etPhone = findViewById(R.id.etPhone);
        etEmail = findViewById(R.id.etEmail);
        etIG = findViewById(R.id.etIG);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_done, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

            case R.id.nav_done:
                Friends friend = new Friends(
                        etName.getText().toString(),
                        etNIM.getText().toString(),
                        etClass.getText().toString(),
                        etPhone.getText().toString(),
                        etEmail.getText().toString(),
                        etIG.getText().toString()
                );

                if (!etName.getText().toString().isEmpty()) {
                    if (!etNIM.getText().toString().isEmpty()) {
                        if (!etClass.getText().toString().isEmpty()) {

                            if (type == 0) presenter.addFriend(friend);
                            else presenter.updateFriend(friend);

                        } else presenter.setError(etClass);
                    } else presenter.setError(etNIM);
                } else presenter.setError(etName);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

}
