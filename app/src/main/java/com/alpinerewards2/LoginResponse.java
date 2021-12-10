package com.alpinerewards2;

import java.io.Serializable;

public class LoginResponse implements Serializable {
    //WE NEED TO UPDATE THIS BASED ON WHAT WE WILL RECEIVE FROM THEM
    //this variables is for me to taste it with a restfull API

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String user_id;
    private String email;
    private String username;
    private String first_name;

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }


    private String date_joined;

}
