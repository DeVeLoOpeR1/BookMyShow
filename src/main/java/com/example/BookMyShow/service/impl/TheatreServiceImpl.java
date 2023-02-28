package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.model.Theatre;
import com.example.BookMyShow.model.TheatreSeat;
import com.example.BookMyShow.repository.TheatreRepository;
import com.example.BookMyShow.requestDto.TheatreRequest;
import com.example.BookMyShow.service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {

    @Autowired
    TheatreRepository theatreRepository;

    @Override
    public String createTheatre(TheatreRequest theatreRequest) throws Exception{

        Theatre theatre = Theatre.builder()
                .name(theatreRequest.getName()).location(theatreRequest.getLocation()).build();

        List<TheatreSeat> theatreSeatList = getTheatreSeatList(theatreRequest,theatre);

        theatre.setTheatreSeatList(theatreSeatList);
        theatreRepository.save(theatre);

        return "Theatre created successfully";

    }
    @Override
    public List<TheatreSeat> getTheatreSeatList(TheatreRequest theatreRequest, Theatre theatre){

        // let create a list of the theatre seat
        List<TheatreSeat> theatreSeatList = new ArrayList<>();
        // let create classic seat first
        for(int i=1;i<=theatreRequest.getClassicSeatCount();i++){
            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(i+"C");
            theatreSeat.setSeatType("CLASSIC SEAT");
            theatreSeat.setTheatre(theatre);

            // store that theatre seat into the list
            theatreSeatList.add(theatreSeat);

        }
        // done for classic seat

        // now create the premium seat
        for(int i=1;i<=theatreRequest.getPremiumSeatCount();i++){
            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(i+"P");
            theatreSeat.setSeatType("PREMIUM SEAT");
            theatreSeat.setTheatre(theatre);

            // store that theatre seat into the list
            theatreSeatList.add(theatreSeat);

        }
        // Done for premium seat
        // Now lets set the Recliner seat
        for(int i=1;i<=theatreRequest.getReclinerSeatCount();i++){
            TheatreSeat theatreSeat = new TheatreSeat();
            theatreSeat.setSeatNo(i+"R");
            theatreSeat.setSeatType("RECLINER SEAT");
            theatreSeat.setTheatre(theatre);


            // store that theatre seat into the list
            theatreSeatList.add(theatreSeat);

        }

        // ALL TYPE SEAT IS CREATED NOW WE WANT TO RETURN THE LIST
        return theatreSeatList;
    }

}
