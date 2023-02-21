package com.bakulin.messenger.dto;

import lombok.Data;

@Data
public class RegisterRequestDto {
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private Boolean privacy;
    private Role role;
}
