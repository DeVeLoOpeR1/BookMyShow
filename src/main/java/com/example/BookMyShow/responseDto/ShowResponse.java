package com.example.BookMyShow.responseDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowResponse {
    private String theatreName;
    private LocalDate showDate;
    private LocalTime showTime;
}
