package com.promineo.model;

import org.springframework.data.relational.core.mapping.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="player")
public class Player {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long player_id;
	
	@Column(value="team_id")
	private Long team_id;
	
	@Column(value="first_name")
	private String first_name;
	@Column(value="last_name")
	private String last_name;
	@Column(value="age")
	private int age;
}
