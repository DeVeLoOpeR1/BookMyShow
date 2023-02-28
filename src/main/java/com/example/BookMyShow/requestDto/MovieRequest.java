package com.example.BookMyShow.requestDto;

import com.example.BookMyShow.Enum.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
