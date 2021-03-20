package com.rihanna.neo4j.eg3.util;

import java.util.ArrayList;
import java.util.HashSet;

import com.rihanna.neo4j.eg3.dto.IngredientQuantityDTO;
import com.rihanna.neo4j.eg3.dto.NutritionalValueDTO;
import com.rihanna.neo4j.eg3.dto.RecipeDTO;
import com.rihanna.neo4j.eg3.dto.TagDTO;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.NutritionalValue;
import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.model.Tag;

public class RecipeModelConverter {
	
	public static RecipeDTO convertEntityToDTO(Recipe recipe) {
		RecipeDTO result = new RecipeDTO();
		result.setIconSrc(recipe.getIconSrc());
		result.setId(recipe.getId());
		result.setInstructions(recipe.getInstructions());
		
		if(recipe.getIngredients() != null) {
	    	result.setIngredients(new ArrayList<>());
	    	for(IngredientQuantity ing : recipe.getIngredients()) 
	    		result.getIngredients().add(new IngredientQuantityDTO(ing.getIngredient().getName(), 
	    				ing.getQuantity().intValue(), ing.getMeasurementType()));
    	}
		
		if(recipe.getNutritionalValue() != null) {
			NutritionalValue nut = recipe.getNutritionalValue();
			result.setNutritionalValue(new NutritionalValueDTO(nut.getCalory(), nut.getCarbs(), nut.getFat(), nut.getProtein()));
		}
		
		if(recipe.getTags() != null) {
			result.setTags(new HashSet<>());
			for(Tag t : recipe.getTags())
				result.getTags().add(new TagDTO(t.getName()));
		}
		
		if(recipe.getCategory() != null) 
			result.setCategory(new String[] {recipe.getCategory()});
		
		return result;
	}

}
