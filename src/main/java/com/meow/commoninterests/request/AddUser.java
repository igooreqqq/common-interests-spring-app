package com.meow.commoninterests.request;

public class AddUser {

    private String username;
    private String email;

    public AddUser(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public AddUser() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
