package com.rihanna.neo4j.eg3.model;

import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.Id;

import com.rihanna.neo4j.eg3.enumeration.TagEnum;

@NodeEntity
public class Tag {
	
	@Id
	@Index(unique=true, primary=true)
	private TagEnum name;
	
	public TagEnum getName() {
		return name;
	}
	public void setName(TagEnum name) {
		this.name = name;
	}
	
}
