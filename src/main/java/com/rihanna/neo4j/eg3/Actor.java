package com.rihanna.neo4j.eg3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@NodeEntity(label = "Actor")
public class Actor {

	@Id
	@GeneratedValue
	private Long id;
	private String name;

	@Relationship(type = "ACTED_IN")
	private Set<Movie> actedIn = new HashSet<>();
	
	@Relationship(type = "AWARD")
	private Map<Movie, Award> awards;

	public Actor() {
	}

	public Actor(String name) {
		this.name = name;
	}
	
	public void actedIn(Movie movie) {
		actedIn.add(movie);
		movie.getActors().add(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Movie> getActedIn() {
		return actedIn;
	}

	public void setActedIn(Set<Movie> actedIn) {
		this.actedIn = actedIn;
	}

	public Map<Movie, Award> getAwards() {
		return awards;
	}

	public void setAwards(Map<Movie, Award> awards) {
		this.awards = awards;
	}


}
