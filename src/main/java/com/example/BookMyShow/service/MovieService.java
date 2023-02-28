package com.example.BookMyShow.service;

import com.example.BookMyShow.requestDto.MovieRequest;
import com.example.BookMyShow.responseDto.MovieResponse;

public interface MovieService {
    public String createMovie(MovieRequest movieRequest);
    public MovieResponse getMovieById(int id);
}
