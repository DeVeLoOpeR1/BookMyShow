package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.converters.UserConvertor;
import com.example.BookMyShow.model.User;
import com.example.BookMyShow.repository.UserRepository;
import com.example.BookMyShow.requestDto.UserRequest;
import com.example.BookMyShow.responseDto.UserResponse;
import com.example.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public String createUser(UserRequest userRequest) throws Exception{
        User user = UserConvertor.converterUserReqToUser(userRequest);

        // know we have the user object then we can save it to user repository

        userRepository.save(user);
        return "user created successfully";

    }
    @Override
    public UserResponse getUserById(int userId) throws Exception{
        User user = userRepository.findById(userId).get(); // get the user object
        UserResponse userResponse = UserConvertor.userToUserResponseConvertor(user);
        return userResponse;
    }

}
