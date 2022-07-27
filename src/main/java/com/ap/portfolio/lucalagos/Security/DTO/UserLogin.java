package com.ap.portfolio.lucalagos.Security.DTO;

import javax.validation.constraints.NotBlank;

public class UserLogin {
    @NotBlank
    private String user_name;
    @NotBlank
    private String password;

    public UserLogin(){

    }

    public UserLogin(String user_name, String password) {
        this.user_name = user_name;
        this.password = password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
