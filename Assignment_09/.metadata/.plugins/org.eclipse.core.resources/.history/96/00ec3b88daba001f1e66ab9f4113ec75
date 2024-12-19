package com.cricket.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cricket.dao.PlayerDao;
import com.cricket.dto.ApiResponce;
import com.cricket.dto.PlayerReqDTO;
import com.cricket.dto.PlayerRespDTO;
import com.cricket.pojos.Players;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PlayerServiceImpl implements PlayerService{
	
	@Autowired
	private PlayerDao playerDao;
	
	@Autowired
	private ModelMapper modelMapper;
	
	

	public PlayerServiceImpl() {

	}

	@Override
	public ApiResponce addPlayer(PlayerReqDTO player) {
		
		Players p1 = modelMapper.map(player, Players.class);
		Players p = playerDao.save(p1);
		return new ApiResponce("Congratulation you are selected for this team "+p.getFirstName()+" "+p.getLastName());
	}

	@Override
	public List<PlayerRespDTO> getAllPlayer() {
			
		return playerDao.findAll().stream().map(play -> modelMapper.map(play, PlayerRespDTO.class)).collect(Collectors.toList());
	}

}
