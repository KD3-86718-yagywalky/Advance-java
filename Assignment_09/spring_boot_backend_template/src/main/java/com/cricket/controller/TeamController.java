package com.cricket.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.dto.TeamReqDTO;
import com.cricket.dto.TeamRespDTO;
import com.cricket.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;

	public TeamController() {
		System.out.println("Everything is okk " +getClass());
	}
	
	
	@PostMapping
	public ResponseEntity<?> addTeam(@RequestBody TeamReqDTO team){
		
		System.out.println("in the add team " +team.getOwner());
		return ResponseEntity.status(HttpStatus.CREATED).body(teamService.addTeam(team));
		}
	
	@GetMapping
	public ResponseEntity<?> getEntity(){
		
		List<TeamRespDTO> t1 = teamService.getAllTeam();
		if(t1.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(t1);
		
	}
	
		

}
