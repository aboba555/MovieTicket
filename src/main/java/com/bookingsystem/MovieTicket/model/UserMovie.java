package com.bookingsystem.MovieTicket.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;

@Entity
@Table(name = "user_movie")
@Data
public class UserMovie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movies movie;

    @ManyToOne
    @JoinColumn(name = "session_id", nullable = false)
    private Sessions session;

    private int numberOfTickets;

    private boolean active = false;

    public UserMovie() {}

    public UserMovie(User user, Movies movie, Sessions session, int numberOfTickets) {
        this.user = user;
        this.movie = movie;
        this.session = session;
        this.numberOfTickets = numberOfTickets;
    }
}
