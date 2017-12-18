package com.example.mohini.mymovie;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Model.User;
import Utility.Utility;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = new User();
        getIDs();
//        Utility.hideSoftKeyboard(this);
    }

    public void getIDs()
    {
        etUsername = this.findViewById(R.id.etUsername);
        etPassword = this.findViewById(R.id.etPassword);
    }
    public void loginButtonPressed(View v){

        if(etPassword.getText().toString().length() > 0 && etUsername.getText().toString().length() > 0){

            user = user.setUserForLogin(this.etUsername.getText().toString(), this.etPassword.getText().toString());

           // on success start a new activity

            Intent myIntent = new Intent(this, MainActivity.class);
            this.startActivity(myIntent);
        }
        else
        {
            Utility.showToast(this, "Invalid credentials");
        }
    }
}
