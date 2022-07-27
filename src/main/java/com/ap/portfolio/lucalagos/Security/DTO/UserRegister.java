package com.ap.portfolio.lucalagos.Security.DTO;

import java.util.HashSet;
import java.util.Set;

public class UserRegister {
    private String name;
    private String user_name;
    private String email;
    private String password;
    private Set<String> roles = new HashSet<>();

    public UserRegister(){

    }

    public UserRegister(String name, String user_name, String email, String password, Set<String> roles) {
        this.name = name;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
