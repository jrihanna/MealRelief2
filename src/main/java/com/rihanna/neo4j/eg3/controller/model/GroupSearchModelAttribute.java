package com.rihanna.neo4j.eg3.controller.model;

import java.util.List;
import java.util.Map;

public class GroupSearchModelAttribute {

	private Map<Integer, List<Long>> recipePerDay;

	public Map<Integer, List<Long>> getRecipePerDay() {
		return recipePerDay;
	}

	public void setRecipePerDay(Map<Integer, List<Long>> recipePerDay) {
		this.recipePerDay = recipePerDay;
	}
}
