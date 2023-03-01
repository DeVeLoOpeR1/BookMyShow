package com.example.BookMyShow.service.impl;

import com.example.BookMyShow.model.Show;
import com.example.BookMyShow.model.ShowSeat;
import com.example.BookMyShow.model.Ticket;
import com.example.BookMyShow.model.User;
import com.example.BookMyShow.repository.ShowRepository;
import com.example.BookMyShow.repository.ShowSeatRepository;
import com.example.BookMyShow.repository.TicketRepository;
import com.example.BookMyShow.repository.UserRepository;
import com.example.BookMyShow.requestDto.TicketRequest;
import com.example.BookMyShow.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ShowRepository showRepository;
    @Autowired
    TicketRepository ticketRepository;
    public String createTicket(TicketRequest ticketRequest) throws Exception{
        User user = userRepository.findById(ticketRequest.getUserId()).get();
        Show show = showRepository.findById(ticketRequest.getShowId()).get();

        int tempPrice = 0;

        // check for the user requested show seat available or not if available then assign
        List<String> showSeatList = ticketRequest.getShowSeatList();
        for(String showSeatId:showSeatList){
            ShowSeat showSeat = getShowSeatBySeatNo(showSeatId,show);
            if(showSeat == null){
             System.out.println("Show Seat No is not in database pls provide another no");
             continue;
            }
            if(!showSeat.isBooked()){
                // set booked attribute to true
                showSeat.setBooked(true);
                // get the ticket price
                tempPrice += showSeat.getPrice();
                // set the show seat booked time
                showSeat.setSeatBookAt(LocalDate.now());

            }
            else{
                System.out.println(showSeatId + " Is Already booked ");
            }
        }

        if(tempPrice == 0) {
            throw new Exception("ticket not available that why price is zero 0");
        }
        Ticket ticket = Ticket.builder()
                .showDate(show.getShowDate()).showTiming(show.getShowTime())
                .movieName(show.getMovie().getMovieName())
                .theaterName(show.getTheatre().getName()).build();

        ticket.setUser(user);
        ticket.setShowBooked(show);
        // first add the ticket to the user ticket list and calculate the price total
        ticket.setTotalPrice(tempPrice);
        // store the ticket into the database
        ticketRepository.save(ticket);


        // add the ticket to the user ticket list and save the user
        user.getUserTicketList().add(ticket);
        userRepository.save(user);

        // add the ticket to the show ticket list and save the show

        show.getShowTicketList().add(ticket);
        showRepository.save(show);

        return "ticket created successfully";

    }

    public ShowSeat getShowSeatBySeatNo(String showSeatId,Show show) {
    List<ShowSeat> showSeatList = show.getShowSeatList();
    // search for the respected show id
        for(ShowSeat showSeat:showSeatList){
            if(showSeat.getSeatNo().equals(showSeatId)){
                return showSeat;
            }
        }
     return null;
    }
}
