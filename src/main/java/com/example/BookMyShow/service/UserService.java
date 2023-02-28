package com.example.BookMyShow.service;

import com.example.BookMyShow.requestDto.UserRequest;
import com.example.BookMyShow.responseDto.UserResponse;

public interface UserService {
    public String createUser(UserRequest userRequest) throws Exception;
    public UserResponse getUserById(int userId) throws Exception;
}
