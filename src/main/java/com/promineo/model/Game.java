package com.promineo.model;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.relational.core.mapping.Column;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@Entity
@Table(name="game")
public class Game {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long game_id;
	
	@Column(value="home_team")
	private String home_team;
	@Column(value="away_team")
	private String away_team;
	@Column(value="location")
	private String location;
	@Column(value="home_score")
	private Long home_score;
	@Column(value = "away_score")
	private Long away_score;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="games_played", 
	joinColumns = @JoinColumn(name="game_id"), inverseJoinColumns = @JoinColumn(name="team_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Team> team = new HashSet<>();
}
