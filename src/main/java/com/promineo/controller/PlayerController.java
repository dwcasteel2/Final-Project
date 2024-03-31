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

import com.promineo.model.Player;
import com.promineo.service.PlayerService;

@RestController
@RequestMapping("/sport_season/player")
public class PlayerController {
	
	private PlayerService playerService;
	public PlayerController(PlayerService playerService) {
		this.playerService = playerService;
	}
	
	@GetMapping
	public List<Player> getAllPlayers(){
		return playerService.getAllPlayers();
	}
	
	@GetMapping("/{player_id}")
	public ResponseEntity<Player> getPlayerById(@PathVariable("player_id") Long playerId){
		return new ResponseEntity<Player>(playerService.getPlayerById(playerId), HttpStatus.OK);
	}
	

	@PostMapping
	public ResponseEntity<Player> savePlayer(@RequestBody Player player){
		return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.CREATED);
	}

	@PutMapping("/{player_id}")
	public ResponseEntity<Player> updatePlayer(@PathVariable("player_id") Long playerId, @RequestBody Player player){
		player.setPlayer_id(playerId);
		return new ResponseEntity<Player>(playerService.savePlayer(player), HttpStatus.OK);
	}
	
	@DeleteMapping("/{player_id}")
	public ResponseEntity<String> updatePlayer(@PathVariable("player_id") Long playerId){
		playerService.deletePlayer(playerId);
		return new ResponseEntity<String>("Player Deleted", HttpStatus.OK);
	}
}
