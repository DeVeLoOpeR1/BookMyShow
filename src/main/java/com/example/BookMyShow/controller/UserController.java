package com.example.BookMyShow.controller;

import com.example.BookMyShow.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("/add")
    public ResponseEntity createUser(@RequestBody User user){
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

}
