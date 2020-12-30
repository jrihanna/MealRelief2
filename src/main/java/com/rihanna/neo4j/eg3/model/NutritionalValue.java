package com.rihanna.neo4j.eg3.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@NodeEntity
public class NutritionalValue {

	@Id
	@GeneratedValue
	private Long id;
	private float calory;
	private float carbs;
	private float fat;
	private float protein;
	
	public void addValues(float calory, float carbs, float fat, float protein) {
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
	public float getCalory() {
		return calory;
	}
	public void setCalory(float calory) {
		this.calory = calory;
	}
	public float getCarbs() {
		return carbs;
	}
	public void setCarbs(float carbs) {
		this.carbs = carbs;
	}
	public float getFat() {
		return fat;
	}
	public void setFat(float fat) {
		this.fat = fat;
	}
	public float getProtein() {
		return protein;
	}
	public void setProtein(float protein) {
		this.protein = protein;
	}
}
