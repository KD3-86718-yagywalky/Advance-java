package com.sunbeam.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "teams")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude = "player")

public class Teams extends BaseEntities{
	
	@Column(length = 100, unique=true)
	private String name;
	@Column(length = 10, unique=true)
	private String abbreviation;
	@Column(length = 100, nullable = false)
	private String owner;
	@Column(name="max_player_age")
	private int maxPlayerAge;
	@Column(name="batting_avg")
	private double battingAvg;
	@Column(name="wickets_taken")
	private int wicketTaken;
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	List<Players> player = new ArrayList<Players>();
	
//	team_id bigint primary key auto_increment,name varchar(100) unique ,abbreviation varchar(10)
//	unique,owner varchar(20) not null,max_player_age int,
//	batting_avg double,wickets_taken int)
	
	
	public Teams(String name, String abbreviation, String owner, int max_player_age, double batting_avg,
			int wicket_taken) {
		super();
		this.name = name;
		this.abbreviation = abbreviation;
		this.owner = owner;
		this.maxPlayerAge = max_player_age;
		this.battingAvg = batting_avg;
		this.wicketTaken = wicket_taken;
	}
	
	

	public Teams( String owner,String abbreviation) {
		super();
		this.owner = owner;
		this.abbreviation = abbreviation;
	}

	public void addPlayerInTeam(Players play) {
		
		this.player.add(play);
		play.setTeam(this);
	}
	
	public void deletePlayerFromTeam(Players play) {
		this.player.remove(play);
		play.setTeam(null);
	}

}

