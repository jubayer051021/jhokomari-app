package com.jhokomari.authenticationapp.mapper;

import com.jhokomari.authenticationapp.dto.RegisterReqDto;
import com.jhokomari.authenticationapp.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
public class UserMapping {
    private final PasswordEncoder passwordEncoder;

}
