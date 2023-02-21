package com.bakulin.messenger.controller;

import com.bakulin.messenger.dto.LoginRequestDto;
import com.bakulin.messenger.dto.RegisterRequestDto;
import com.bakulin.messenger.dto.Role;
import com.bakulin.messenger.service.AuthenticService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.bakulin.messenger.dto.Role.USER;

@Slf4j
@RestController
@RequiredArgsConstructor
public class AuthenticController {
  private final AuthenticService authenticService;

  @PostMapping("/login")
  public ResponseEntity<?> login(@RequestBody LoginRequestDto request) {
    if (authenticService.login(request.getUsername(), request.getPassword())) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
  }
  @PostMapping("/register")
  public ResponseEntity<?> register(@RequestBody RegisterRequestDto request) {
    Role role = request.getRole() == null ? USER : request.getRole();
    if (authenticService.registration(request, role)) {
      return ResponseEntity.ok().build();
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }
  }

}
