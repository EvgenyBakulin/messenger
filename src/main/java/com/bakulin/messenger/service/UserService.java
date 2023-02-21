package com.bakulin.messenger.service;

import com.bakulin.messenger.model.Users;

public interface UserService {
    Users getByFirstNameAndLastName(String firstName, String lastName);
}
