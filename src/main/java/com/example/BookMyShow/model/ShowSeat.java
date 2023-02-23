package com.example.BookMyShow.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "show_seat")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class ShowSeat {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column(unique = true,nullable = false)
private String seatNo;
private boolean isBooked;
private int price;
private String seatType;
private LocalDate seatBookAt ;

// show seat is a child of the show parent class
    @ManyToOne
    @JoinColumn
    private Show shows;


}
