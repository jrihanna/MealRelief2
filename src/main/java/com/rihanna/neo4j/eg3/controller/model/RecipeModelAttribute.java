package com.rihanna.neo4j.eg3.controller.model;

import java.util.List;

public class RecipeModelAttribute {
	
	private String recipeName;
	private String category;
	private List<String> includedIngredients;
	private List<String> excludedIngredients;
	private List<String> tags;
	private Integer minCalory;
	private Integer maxCalory;
	private Integer minCarb;
	private Integer maxCarb;
	private Integer minFat;
	private Integer maxFat;
	private Integer minProtein;
	private Integer maxProtein;
	
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
	public Integer getMinCalory() {
		return minCalory == null ? 0 : minCalory;
	}
	public void setMinCalory(Integer minCalory) {
		this.minCalory = minCalory;
	}
	public Integer getMaxCalory() {
		return maxCalory == null ? 0 : maxCalory;
	}
	public void setMaxCalory(Integer maxCalory) {
		this.maxCalory = maxCalory;
	}
	public Integer getMinCarb() {
		return minCarb == null ? 0 : minCarb;
	}
	public void setMinCarb(Integer minCarb) {
		this.minCarb = minCarb;
	}
	public Integer getMaxCarb() {
		return maxCarb == null ? 0 : maxCarb;
	}
	public void setMaxCarb(Integer maxCarb) {
		this.maxCarb = maxCarb;
	}
	public Integer getMinFat() {
		return minFat == null ? 0 : minFat;
	}
	public void setMinFat(Integer minFat) {
		this.minFat = minFat;
	}
	public Integer getMaxFat() {
		return maxFat == null ? 0 : maxFat;
	}
	public void setMaxFat(Integer maxFat) {
		this.maxFat = maxFat;
	}
	public Integer getMinProtein() {
		return minProtein == null ? 0 : minProtein;
	}
	public void setMinProtein(Integer minProtein) {
		this.minProtein = minProtein;
	}
	public Integer getMaxProtein() {
		return maxProtein == null ? 0 : maxProtein;
	}
	public void setMaxProtein(Integer maxProtein) {
		this.maxProtein = maxProtein;
	}
	
	

}
