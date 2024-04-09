package com.uok.oop.ims.service;

import com.uok.oop.ims.dto.UserRegistrationDto;
import com.uok.oop.ims.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

// This interface defines the contract for user-related operations and authentication.
public interface UserService extends UserDetailsService {

    // Save a new user with registration details
    User save(UserRegistrationDto registrationDto);
}
