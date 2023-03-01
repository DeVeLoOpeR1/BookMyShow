package com.example.BookMyShow.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "ticket")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor //builder need all args constructor to work
public class Ticket {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
private String ticketId = UUID.randomUUID().toString();
private int totalPrice;
private String movieName;
private LocalTime showTiming;
private LocalDate showDate;
private String theaterName;

//making ticket child class wrt to user parent class
@ManyToOne
@JoinColumn
    private User user;

// making ticket child class wrt to show
    @ManyToOne
    @JoinColumn
    private Show showBooked;



}
