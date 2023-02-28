package com.example.BookMyShow.controller;

import com.example.BookMyShow.requestDto.TheatreRequest;
import com.example.BookMyShow.service.impl.TheatreServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("theatre")
public class TheatreController {
    @Autowired
    TheatreServiceImpl theatreService;

    @PostMapping("add")
    public ResponseEntity<String> createTheatre(@RequestBody TheatreRequest theatreRequest){
        try{
            return new ResponseEntity<>(theatreService.createTheatre(theatreRequest),HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
