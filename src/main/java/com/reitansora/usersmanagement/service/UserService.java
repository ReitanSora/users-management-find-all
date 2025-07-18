package com.reitansora.usersmanagement.service;

import com.reitansora.usersmanagement.entity.UserEntity;
import com.reitansora.usersmanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Service class for managing user-related operations.
 */
@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     * Constructs a UserService with the given UserRepository.
     *
     * @param userRepository the user repository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Retrieves all users from the repository.
     *
     * @return a list of all users
     */
    public ArrayList<UserEntity> getAllUsers() {
        return (ArrayList<UserEntity>) userRepository.findAll();
    }

}
