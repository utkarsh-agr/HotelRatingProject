package com.hotelservices.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hotelservicecreator")
public class CreatorController {

    @GetMapping
    public ResponseEntity<List<String>> getCreatorNames(){
        List<String> names = Arrays.asList("ram","krishna","Anita");
        return ResponseEntity.ok(names);
    }
}
