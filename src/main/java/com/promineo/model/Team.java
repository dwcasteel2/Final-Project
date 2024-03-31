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
@Table(name="team")
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long team_id;
	
	@Column(value="team_name")
	private String team_name;
	@Column(value="team_mascot")
	private String team_mascot;
	@Column(value="city")
	private String city;
	@Column(value="state")
	private String state;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name="games_played", 
	joinColumns = @JoinColumn(name="game_id"), inverseJoinColumns = @JoinColumn(name="team_id"))
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Set<Team> team = new HashSet<>();
}
