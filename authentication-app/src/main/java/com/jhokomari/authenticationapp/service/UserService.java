package com.jhokomari.authenticationapp.service;

import com.jhokomari.authenticationapp.dto.LoginReqDto;
import com.jhokomari.authenticationapp.dto.LoginResDto;
import com.jhokomari.authenticationapp.dto.RegisterReqDto;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<String> registerUser(RegisterReqDto registerReqDto);

    LoginResDto loginUser(LoginReqDto loginReqDto);
}
