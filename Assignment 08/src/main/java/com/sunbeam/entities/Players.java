package com.sunbeam.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "players")
@NoArgsConstructor
@Getter
@Setter
@ToString (exclude = "team")
public class Players extends BaseEntities{
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "batting_avg")
	private double battingAvg;
	@Column(name = "wicket_taken")
	private int wicketsTaken;
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Teams team;
	public Players(String firstName, String lastName, LocalDate dob, double battingAvg, int wicketsTaken
		) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketsTaken = wicketsTaken;

	}
	
	

}
