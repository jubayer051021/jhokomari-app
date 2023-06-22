package com.jhokomari.authenticationapp.controller;

import com.jhokomari.authenticationapp.dto.LoginReqDto;
import com.jhokomari.authenticationapp.dto.LoginResDto;
import com.jhokomari.authenticationapp.dto.RegisterReqDto;
import com.jhokomari.authenticationapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService authService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterReqDto request){
        return authService.registerUser(request);
    }


    @PostMapping("/login")
    public LoginResDto loginUser(@RequestBody LoginReqDto loginReqDto){
        return authService.loginUser(loginReqDto);
    }
}
