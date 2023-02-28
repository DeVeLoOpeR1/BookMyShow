package com.example.BookMyShow.service;

import com.example.BookMyShow.model.Theatre;
import com.example.BookMyShow.model.TheatreSeat;
import com.example.BookMyShow.requestDto.TheatreRequest;

import java.util.List;

public interface TheatreService {

    String createTheatre(TheatreRequest theatreRequest) throws Exception;

    List<TheatreSeat> getTheatreSeatList(TheatreRequest theatreRequest, Theatre theatre);
}
