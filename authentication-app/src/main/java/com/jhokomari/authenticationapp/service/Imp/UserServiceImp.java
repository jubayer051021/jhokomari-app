package com.jhokomari.authenticationapp.service.Imp;

import com.jhokomari.authenticationapp.dto.LoginReqDto;
import com.jhokomari.authenticationapp.dto.LoginResDto;
import com.jhokomari.authenticationapp.dto.RegisterReqDto;
import com.jhokomari.authenticationapp.entity.UserEntity;
import com.jhokomari.authenticationapp.exception.UserAlreadyExistException;
import com.jhokomari.authenticationapp.mapper.UserMapping;
import com.jhokomari.authenticationapp.repository.UserRepository;
import com.jhokomari.authenticationapp.service.UserService;
import com.jhokomari.authenticationapp.utils.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ResponseEntity<String> registerUser(RegisterReqDto request) {
        UserEntity userEntity=userRepository.findByEmail(request.getEmail());
        if(userEntity!=null){
            throw new UserAlreadyExistException("User Already Exist");
        }
        UserEntity user= UserEntity.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .dob(request.getDob())
                .name(request.getName())
                .gender(request.getGender())
                .build();
        userRepository.save(user);
        return new ResponseEntity<>("successfully Registered", HttpStatus.CREATED);
    }

    @Override
    public LoginResDto loginUser(LoginReqDto loginReqDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReqDto.getEmail(), loginReqDto.getPassword()));
        UserEntity user = userRepository.findByEmail(loginReqDto.getEmail());
        if(user!=null){
            var jwtToken = jwtService.generateToken(user);
            return LoginResDto.builder()
                    .token(jwtToken).build();
        }
        else{
            throw new UsernameNotFoundException("Not found");
        }
    }
}
