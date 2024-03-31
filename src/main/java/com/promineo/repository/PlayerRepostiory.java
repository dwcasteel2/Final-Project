package com.promineo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineo.model.Player;

public interface PlayerRepostiory extends JpaRepository<Player, Long> {

}
