package com.example.BookMyShow.model;

import com.example.BookMyShow.Enum.Genre;
import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movie")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String movieName;
    private double rating;
    private int duration;
    private String language;
    @Enumerated(value = EnumType.STRING) //only for database that consider this as a string
    private Genre genre;

    //for bidirectional mapping wrt to the child show
    @OneToMany(mappedBy = "movie",cascade = CascadeType.ALL)
    private List<Show> movieShowList;





}
