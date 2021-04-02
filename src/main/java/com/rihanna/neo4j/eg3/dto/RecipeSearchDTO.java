package com.rihanna.neo4j.eg3.dto;

import java.util.List;
import java.util.Set;

public class RecipeSearchDTO {

	private String name;
	private String instructions;

	private Set<TagDTO> tags;
	private String category;
	
	private List<IngredientDTO> includedIngredients;
	private List<IngredientDTO> excludedIngredients;
	private NutritionalValueDTO minNutritionalValues;
	private NutritionalValueDTO maxNutritionalValues;
	private int limit;

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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public NutritionalValueDTO getMinNutritionalValues() {
		return minNutritionalValues;
	}

	public void setMinNutritionalValues(NutritionalValueDTO minNutritionalValues) {
		this.minNutritionalValues = minNutritionalValues;
	}

	public NutritionalValueDTO getMaxNutritionalValues() {
		return maxNutritionalValues;
	}

	public void setMaxNutritionalValues(NutritionalValueDTO maxNutritionalValues) {
		this.maxNutritionalValues = maxNutritionalValues;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
