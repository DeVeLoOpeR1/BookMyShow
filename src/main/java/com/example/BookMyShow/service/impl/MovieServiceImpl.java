package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.converters.MovieConvertor;
import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.requestDto.MovieRequest;
import com.example.BookMyShow.responseDto.MovieResponse;
import com.example.BookMyShow.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepository movieRepository;
    @Override
    public String createMovie(MovieRequest movieRequest) {
        Movie movie = MovieConvertor.convertorMovieRequestToMovie(movieRequest);
        movieRepository.save(movie);
        return "movie created successfully";
    }

    @Override
    public MovieResponse getMovieById(int id) {
        Movie movie = movieRepository.findById(id).get();
        MovieResponse movieResponse = MovieConvertor.convertorMovieToMovieResponse(movie);
        return movieResponse;
    }
}
