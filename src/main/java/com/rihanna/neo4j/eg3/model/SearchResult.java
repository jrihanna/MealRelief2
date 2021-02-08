package com.rihanna.neo4j.eg3.model;

import java.util.Collection;
import java.util.List;


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
