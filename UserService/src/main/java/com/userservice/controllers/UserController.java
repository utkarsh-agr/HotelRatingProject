package com.userservice.controllers;

import com.userservice.entities.User;
import com.userservice.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserServices userServices;

    //private final Logger logger= LoggerFactory.getLogger(UserController.class);

    //save a user
    @PostMapping
    public ResponseEntity<User> saveAUser(@RequestBody User user){
        User returnedUser=this.userServices.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(returnedUser);
    }

    //get a user with userId
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable String userId){
        return ResponseEntity.ok(this.userServices.getUserById(userId));
    }



    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(this.userServices.getAllUsers());
    }

}
