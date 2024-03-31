package com.promineo.service;

import java.util.List;

import com.promineo.model.Game;

public interface GameService {
	
	//READ
	public List<Game> getAllGames();
	
	//READ by Game ID
	public Game getGameById(Long id);
	
	//CREATE
	public Game saveGame(Game game);
	
	//UPDATE
	public Game updateGame(Game game, Long id);
	
	//DELETE Game
	public void deleteGame(Long id);
	

}
