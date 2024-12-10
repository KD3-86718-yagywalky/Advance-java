package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.Players;
import com.sunbeam.entities.Teams;

public interface PlayerDao {
	
	String addPlayer(Long teamid, Players player);
	String removePlayer(Long teamId, Long id);
	List<Players> displayAllPlayers(Long id);

}
