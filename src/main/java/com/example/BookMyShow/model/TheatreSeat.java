package com.example.BookMyShow.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "theatreSeat")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheatreSeat {
     

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String seatNo;
    private String seatType;

    //theatre it is child of the theatre parent class
    @ManyToOne
    @JoinColumn
    private Theatre theatre;

}
