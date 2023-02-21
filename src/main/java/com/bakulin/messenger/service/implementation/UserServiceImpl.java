package com.bakulin.messenger.service.implementation;

import com.bakulin.messenger.model.Users;
import com.bakulin.messenger.repository.UserRepository;
import com.bakulin.messenger.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public Users getByFirstNameAndLastName(String firstName, String lastName) {
        return userRepository.findUsersByFirstNameAndLastName(firstName,lastName);
    }
}
