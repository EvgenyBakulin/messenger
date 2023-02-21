package com.bakulin.messenger.service;

import com.bakulin.messenger.dto.RegisterRequestDto;
import com.bakulin.messenger.dto.Role;

public interface AuthenticService {
    boolean login (String login, String password);
    boolean registration (RegisterRequestDto registerRequestDto, Role role);
}
