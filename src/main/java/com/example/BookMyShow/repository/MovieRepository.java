package com.example.BookMyShow.repository;

import com.example.BookMyShow.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Integer> {
}
