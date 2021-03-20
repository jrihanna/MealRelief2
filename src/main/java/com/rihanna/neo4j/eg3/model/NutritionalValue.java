package com.rihanna.neo4j.eg3.model;

import org.neo4j.ogm.annotation.NodeEntity;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

@NodeEntity
public class NutritionalValue {

	@Id
	@GeneratedValue
	private Long id;
	private Integer calory;
	private Integer carbs;
	private Integer fat;
	private Integer protein;
	
	public void addValues(Integer calory, Integer carbs, Integer fat, Integer protein) {
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
	public Integer getCalory() {
		return calory;
	}
	public void setCalory(Integer calory) {
		this.calory = calory;
	}
	public Integer getCarbs() {
		return carbs;
	}
	public void setCarbs(Integer carbs) {
		this.carbs = carbs;
	}
	public Integer getFat() {
		return fat;
	}
	public void setFat(Integer fat) {
		this.fat = fat;
	}
	public Integer getProtein() {
		return protein;
	}
	public void setProtein(Integer protein) {
		this.protein = protein;
	}
}
