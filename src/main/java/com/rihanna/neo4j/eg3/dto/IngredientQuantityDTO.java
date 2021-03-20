package com.rihanna.neo4j.eg3.dto;

public class IngredientQuantityDTO {
	
	private String ingredientName;
	private float ingredientAmount;
	private String measurement;
	
	public IngredientQuantityDTO() {}
	
	public IngredientQuantityDTO(String ingredientName, float ingredientAmount, String measurement) {
		super();
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.measurement = measurement;
	}
	
	public String getIngredientName() {
		return ingredientName;
	}
	public void setIngredientName(String ingredientName) {
		this.ingredientName = ingredientName;
	}
	public float getIngredientAmount() {
		return ingredientAmount;
	}
	public void setIngredientAmount(float ingredientAmount) {
		this.ingredientAmount = ingredientAmount;
	}
	public String getMeasurement() {
		return measurement;
	}
	public void setMeasurement(String measurement) {
		this.measurement = measurement;
	}
	

}
