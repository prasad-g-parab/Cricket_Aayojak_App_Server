package com.aayojak.tournament;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TournamentRepository extends JpaRepository<Tournament, String> {
   List<Tournament>  findByActive(boolean status);
}
