package com.rihanna.neo4j.eg3.controller.model;

import java.util.List;

public class RecipeModelAttribute {
	
	private String recipeName;
	private String category;
	private List<String> includedIngredients;
	private List<String> excludedIngredients;
	private List<String> tags;
	private Float minCalory;
	private Float maxCalory;
	private Float minCarb;
	private Float maxCarb;
	private Float minFat;
	private Float maxFat;
	private Float minProtein;
	private Float maxProtein;
	
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
	public Float getMinCalory() {
		return minCalory == null ? 0 : minCalory;
	}
	public void setMinCalory(Float minCalory) {
		this.minCalory = minCalory;
	}
	public Float getMaxCalory() {
		return maxCalory == null ? 0 : maxCalory;
	}
	public void setMaxCalory(Float maxCalory) {
		this.maxCalory = maxCalory;
	}
	public Float getMinCarb() {
		return minCarb == null ? 0 : minCarb;
	}
	public void setMinCarb(Float minCarb) {
		this.minCarb = minCarb;
	}
	public Float getMaxCarb() {
		return maxCarb == null ? 0 : maxCarb;
	}
	public void setMaxCarb(Float maxCarb) {
		this.maxCarb = maxCarb;
	}
	public Float getMinFat() {
		return minFat == null ? 0 : minFat;
	}
	public void setMinFat(Float minFat) {
		this.minFat = minFat;
	}
	public Float getMaxFat() {
		return maxFat == null ? 0 : maxFat;
	}
	public void setMaxFat(Float maxFat) {
		this.maxFat = maxFat;
	}
	public Float getMinProtein() {
		return minProtein == null ? 0 : minProtein;
	}
	public void setMinProtein(Float minProtein) {
		this.minProtein = minProtein;
	}
	public Float getMaxProtein() {
		return maxProtein == null ? 0 : maxProtein;
	}
	public void setMaxProtein(Float maxProtein) {
		this.maxProtein = maxProtein;
	}
	
	

}
