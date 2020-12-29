package com.rihanna.neo4j.eg3.model;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import com.rihanna.neo4j.eg3.enumeration.TagEnum;

@NodeEntity
public class Tag {

	@Id
	@GeneratedValue
	@GraphId
	private Long id;
	private TagEnum name;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TagEnum getName() {
		return name;
	}
	public void setName(TagEnum name) {
		this.name = name;
	}
	
}
