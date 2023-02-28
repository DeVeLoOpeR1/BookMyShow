package com.example.BookMyShow.responseDto;

import com.example.BookMyShow.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MovieResponse {
    private String movieName;
    private double rating;
    private int duration;
    private String language;
    private Genre genre;
}
