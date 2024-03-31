package com.promineo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineo.exception.RespurceNotFoundExcption;
import com.promineo.model.Game;
import com.promineo.repository.GameRepository;

@Service
public class GameServiceImpl implements GameService{
	
	private GameRepository gameRepository;
	public GameServiceImpl(GameRepository gameRepository) {
		this.gameRepository = gameRepository;
	}
	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}
	@Override
	public Game getGameById(Long id) {
		return gameRepository.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Game", "Id", id));
	}
	@Override
	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}
	@Override
	public Game updateGame(Game game, Long id) {
		Game existingGame = gameRepository.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Game", "Id", id));
		existingGame.setHome_team(game.getHome_team());
		existingGame.setAway_team(game.getAway_team());
		existingGame.setLocation(game.getLocation());
		existingGame.setHome_score(game.getHome_score());
		existingGame.setAway_score(game.getAway_score());
		return existingGame;
	}
	@Override
	public void deleteGame(Long id) {
		Game existingGame = gameRepository.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Game", "Id", id));
		gameRepository.deleteById(id);
	}
	

}
