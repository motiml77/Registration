package com.example.registration;

public class Users {
    private String mail;
    private String userName;
    private String pass;

    //constructors

    public Users(String mail, String userName, String pass) {
        this.mail = mail;
        this.userName = userName;
        this.pass = pass;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "mail='" + mail + '\'' +
                ", userName='" + userName + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }

    //getters and setters
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
