package com.project.schoolsystem.service.old;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {
//    private final IAuthenticationFacade authenticationFacade;
//    private final UserDetailsService userDetailsService;
//    private final AuthenticationManager authenticationManager;
//
//    @Autowired
//    public SecurityService(IAuthenticationFacade authenticationFacade, @Qualifier("userDetailsServiceImpl") UserDetailsService userDetailsService, AuthenticationManager authenticationManager) {
//        this.authenticationFacade = authenticationFacade;
//        this.userDetailsService = userDetailsService;
//        this.authenticationManager = authenticationManager;
//    }
//
//    @Override
//    public String findLoggedInUsername() {
//        return authenticationFacade.getAuthentication().getName();
//    }
//
//    @Override
//    public void autologin(String username, String password) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthentcationToken(userDetails, password, userDetails.getAuthorities());
//        authenticationManager.authenticate(token);
//    }
}
