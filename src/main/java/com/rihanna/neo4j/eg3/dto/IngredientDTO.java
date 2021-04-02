package com.rihanna.neo4j.eg3.dto;

import com.rihanna.neo4j.eg3.model.NutritionalValue;

public class IngredientDTO {

	private Long id;

	private String name;

	private NutritionalValueDTO nutritionalValue;
//	private int perQuantity;
	private String measurement;
	private String category;
	
	public IngredientDTO() {
	}
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

	public NutritionalValueDTO getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(NutritionalValueDTO nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}

	public String getMeasurement() {
		return measurement;
	}
	
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
