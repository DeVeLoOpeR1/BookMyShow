package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeat,Integer> {

    ShowSeat findBySeatNo(String seatNo);
}
