package com.promineo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.promineo.exception.RespurceNotFoundExcption;
import com.promineo.model.Player;
import com.promineo.repository.PlayerRepostiory;

@Service
public class PlayerServuceImpl implements PlayerService{

	private PlayerRepostiory playerRepostiory;
	public PlayerServuceImpl(PlayerRepostiory playerRepostiory) {
		this.playerRepostiory = playerRepostiory;
	}
	
	
	@Override
	public List<Player> getAllPlayers() {
		return playerRepostiory.findAll();
	}

	@Override
	public Player getPlayerById(Long id) {
		return playerRepostiory.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Player", "ID", id));
	}

	@Override
	public Player savePlayer(Player player) {
		return playerRepostiory.save(player);
	}

	@Override
	public Player updatePlayer(Player player, Long id) {
		Player existingPlayer = playerRepostiory.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Player", "ID", id));
		existingPlayer.setTeam_id(player.getTeam_id());
		existingPlayer.setFirst_name(player.getFirst_name());
		existingPlayer.setLast_name(player.getLast_name());
		existingPlayer.setAge(player.getAge());
			return existingPlayer;
	}

	@Override
	public void deletePlayer(Long id) {
		Player existingPlayer = playerRepostiory.findById(id).orElseThrow(() -> new RespurceNotFoundExcption("Player", "ID", id));
		playerRepostiory.deleteById(id);
	}



}
