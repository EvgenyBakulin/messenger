package com.bakulin.messenger.service.implementation;

import com.bakulin.messenger.dto.RegisterRequestDto;
import com.bakulin.messenger.dto.Role;
import com.bakulin.messenger.model.Users;
import com.bakulin.messenger.repository.UserRepository;
import com.bakulin.messenger.service.AuthenticService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
public class AuthenticServiceImpl implements AuthenticService{
    private final UserDetailsManager manager;
   private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    public AuthenticServiceImpl(UserDetailsManager manager, UserRepository userRepository) {
        this.manager = manager;
        this.userRepository = userRepository;
        this.encoder = new BCryptPasswordEncoder();
    }

    @Override
    public boolean login(String login, String password) {
        UserDetails userDetails = manager.loadUserByUsername(login);
        String encryptedPassword = userDetails.getPassword().substring(8);
        return encoder.matches(password,encryptedPassword);
    }

    @Override
    public boolean registration(RegisterRequestDto registerRequestDto, Role role) {
        if (manager.userExists(registerRequestDto.getLogin())) {
            return false;
        }
        manager.createUser(User.withDefaultPasswordEncoder()
                .password(registerRequestDto.getPassword())
                .username(registerRequestDto.getLogin())
                .roles(role.name())
                .build());
        Users user = userRepository.findByUsername(registerRequestDto.getLogin()).orElseThrow(()-> new RuntimeException("Пользователь не найден"));
        user.setRole("USER");
        user.setPrivacy(registerRequestDto.getPrivacy());
        user.setFirstName(registerRequestDto.getFirstName());
        user.setLastName(registerRequestDto.getLastName());
        user.setEnabled(true);
        userRepository.save(user);
        return true;
    }
}
