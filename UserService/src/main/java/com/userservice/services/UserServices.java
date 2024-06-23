package com.userservice.services;

import com.userservice.entities.User;

import java.util.List;

public interface UserServices {

    User saveUser(User user);

    List<User> getAllUsers();

    User getUserById(String userId);



}
