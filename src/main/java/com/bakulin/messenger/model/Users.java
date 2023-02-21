package com.bakulin.messenger.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;

@Entity
@Setter
@Getter
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String role;
    private Boolean privacy;
    private Boolean enabled;

    @OneToMany
    @JoinColumn(name = "contacts")
    @JsonIgnore
    private Collection<Users> contacts;
}
