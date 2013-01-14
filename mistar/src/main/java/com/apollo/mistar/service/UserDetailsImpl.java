package com.apollo.mistar.service;

import com.apollo.mistar.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Copyright by Apollo Imaging Technology Pty Ltd.
 *
 * @Author: Hanmoi Daniel Choi
 * @Date : 14/01/13
 */
public class UserDetailsImpl implements UserDetails {

    private User _user;
    private List<GrantedAuthority> _roles;
    private List<GrantedAuthority> _grantedAuthorities;

    public UserDetailsImpl(User user){
        _user = user;
        _grantedAuthorities = new ArrayList<GrantedAuthority>();

        for(String role: user.getRoles()){
            _grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return _grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return _user.getPassword();
    }

    @Override
    public String getUsername() {
        return _user.getId();
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
