package com.bookingsystem.MovieTicket.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@Table(name = "sessions_movies")
public class Sessions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movies movies;

    private LocalDate dateSession;

    private LocalTime timeStartSession;

    private String daySession;

    public Sessions() {
        super();
    }

    public Sessions(Movies movies, LocalDate dateSession, LocalTime timeStartSession, String daySession) {
        this.movies = movies;
        this.dateSession = dateSession;
        this.timeStartSession = timeStartSession;
        this.daySession = daySession;
    }
}
