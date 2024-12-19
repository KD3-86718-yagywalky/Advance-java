package com.cricket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cricket.dto.PlayerReqDTO;
import com.cricket.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	private PlayerService playerService;

	public PlayerController() {
		System.out.println("Yes Bro finally i am in team ");
	}

	@PostMapping
	public ResponseEntity<?> addMember(@RequestBody PlayerReqDTO player) {
		System.out.println("Yeah i am going to add new player");
		return ResponseEntity.status(HttpStatus.CREATED).body(playerService.addPlayer(player));
	}

	@GetMapping
	public ResponseEntity<?> displaymember() {
		System.out.println("dikhao bhai");
		return ResponseEntity.ok(playerService.getAllPlayer());
	}

}
