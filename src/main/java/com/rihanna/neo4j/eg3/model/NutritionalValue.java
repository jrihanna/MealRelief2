package com.rihanna.neo4j.eg3.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@NodeEntity
public class NutritionalValue {

	@Id
	@GeneratedValue
	private Long id;
	private Float calory;
	private Float carbs;
	private Float fat;
	private Float protein;
	
	public NutritionalValue() {}
	
	public NutritionalValue(Float calory, Float carbs, Float fat, Float protein) {
		super();
		this.calory = calory;
		this.carbs = carbs;
		this.fat = fat;
		this.protein = protein;
	}

	public void addValues(Float calory, Float carbs, Float fat, Float protein) {
		this.calory += calory;
		this.carbs += carbs;
		this.fat += fat;
		this.protein += protein;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Float getCalory() {
		return calory;
	}
	public void setCalory(Float calory) {
		this.calory = calory;
	}
	public Float getCarbs() {
		return carbs;
	}
	public void setCarbs(Float carbs) {
		this.carbs = carbs;
	}
	public Float getFat() {
		return fat;
	}
	public void setFat(Float fat) {
		this.fat = fat;
	}
	public Float getProtein() {
		return protein;
	}
	public void setProtein(Float protein) {
		this.protein = protein;
	}
}
