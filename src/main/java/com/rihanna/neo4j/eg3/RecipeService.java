package com.rihanna.neo4j.eg3;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	RecipeRepository recipeRepository;
	
    public Collection<Recipe> getAllRecipes() {
    	return recipeRepository.getAllRecipes();
    }
    
    public void addNewRecipe(Recipe recipe) {
    	recipeRepository.save(recipe);
    }
}
