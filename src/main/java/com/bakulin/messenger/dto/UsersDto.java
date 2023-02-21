package com.bakulin.messenger.dto;

import lombok.Data;

import java.util.Objects;

@Data
public class UsersDto {
    private String firstName;
    private String lastName;
    private Boolean access;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UsersDto usersDto)) return false;
        return Objects.equals(getFirstName(), usersDto.getFirstName()) && Objects.equals(getLastName(), usersDto.getLastName()) && Objects.equals(getAccess(), usersDto.getAccess());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getAccess());
    }
    
}
