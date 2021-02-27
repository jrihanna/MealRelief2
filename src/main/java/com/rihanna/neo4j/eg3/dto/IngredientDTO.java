package com.rihanna.neo4j.eg3.dto;

import com.rihanna.neo4j.eg3.model.NutritionalValue;

public class IngredientDTO {

	private Long id;

	private String name;

	private NutritionalValue nutritionalValue;
	private int perQuantity;
	
	public IngredientDTO(String name) {
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

	public int getPerQuantity() {
		return perQuantity;
	}

	public void setPerQuantity(int perQuantity) {
		this.perQuantity = perQuantity;
	}

}
