//package com.example.hwspringbuytickets.service;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//@Service
//public class SecurityService {
//    @Autowired
//    private CustomerService customerService;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//    public static final Logger logger= LoggerFactory.getLogger(SecurityService.class);
//
//    public void autoLogin(String email,String password){
//        UserDetails userDetails=customerService.loadUserByUsername(email);
//        UsernamePasswordAuthenticationToken token=new UsernamePasswordAuthenticationToken(userDetails,password,userDetails.getAuthorities());
//        authenticationManager.authenticate(token);
//
//        if(token.isAuthenticated())
//        {
//            SecurityContextHolder.getContext().setAuthentication(token);
//
//        }
//    }
//}
