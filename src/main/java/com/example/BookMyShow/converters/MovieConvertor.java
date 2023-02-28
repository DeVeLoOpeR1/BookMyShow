package com.example.BookMyShow.converters;

import com.example.BookMyShow.model.Movie;
import com.example.BookMyShow.requestDto.MovieRequest;
import com.example.BookMyShow.responseDto.MovieResponse;

public class MovieConvertor {
    public static Movie convertorMovieRequestToMovie(MovieRequest movieRequest){
        // now we are creating a new object of the movie entity using builder annotation
        // Or we can also DO SAME THING WITH THE NEW Keyword also

        Movie movie = Movie.builder()
                .movieName(movieRequest.getMovieName()).duration(movieRequest.getDuration())
                .language(movieRequest.getLanguage()).rating(movieRequest.getRating())
                .genre(movieRequest.getGenre()).build();
        return movie;
    }
    public static MovieResponse convertorMovieToMovieResponse(Movie movie){

        MovieResponse movieResponse = MovieResponse.builder() // builder is used to build object
                .movieName(movie.getMovieName()).rating(movie.getRating())
                .duration(movie.getDuration()).language(movie.getLanguage())
                .genre(movie.getGenre()).build();

        return movieResponse;
    }
}
