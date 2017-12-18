package com.example.mohini.mymovie.webservicemanager.LoginResponse;

import com.google.gson.annotations.SerializedName;

/**
 * Created by mohini on 18/12/17.
 */

public class LoginResponse {

    @SerializedName("success")
    private Boolean success;

    @SerializedName("request_token")
    private String request_token;

}
