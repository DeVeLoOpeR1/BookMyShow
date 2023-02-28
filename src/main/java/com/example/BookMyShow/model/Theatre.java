package com.example.BookMyShow.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "theatre")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;

    //this is the parent of the theatre seat class
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<TheatreSeat> theatreSeatList;

    // for bidirectional mapping with the show to be  done
    @OneToMany(mappedBy = "theatre",cascade = CascadeType.ALL)
    private List<Show> theatreShowList;
}
