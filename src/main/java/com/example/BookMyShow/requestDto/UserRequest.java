package com.example.BookMyShow.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @Column(unique = true, nullable = false)
    private String email;

    private int age;

    @Column(unique = true, nullable = false)
    private String mobNo;

    private String address;
}
