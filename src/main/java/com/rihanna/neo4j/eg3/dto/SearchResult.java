package com.rihanna.neo4j.eg3.dto;

import java.util.Collection;

import com.rihanna.neo4j.eg3.model.Recipe;


public class SearchResult {
	
	private Collection<Recipe> recipes;
	private Long total;
	public Collection<Recipe> getRecipes() {
		return recipes;
	}
	public void setRecipes(Collection<Recipe> recipes) {
		this.recipes = recipes;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}

	
}
