package com.rihanna.neo4j.eg3;

import java.util.HashMap;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class Award {
	@Id
	@GeneratedValue
	private Long id;

	@TargetNode
	@StartNode Actor actor;
	@EndNode Movie movie;

	private String award;
	private int year;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public String getAward() {
		return award;
	}

	public void setAward(String award) {
		this.award = award;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Award() {
	}

	public Award(Actor actor, Movie movie, String award, int year) {
		this.actor = actor;
		this.movie = movie;
		this.award = award;
		this.year = year;

//		if(this.actor.getAwards() == null)
//			this.actor.setAwards(new HashMap<>());
//		
//		this.actor.getAwards().put(this.movie, this);
		this.movie.getAwards().add(this);
	}

}
