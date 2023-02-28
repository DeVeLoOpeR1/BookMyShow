package com.example.BookMyShow.requestDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TheatreRequest {

    private String name;
    private String location;
    private int classicSeatCount;
    private int premiumSeatCount;
    private int ReclinerSeatCount;

}
