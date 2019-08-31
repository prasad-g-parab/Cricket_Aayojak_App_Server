package com.aayojak.tournament;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TournamentService {
    
    @Autowired
    TournamentRepository tournamentRepository;
    

    public List<Tournament> getTournaments(boolean isACtive) {
        return tournamentRepository.findByActive(isACtive);
        
    }

    public List<Tournament> getTournaments() {
        // TODO Auto-generated method stub
        return tournamentRepository.findAll();
    }

    
    
    
}
