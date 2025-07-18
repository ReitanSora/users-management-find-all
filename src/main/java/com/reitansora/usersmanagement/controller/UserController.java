package com.reitansora.usersmanagement.controller;


import com.reitansora.usersmanagement.entity.UserEntity;
import com.reitansora.usersmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Retrieves all users.
     *
     * @return a list of all users
     */
    @GetMapping(path = "/find")
    public ArrayList<UserEntity> getAllUsers(){
        return this.userService.getAllUsers();
    }

}
