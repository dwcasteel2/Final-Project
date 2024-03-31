package com.promineo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.promineo.model.Team;
import com.promineo.service.TeamService;


@RestController
@RequestMapping("/sport_season/team")
public class TeamController {
	
	private TeamService teamService;
	public TeamController(TeamService teamService) {
		this.teamService = teamService;
	}
	
	@GetMapping
	public List<Team> getAllTeams(){
		return teamService.getAllTeams();
	}
	
	@GetMapping("/{team_id}")
	public ResponseEntity<Team> getTeamById(@PathVariable("team_id") Long teamId){
		return new ResponseEntity<Team>(teamService.getTeamById(teamId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Team> saveTeam(@RequestBody Team team){
		return new ResponseEntity<Team>(teamService.saveTeam(team), HttpStatus.CREATED);
	}
	
	@PutMapping("/{team_id}")
	public ResponseEntity<Team> updateTeam(@PathVariable("team_id") Long teamId, @RequestBody Team team){
		team.setTeam_id(teamId);
		return new ResponseEntity<Team>(teamService.saveTeam(team), HttpStatus.OK);
	}
	
	@DeleteMapping("/{team_id}")
	public ResponseEntity<String> updateTeam(@PathVariable("team_id") Long teamId){
		teamService.deleteTeam(teamId);
		return new ResponseEntity<String>("Team Deleted", HttpStatus.OK);
	}
	

}
