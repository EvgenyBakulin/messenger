package com.bakulin.messenger.controller;

import com.bakulin.messenger.exeptions.NotPermitExeption;
import com.bakulin.messenger.model.Users;
import com.bakulin.messenger.repository.UserRepository;
import com.bakulin.messenger.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    private final UserService userService;
    private final UserRepository userRepository;

    private UserController(UserService userService, UserRepository userRepository)
    {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/users/find")
    public ResponseEntity<Users> getByFirstNameAndLastName(@RequestParam String firstName, String lastName, Authentication a) {
        if (userRepository.findByUsername(a.getName()).isPresent())
        return ResponseEntity.ok(userService.getByFirstNameAndLastName(firstName,lastName));
        else throw new NotPermitExeption("Forbidden");
    }
}
