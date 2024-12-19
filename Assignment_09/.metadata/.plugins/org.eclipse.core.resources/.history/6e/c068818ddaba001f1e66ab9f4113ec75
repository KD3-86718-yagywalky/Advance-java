package com.cricket.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "players")
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class Players extends BaseEntity{
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "dob")
	private LocalDate dob;
	@Column(name = "batting_avg")
	private Double battingAvg; 
	@Column(name = "wickets_taken")
	private Integer wicketTaken;
	@ManyToOne
	@JoinColumn(name = "team_id")
	private Team team;
	
	public Players(String firstName, String lastName, LocalDate dob, Double battingAvg, Integer wicketTaken) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.battingAvg = battingAvg;
		this.wicketTaken = wicketTaken;
	}
	
	

}
