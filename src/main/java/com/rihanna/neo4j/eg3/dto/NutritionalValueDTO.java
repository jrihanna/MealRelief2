package com.rihanna.neo4j.eg3.dto;

public class NutritionalValueDTO {

	private Float calory;
	private Float carbs;
	private Float fat;
	private Float protein;
	
	public NutritionalValueDTO() {	}

	
	public NutritionalValueDTO(Float calory, Float carbs, Float fat, Float protein) {
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
	
	public Float getCalory() {
		return calory == null ? 0 : calory;
	}
	public void setCalory(Float calory) {
		this.calory = calory;
	}
	public Float getCarbs() {
		return carbs == null ? 0 : carbs;
	}
	public void setCarbs(Float carbs) {
		this.carbs = carbs;
	}
	public Float getFat() {
		return fat == null ? 0 : fat;
	}
	public void setFat(Float fat) {
		this.fat = fat;
	}
	public Float getProtein() {
		return protein == null ? 0 : protein;
	}
	public void setProtein(Float protein) {
		this.protein = protein;
	}
}
