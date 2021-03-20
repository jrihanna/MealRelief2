package com.rihanna.neo4j.eg3.dto;

public class NutritionalValueDTO {

	private Integer calory;
	private Integer carbs;
	private Integer fat;
	private Integer protein;
	
	public NutritionalValueDTO() {	}

	
	public NutritionalValueDTO(Integer calory, Integer carbs, Integer fat, Integer protein) {
		super();
		this.calory = calory;
		this.carbs = carbs;
		this.fat = fat;
		this.protein = protein;
	}

	public void addValues(Integer calory, Integer carbs, Integer fat, Integer protein) {
		this.calory += calory;
		this.carbs += carbs;
		this.fat += fat;
		this.protein += protein;
	}
	
	public Integer getCalory() {
		return calory == null ? 0 : calory;
	}
	public void setCalory(Integer calory) {
		this.calory = calory;
	}
	public Integer getCarbs() {
		return carbs == null ? 0 : carbs;
	}
	public void setCarbs(Integer carbs) {
		this.carbs = carbs;
	}
	public Integer getFat() {
		return fat == null ? 0 : fat;
	}
	public void setFat(Integer fat) {
		this.fat = fat;
	}
	public Integer getProtein() {
		return protein == null ? 0 : protein;
	}
	public void setProtein(Integer protein) {
		this.protein = protein;
	}
}
