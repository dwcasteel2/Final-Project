package com.promineo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineo.model.Team;

public interface TeamRepostiory extends JpaRepository<Team, Long> {

}
