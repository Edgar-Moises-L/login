//package com.example.login.controller;
//
//import org.springframework.security.access.prepost.PreAuthorize;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/api/auth")
//@PreAuthorize("denyAll()")
//public class AuthController {
//
//    @GetMapping("/hello")
//    @PreAuthorize("permitAll()")
//    public String hello(){
//        return "hello world";
//    }
//
//    @GetMapping("/hello-security")
//    @PreAuthorize("hasAuthority('READ')")
//    public String helloSecurity(){
//        return "hello world seguro";
//    }
//}
