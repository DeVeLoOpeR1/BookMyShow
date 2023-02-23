package com.example.BookMyShow.model;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Entity
@Table(name = "shows")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Show {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;
    private LocalTime showTime;
    private String showType;

    // show is the parent class for ticket
    @OneToMany(mappedBy = "showBooked",cascade = CascadeType.ALL)
    private List<Ticket> showTicketList;

    // show is the child wrt to movie parent class
    @ManyToOne
    @JoinColumn
    private Movie movie;

    //show also parent for show seat child class
    @OneToMany(mappedBy = "shows",cascade = CascadeType.ALL)
    private List<ShowSeat> showSeatList;

    //show is the child of the theatre class
    @ManyToOne
    @JoinColumn
    private Theatre theatre;


}
