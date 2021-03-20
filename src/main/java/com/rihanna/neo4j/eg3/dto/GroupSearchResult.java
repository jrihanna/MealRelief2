package com.rihanna.neo4j.eg3.dto;

import java.util.List;
import java.util.Map;

public class GroupSearchResult {
	
	private Map<Integer, List<RecipeDTO>> recipesPerDay;

	public Map<Integer, List<RecipeDTO>> getRecipesPerDay() {
		return recipesPerDay;
	}

	public void setRecipesPerDay(Map<Integer, List<RecipeDTO>> recipesPerDay) {
		this.recipesPerDay = recipesPerDay;
	}

}
