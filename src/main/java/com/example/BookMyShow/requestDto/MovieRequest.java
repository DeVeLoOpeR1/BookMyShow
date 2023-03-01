package com.example.BookMyShow.requestDto;

import com.example.BookMyShow.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class MovieRequest {
    private String movieName;
    private double rating;
    private int duration;
    private String language;
    private Genre genre;
}
