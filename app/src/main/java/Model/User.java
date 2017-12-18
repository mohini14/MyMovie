package Model;

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
}
