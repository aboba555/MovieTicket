package com.bookingsystem.MovieTicket.repository;

import com.bookingsystem.MovieTicket.model.Sessions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;

@Repository
public interface SessionsRepository extends JpaRepository<Sessions, Long> {
    Sessions findByTimeStartSessionAndMovies_Id(LocalTime timeStartSession, Long movieId);
}
