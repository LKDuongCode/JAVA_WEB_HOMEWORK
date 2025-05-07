package com.duong.ss02.hw05;

public class UserInfoHw05 {
    private String name;
    private String email;
    private String password;

    public UserInfoHw05(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserInfoHw05() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
