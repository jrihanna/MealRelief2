package com.rihanna.neo4j.eg3.model;

import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@NodeEntity
public class Ingredient {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Index(unique=true)
	private String name;

	@Relationship(type = "nutritions", direction = Relationship.UNDIRECTED)
	private NutritionalValue nutritionalValue;	
	private Integer perQuantity;
	private String measurement;
	private String category;
	
	public Ingredient() {}

	public Ingredient(String name) {
		super();
		this.name = name;
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

	public NutritionalValue getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(NutritionalValue nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}

	public Integer getPerQuantity() {
		return perQuantity;
	}

	public void setPerQuantity(Integer perQuantity) {
		this.perQuantity = perQuantity;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMeasurement() {
		return measurement;
	}

	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
}
