package com.example.mohini.mymovie.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.mohini.mymovie.model.User;
import com.example.mohini.mymovie.R;

import com.example.mohini.mymovie.utility.Utility;
import com.example.mohini.mymovie.webservicemanager.ApiClient;
import com.example.mohini.mymovie.webservicemanager.ApiConstant;
import com.example.mohini.mymovie.webservicemanager.ApiInterface;
import com.example.mohini.mymovie.webservicemanager.LoginResponse.LoginResponse;
import com.example.mohini.mymovie.webservicemanager.MakeApiCalls;

import retrofit2.Call;

public class LoginActivity extends AppCompatActivity implements MakeApiCalls.CallListener {

    private EditText etUsername;
    private EditText etPassword;
    User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        user = new User();
        getIDs();
        String msg = getString(R.string.something_went_wrong);
//        utility.hideSoftKeyboard(this);
    }

    public void getIDs()
    {
        etUsername = this.findViewById(R.id.etUsername);
        etPassword = this.findViewById(R.id.etPassword);
    }
    public void loginButtonPressed(View v){

        if(etPassword.getText().toString().length() > 0 && etUsername.getText().toString().length() > 0){

            user = user.setUserForLogin(this.etUsername.getText().toString(), this.etPassword.getText().toString());

            ApiInterface apiInterface = ApiClient.createService(ApiInterface.class);

            Call<LoginResponse> call = apiInterface.loginWithCredentials(ApiConstant.api_key, ApiConstant.request_token, user.username, user.password );

            MakeApiCalls.CommonCall(call, this, this, MakeApiCalls.LOGIN_KEY);
           // on success start a new activity
        }
        else
            Utility.showToast(this, "Invalid credentials");
    }

    @Override
    public void onCallSuccess(Object result, String key) {

        Intent myIntent = new Intent(this, MainActivity.class);
        this.startActivity(myIntent);
    }
}
