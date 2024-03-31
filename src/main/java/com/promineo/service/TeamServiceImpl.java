package com.promineo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineo.exception.RespurceNotFoundExcption;
import com.promineo.model.Team;
import com.promineo.repository.TeamRepostiory;

@Service
public class TeamServiceImpl implements TeamService{
	
	private TeamRepostiory teamRepostiory;
	public TeamServiceImpl(TeamRepostiory teamRepostiory) {
		this.teamRepostiory = teamRepostiory;
	}
	
	//READ Get operation
	@Override
	public List<Team> getAllTeams() {
		return teamRepostiory.findAll();
	}

	@Override
	public Team saveTeam(Team team) {
		return teamRepostiory.save(team);
	}

	@Override
	public Team getTeamById(Long id) {
		return teamRepostiory.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Team", "ID", id));
	}

	@Override
	public Team updateTeam(Team team, Long id) {
		Team existingTeam = teamRepostiory.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Team", "ID", id));
	existingTeam.setTeam_name(team.getTeam_name());
	existingTeam.setTeam_mascot(team.getTeam_mascot());
	existingTeam.setCity(team.getCity());
	existingTeam.setState(team.getState());
		return existingTeam;
	}

	@Override
	public void deleteTeam(Long id) {
		Team existingTeam = teamRepostiory.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Team", "ID", id));
		teamRepostiory.deleteById(id);
	}

}
