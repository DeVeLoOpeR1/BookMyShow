package com.example.BookMyShow.controller;

import com.example.BookMyShow.requestDto.TicketRequest;
import com.example.BookMyShow.service.impl.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("ticket")
public class TicketController {
@Autowired
    TicketServiceImpl ticketService;
@PostMapping("add")
    public ResponseEntity<String> createTicket(@RequestBody TicketRequest ticketRequest){
    try{
        return new ResponseEntity<>(ticketService.createTicket(ticketRequest),HttpStatus.CREATED);
    }
    catch(Exception e){
        return new ResponseEntity<>("ticket not created "+ e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
}
