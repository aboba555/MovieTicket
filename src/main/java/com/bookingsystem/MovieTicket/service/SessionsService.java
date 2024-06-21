package com.bookingsystem.MovieTicket.service;

import com.bookingsystem.MovieTicket.model.Sessions;
import com.bookingsystem.MovieTicket.repository.SessionsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SessionsService {
    private SessionsRepository sessionsRepository;

    public List<Sessions> findAll(){
        return sessionsRepository.findAll();
    }

    public void save(Sessions sessions){
        sessionsRepository.save(sessions);
    }


}
