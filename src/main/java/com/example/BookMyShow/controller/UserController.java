package com.example.BookMyShow.controller;

import com.example.BookMyShow.requestDto.UserRequest;
import com.example.BookMyShow.responseDto.UserResponse;
import com.example.BookMyShow.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServiceImpl userService;
    @PostMapping("/add")
    public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest){
        try{
            return new ResponseEntity<>(userService.createUser(userRequest), HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/userById/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int userId){

        try{
            return new ResponseEntity<>(userService.getUserById(userId),HttpStatus.OK);
        }
        catch(Exception e){
            //make an object of the user exception
            return new ResponseEntity<>(new UserResponse(),HttpStatus.BAD_GATEWAY);
        }

    }

}
