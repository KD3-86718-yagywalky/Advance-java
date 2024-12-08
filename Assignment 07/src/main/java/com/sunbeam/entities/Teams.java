package com.sunbeam.entities;

import javax.persistence.*;


@Entity
@Table(name = "teams")
public class Teams {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="team_id")
	private long teamId;
	@Column(length = 100, unique=true)
	private String name;
	@Column(length = 10, unique=true)
	private String abbreviation;
	@Column(length = 10, nullable = false)
	private String owner;
	@Column(name="max_player_age")
	private int maxPlayerAge;
	@Column(name="batting_avg")
	private double battingAvg;
	@Column(name="wickets_taken")
	private int wicketTaken;
	
//	team_id bigint primary key auto_increment,name varchar(100) unique ,abbreviation varchar(10)
//	unique,owner varchar(20) not null,max_player_age int,
//	batting_avg double,wickets_taken int)
	
	public Teams() {
	
	}
	
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

	public long getTeamId() {
		return teamId;
	}

	public void setTeamId(long teamId) {
		this.teamId = teamId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAbbreviation() {
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getMaxPlayerAge() {
		return maxPlayerAge;
	}

	public void setMaxPlayerAge(int max_player_age) {
		this.maxPlayerAge = max_player_age;
	}

	public double getBattingAvg() {
		return battingAvg;
	}

	public void setBattingAvg(double battingAvg) {
		this.battingAvg = battingAvg;
	}

	public int getWicketTaken() {
		return wicketTaken;
	}

	public void setWicketTaken(int wicketTaken) {
		this.wicketTaken = wicketTaken;
	}

	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", name=" + name + ", abbreviation=" + abbreviation + ", owner=" + owner
				+ ", maxPlayerAge=" + maxPlayerAge + ", battingAvg=" + battingAvg + ", wicketTaken=" + wicketTaken
				+ "]";
	}
	

}

