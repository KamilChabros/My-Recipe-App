package xyz.myrecipeapp.myrecipeapp.services;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

        @PreAuthorize("hasRole('ADMIN')")
//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
//    @Secured("ROLE_ADMIN")
    public String test() {
        return "TEST";
    }
}

