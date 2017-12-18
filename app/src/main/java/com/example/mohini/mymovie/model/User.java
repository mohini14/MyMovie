package com.example.mohini.mymovie.model;

/**
 * Created by mohini on 16/12/17.
 */

public class User {

    public String username;
    public String password;


    public  User setUserForLogin(String username, String password){

        this.username = username;
        this.password = password;
        return this;
    }

    // getter
    public String getPassword() {
        return this.password;
    }

    public String getUsername() {
        return this.username;
    }

    //setter
    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
