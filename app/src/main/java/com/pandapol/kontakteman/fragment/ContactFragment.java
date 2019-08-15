package com.pandapol.kontakteman.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.pandapol.kontakteman.R;
import com.pandapol.kontakteman.presenter.ContactPresenter;
import com.pandapol.kontakteman.view.ContactView;

/**
 Senin, 5 Agustus 2019
 10116282 - IF7
 Arvi Ramadhan
 */

public class ContactFragment extends Fragment implements ContactView, View.OnClickListener {

    RelativeLayout lytPhone, lytEmail, lytIG, lytTwitter;
    ContactPresenter presenter;

    public ContactFragment() {
        // Required empty public constructor
    }

    public static ContactFragment newInstance() {
        return new ContactFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        lytPhone = view.findViewById(R.id.lytPhone);
        lytEmail = view.findViewById(R.id.lytEmail);
        lytIG = view.findViewById(R.id.lytIg);
        lytTwitter = view.findViewById(R.id.lytTwitter);

        lytPhone.setOnClickListener(this);
        lytEmail.setOnClickListener(this);
        lytIG.setOnClickListener(this);
        lytTwitter.setOnClickListener(this);

        presenter = new ContactPresenter(this);

        return view;
    }

    @Override
    public void actionCall() {
        Intent i = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel","+6282215593717", null));
        startActivity(i);
    }

    @Override
    public void actionEmail() {
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:arviramadhan@email.unikom.ac.id"));
        startActivity(i);
    }

    @Override
    public void actionInstagram() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/a.pandapol/"));
        startActivity(i);
    }

    @Override
    public void actionTwitter() {
        Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/VorAforV"));
        startActivity(i);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.lytPhone:
                presenter.makeCall();
                break;
            case R.id.lytEmail:
                presenter.sendEmail();
                break;
            case R.id.lytIg:
                presenter.openInstagram();
                break;
            case R.id.lytTwitter:
                presenter.openTwitter();
                break;
        }
    }
}
