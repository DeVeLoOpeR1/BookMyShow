package com.example.BookMyShow.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserResponse {
    private int id;
    private String email;
    private int age;
    private String mobNo;
    private String address;
    private Integer ticketId;
}
