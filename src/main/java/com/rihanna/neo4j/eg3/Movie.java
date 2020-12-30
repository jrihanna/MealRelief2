package com.rihanna.neo4j.eg3;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@NodeEntity(label = "Movie")
public class Movie {

	@Id
	@GeneratedValue
	private Long id;
	private String title;

	@Relationship(type = "ACTED_IN", direction = "INCOMING")
	private Set<Actor> actors = new HashSet<>();

	@Relationship(type = "AWARD", direction = "INCOMING")
	private List<Award> awards = new ArrayList<>();

	public Movie() {
	}

	public Movie(String title) {
		this.title = title;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Actor> getActors() {
		return actors;
	}

	public void setActors(Set<Actor> actors) {
		this.actors = actors;
	}

	public List<Award> getAwards() {
		return awards;
	}

	public void setAwards(List<Award> awards) {
		this.awards = awards;
	}
	
	
}
