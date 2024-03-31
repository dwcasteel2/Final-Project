package com.promineo.service;

import java.util.List;

import com.promineo.model.Player;

public interface PlayerService {

	
	//READ
	public List<Player> getAllPlayers();
	
	//READ by Player ID
	public Player getPlayerById(Long id);
	
	//CREATE Player
	public Player savePlayer(Player player);
	
	//UPDATE Player
	public Player updatePlayer(Player player, Long id);
	
	//DELETE Player
	public void deletePlayer(Long id);

}
