package com.rihanna.neo4j.eg3.dto;

import java.util.List;
import java.util.Set;

public class RecipeDTO {
	
	private Long id;
	
	private String recipeName;
	private String instructions;
	private String iconSrc;
	
	private List<IngredientQuantityDTO> ingredients;
	
	private Set<TagDTO> tags;
	
	private String[] category;
	
	private NutritionalValueDTO nutritionalValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public String getIconSrc() {
		return iconSrc;
	}

	public void setIconSrc(String iconSrc) {
		this.iconSrc = iconSrc;
	}

	public List<IngredientQuantityDTO> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientQuantityDTO> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<TagDTO> getTags() {
		return tags;
	}

	public void setTags(Set<TagDTO> tags) {
		this.tags = tags;
	}

	public String[] getCategory() {
		return category;
	}

	public void setCategory(String[] category) {
		this.category = category;
	}

	public NutritionalValueDTO getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(NutritionalValueDTO nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}
	
}
