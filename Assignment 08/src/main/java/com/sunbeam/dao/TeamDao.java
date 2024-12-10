package com.sunbeam.dao;

import java.util.List;

import com.sunbeam.entities.*;

public interface TeamDao {
	
	String signUpTeam(Teams team);
	List<Teams> getAllTeams();
	List<Teams> getAllTeamsMaxAvgAge(Integer maxPlayerAge , Double battingAvg );
	List<Teams> getOwnerAndAbbreviation(Integer maxPlayerAge , Double battingAvg );
	Teams updateMaxAge(Integer age, String name);
	String deleteTeam(Long id);
	Teams getAllPlayerByTeam(Long teamid);
}
