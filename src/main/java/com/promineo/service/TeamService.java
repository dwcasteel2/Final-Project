package com.promineo.service;

import java.util.List;

import com.promineo.model.Team;

public interface TeamService {
	
	
	//READ	
	public List<Team> getAllTeams();
	
	//READ by Team ID
	public Team getTeamById(Long id);
	
	//CREATE
	public Team saveTeam(Team team);
	
	//UPDATE
	public Team updateTeam(Team team, Long id);
	
	//DELETE
	public void deleteTeam(Long id);

}
