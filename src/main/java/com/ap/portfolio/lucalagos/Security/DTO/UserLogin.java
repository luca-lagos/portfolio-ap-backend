package com.ap.portfolio.lucalagos.Security.DTO;

import javax.validation.constraints.NotBlank;

public class UserLogin {
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public UserLogin(){

    }

    public UserLogin(String email, String password) {
        this.email = email;
        this.password = password;
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
