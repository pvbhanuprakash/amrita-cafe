package com.example.venug.amritacafe.Model;

/**
 * Created by venug on 28/10/2018.
 */

public class User {
    private String Email_id;
    private String Name;
    private String Password;
    private String Ph_no;



    public User() {
    }

    public User(String email_id, String name, String password, String ph_no) {
        Email_id = email_id;
        Name = name;
        Password = password;
        Ph_no = ph_no;
    }

    public String getEmail_id() {
        return Email_id;
    }

    public void setEmail_id(String email_id) {
        Email_id = email_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPh_no() {
        return Ph_no;
    }

    public void setPh_no(String ph_no) {
        Ph_no = ph_no;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}

