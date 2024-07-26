package com.bookingsystem.MovieTicket.service;

import com.bookingsystem.MovieTicket.model.Sessions;
import com.bookingsystem.MovieTicket.repository.SessionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SessionsService {
    private SessionsRepository sessionsRepository;

    public Map<Long, List<Sessions>> findAllGroupedByMovieId() {
        return findAll()
                .stream()
                .collect(Collectors.groupingBy(session -> session.getMovies().getId()));
    }

    public List<Sessions> findAll() {
        return sessionsRepository.findAll();
    }

    public void save(Sessions sessions){
        sessionsRepository.save(sessions);
    }

    public Sessions findByTimeAndMovieId(LocalTime sessionTime, Long movieId) {
        return sessionsRepository.findByTimeStartSessionAndMovies_Id(sessionTime, movieId);
    }
}

