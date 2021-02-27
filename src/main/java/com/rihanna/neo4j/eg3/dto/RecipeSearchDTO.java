package com.rihanna.neo4j.eg3.dto;

import java.util.List;
import java.util.Set;

import com.rihanna.neo4j.eg3.enumeration.CategoryEnum;

public class RecipeSearchDTO {

	private String name;
	private String instructions;
	
	private List<IngredientDTO> includedIngredients;
	private List<IngredientDTO> excludedIngredients;
	
	private Set<TagDTO> tags;
	
	private CategoryEnum category;

	public List<IngredientDTO> getIncludedIngredients() {
		return includedIngredients;
	}

	public void setIncludedIngredients(List<IngredientDTO> includedIngredients) {
		this.includedIngredients = includedIngredients;
	}

	public List<IngredientDTO> getExcludedIngredients() {
		return excludedIngredients;
	}

	public void setExcludedIngredients(List<IngredientDTO> excludedIngredients) {
		this.excludedIngredients = excludedIngredients;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public Set<TagDTO> getTags() {
		return tags;
	}

	public void setTags(Set<TagDTO> tags) {
		this.tags = tags;
	}

	public CategoryEnum getCategory() {
		return category;
	}

	public void setCategory(CategoryEnum category) {
		this.category = category;
	}
}
