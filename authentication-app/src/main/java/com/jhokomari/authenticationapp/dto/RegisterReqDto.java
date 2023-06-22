package com.jhokomari.authenticationapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterReqDto {
    private String email;
    private String name;
    private String password;
    private String dob;
    private String gender;
    private String phoneNumber;
}
