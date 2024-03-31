package com.promineo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineo.model.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
