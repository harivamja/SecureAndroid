package com.example.myapplication;

public class Post {
    private String Username,Password,cnf_Password;

    public Post() {
    }

    public Post(String Username, String Password, String cnf_Password) {
        this.Username = Username;
        this.Password = Password;
        this.cnf_Password = cnf_Password;
    }
}
