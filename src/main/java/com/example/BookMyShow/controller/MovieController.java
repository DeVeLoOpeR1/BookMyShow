package com.example.BookMyShow.controller;

import com.example.BookMyShow.requestDto.MovieRequest;
import com.example.BookMyShow.responseDto.MovieResponse;
import com.example.BookMyShow.service.impl.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("movie")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @PostMapping("/add")
    public ResponseEntity<String> createMovie(@RequestBody MovieRequest movieRequest){

        try{
            return new ResponseEntity<>(movieService.createMovie(movieRequest), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/getMovieById/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@PathVariable int id){

       try{
           return new ResponseEntity<>(movieService.getMovieById(id),HttpStatus.OK);
       }
       catch(Exception e)
       {
           return new ResponseEntity<>(new MovieResponse(),HttpStatus.BAD_REQUEST); //send empty object in case of exception
       }
    }
}
