package com.example.mohini.mymovie.webservicemanager;

/**
 * Created by mohini on 18/12/17.
 */

import com.example.mohini.mymovie.model.User;
import com.example.mohini.mymovie.webservicemanager.LoginResponse.LoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    // login related methods

    @GET(ApiConstant.login_resource)
    Call<LoginResponse> loginWithCredentials(@Query("api_key") String api_Key, @Query("request_token") String request_token,
                                             @Query("username") String username, @Query("password") String password);

}
