package com.example.BookMyShow.model;
import lombok.*;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private int age;

    @Column(unique = true, nullable = false)
    private String mobNo;

    private String address;

    //bidirectional mapping of the ticket with user class
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Ticket> userTicketList;


}
