package com.example.BookMyShow.service;

import com.example.BookMyShow.model.Show;
import com.example.BookMyShow.model.ShowSeat;
import com.example.BookMyShow.requestDto.ShowRequest;
import com.example.BookMyShow.responseDto.ShowResponse;

import java.util.List;

public interface ShowService {
    String createShow(ShowRequest showRequest);
    List<ShowSeat> getShowSeatList(ShowRequest showRequest, Show show);
    List<ShowResponse> getShowByMovieName(String name);

}
