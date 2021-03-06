package com.rihanna.neo4j.eg3.controller.model;

import java.util.List;

public class RecipeModelAttribute {
	
	private String recipeName;
	private String category;
	private List<String> includedIngredients;
	private List<String> excludedIngredients;
	private List<String> tags;
	public String getRecipeName() {
		return recipeName;
	}
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public List<String> getIncludedIngredients() {
		return includedIngredients;
	}
	public void setIncludedIngredients(List<String> includedIngredients) {
		this.includedIngredients = includedIngredients;
	}
	public List<String> getExcludedIngredients() {
		return excludedIngredients;
	}
	public void setExcludedIngredients(List<String> excludedIngredients) {
		this.excludedIngredients = excludedIngredients;
	}
	public List<String> getTags() {
		return tags;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}
	
	

}
