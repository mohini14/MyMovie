package com.example.mohini.mymovie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import Utility.Utility;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Utility.hideSoftKeyboard(this);
    }
}
