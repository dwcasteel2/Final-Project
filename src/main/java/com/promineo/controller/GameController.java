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

import com.promineo.model.Game;
import com.promineo.service.GameService;

@RestController
@RequestMapping("/sport_season/game")
public class GameController {
	
	private GameService gameService;
	public GameController(GameService gameService) {
		this.gameService = gameService;
	}
	
	@GetMapping
	public List<Game> getAllGames(){
		return gameService.getAllGames();
	}
	
	@GetMapping("/{game_id}")
	public ResponseEntity<Game> getGameById(@PathVariable ("game_id") Long gameId){
		return new ResponseEntity<Game>(gameService.getGameById(gameId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Game> saveGame(@RequestBody Game game){
		return new ResponseEntity<Game>(gameService.saveGame(game), HttpStatus.CREATED);
	}
	
	@PutMapping("/{game_id}")
	public ResponseEntity<Game>updateGame(@PathVariable("game_id") Long gameId, @RequestBody Game game){
		game.setGame_id(gameId);
		return new ResponseEntity<Game>(gameService.saveGame(game), HttpStatus.OK);
	}

	@DeleteMapping("/{game_id}")
	public ResponseEntity<String> updateGame(@PathVariable("game_id") Long gameId){
		gameService.deleteGame(gameId);
		return new ResponseEntity<String>("Game has been Deleted", HttpStatus.OK);
	}
}
