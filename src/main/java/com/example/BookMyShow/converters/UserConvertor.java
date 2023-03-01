package com.example.BookMyShow.converters;

import com.example.BookMyShow.model.User;
import com.example.BookMyShow.requestDto.UserRequest;
import com.example.BookMyShow.responseDto.UserResponse;

public class UserConvertor {


    public static User converterUserReqToUser(UserRequest userRequest) {
        // convert the userDto into the user object
        // set the user attribute with the builder

        User user = User.builder().email(userRequest.getEmail())
                .age(userRequest.getAge()).mobNo(userRequest.getMobNo())
                .address(userRequest.getAddress()).name(userRequest.getName()).build();

        return user;
    }

    public static UserResponse userToUserResponseConvertor(User user) {
        // create a new object of the userResponse
        UserResponse userResponse = UserResponse.builder().id(user.getId()).address(user.getAddress()).mobNo(user.getMobNo()).email(user.getEmail()).age(user.getAge())
                .build();

        return userResponse;
    }
}
