package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.model.*;
import com.example.BookMyShow.repository.MovieRepository;
import com.example.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.repository.TheatreRepository;
import com.example.BookMyShow.requestDto.ShowRequest;
import com.example.BookMyShow.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    TheatreRepository theatreRepository;
    @Autowired
    MovieRepository movieRepository;

    @Autowired
    ShowRepository showRepository;

    @Override
    public String createShow(ShowRequest showRequest){

        Show show = Show.builder()
                .showType(showRequest.getShowType()).build();

        // let create a show list
        List<ShowSeat> showSeatList = getShowSeatList(showRequest,show);
        show.setShowDate(LocalDate.of(2023,2,28));
        show.setShowTime(LocalTime.of(12,40));
        show.setShowType(showRequest.getShowType());
        show.setShowSeatList(showSeatList);
        // set the movie related mapping
        Movie movie =  movieRepository.findById(showRequest.getMovieId()).get();
        show.setMovie(movie);
        movie.getMovieShowList().add(show);
        movieRepository.save(movie);

        // set theater related things
        Theatre theatre = theatreRepository.findById(showRequest.getTheatreId()).get();
        show.setTheatre(theatre);
        theatre.getTheatreShowList().add(show);
        theatreRepository.save(theatre);



        return "Show created successfully";
    }

    @Override
    public List<ShowSeat> getShowSeatList(ShowRequest showRequest, Show show) {
        List<ShowSeat> showSeatList = new ArrayList<>();

        Theatre theatre = theatreRepository.findById(showRequest.getTheatreId()).get();
        List<TheatreSeat> theatreSeatList = theatre.getTheatreSeatList(); // get the list

        // Now Show Seat create corresponding to the theatre
        for(TheatreSeat theatreSeat : theatreSeatList){

            ShowSeat showSeat = new ShowSeat();
            showSeat.setSeatNo(theatreSeat.getSeatNo());
            showSeat.setSeatType(theatreSeat.getSeatType());
            showSeat.setBooked(false);
            if(theatreSeat.getSeatNo().contains("C")){
                showSeat.setPrice(showRequest.getClassicSeatPrice());
            }
            else if(theatreSeat.getSeatNo().contains("P")){
                showSeat.setPrice(showRequest.getPremiumSeatPrice());
            }
            else {
                showSeat.setPrice(showRequest.getReclinerSeatPrice());
            }
            // set the show foreign key in show seat
            showSeat.setShows(show);

            showSeatList.add(showSeat);
        }

        return showSeatList;
    }

}
