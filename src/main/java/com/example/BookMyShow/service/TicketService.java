package com.example.BookMyShow.service;

import com.example.BookMyShow.requestDto.TicketRequest;

public interface TicketService {

    String createTicket(TicketRequest ticketRequest) throws Exception;
}
