package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetailsService {
    UserDetails loadUserByUserName(String username) throws UsernameNotFoundException;
}
