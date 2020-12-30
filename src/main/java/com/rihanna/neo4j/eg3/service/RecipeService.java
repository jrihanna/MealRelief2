package com.rihanna.neo4j.eg3.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.Actor;
import com.rihanna.neo4j.eg3.Award;
import com.rihanna.neo4j.eg3.AwardRepository;
import com.rihanna.neo4j.eg3.Movie;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.repository.IngredientQuantityRepository;
import com.rihanna.neo4j.eg3.repository.RecipeRepository;

@Service
public class RecipeService {

	@Autowired
	AwardRepository awardRepository;
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	IngredientQuantityRepository ingredientQuantityRepository;
	
    public Collection<Recipe> getAllRecipes() {
    	return recipeRepository.getAllRecipes();
    }
    
    public void addNewRecipe(Recipe recipe) {
    	
//    	Actor daniel  = new Actor("Daniel Radcliffe");
//    	Movie goblet = new Movie("Harry Potter and the Goblet of Fire");
//    	Movie phoenix = new Movie("Harry Potter and the Order of the Phoenix");
//    	daniel.actedIn(goblet);
//    	daniel.actedIn(phoenix);
//
//    	Award national = new Award(daniel,phoenix,"National Movie Awards, UK",2007);
//    	awardRepository.save(national);
    	
    	
    	ingredientQuantityRepository.saveAll(recipe.getIngredients());
    	recipeRepository.save(recipe);
    }
}
