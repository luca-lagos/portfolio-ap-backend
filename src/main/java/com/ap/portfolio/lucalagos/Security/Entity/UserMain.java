package com.ap.portfolio.lucalagos.Security.Entity;

import java.util.List;

import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserMain implements UserDetails {
    private String name;
    private String user_name;
    private String email;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    public UserMain(){

    }

    public UserMain(String name, String user_name, String email, String password, Collection<? extends GrantedAuthority> authorities) {
        this.name = name;
        this.user_name = user_name;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
    }

    public static @NotNull UserMain build(@NotNull UserCommon userCommon){
        List<GrantedAuthority> authorities = userCommon.getRoles().stream().map(role -> new SimpleGrantedAuthority(role.getRoleName().name())).collect(Collectors.toList());
        return new UserMain(userCommon.getName(), userCommon.getUser_name(), userCommon.getEmail(), userCommon.getPassword(), authorities);
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return user_name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
