package com.example.BookMyShow.controller;

import com.example.BookMyShow.requestDto.ShowRequest;
import com.example.BookMyShow.responseDto.ShowResponse;
import com.example.BookMyShow.service.impl.ShowServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("shows")
public class ShowController {
    @Autowired
    ShowServiceImpl showService;

    @PostMapping("add")
    public ResponseEntity<String> createShow(@RequestBody ShowRequest showRequest){
        try{
            return new ResponseEntity<>(showService.createShow(showRequest),HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>("Failed to create",HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getShowByMovieName/{name}")
    public ResponseEntity< List<ShowResponse> > getShowByMovieName(@PathVariable String name){
        return new ResponseEntity<>(showService.getShowByMovieName(name),HttpStatus.OK);

    }

}
