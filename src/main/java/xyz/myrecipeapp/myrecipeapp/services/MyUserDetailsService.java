package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import xyz.myrecipeapp.myrecipeapp.model.Role;
import xyz.myrecipeapp.myrecipeapp.model.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class MyUserDetailsService implements UserDetails {

    private User user;

    public MyUserDetailsService(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<Role> roles = user.getRoles();
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return authorities;
    }

    @Override
    //because of below code, we have bad credentials error, because of null in password
//    public String getPassword() {
//        return null;
//    }

    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
//    public String getUsername() {
//        return null;
//    }
    public String getUsername() {
        return this.user.getUsername();
    }

    @Override
    /*if return false (in every below method) "User account is locked" will be displayed
    at localhost in browser*/
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
