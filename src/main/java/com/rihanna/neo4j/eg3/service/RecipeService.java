package com.rihanna.neo4j.eg3.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.repository.RecipeRepository;

@Service
public class RecipeService {

	/*
	 * @Autowired AwardRepository awardRepository;
	 */	
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@Autowired
	NutritionCalculatorService nutritionCalculatorService;
	
	@Autowired
	IngredientService ingredientService;
	
    public Collection<Recipe> getAllRecipes() {
    	return recipeRepository.getAllRecipes();
    }
    
    public void saveOrUpdateRecipe(Recipe recipe) {
    	recipe.setIngredients(loadIngredients(recipe));
    	recipe.setNutritionalValue(nutritionCalculatorService.calculateNutritionsForRecipe(recipe));
    	recipeRepository.save(recipe);
    	
    }
    
    private List<IngredientQuantity> loadIngredients(Recipe recipe) {
    	
    	List<IngredientQuantity> newIngre = new ArrayList<IngredientQuantity>();
    	
    	recipe.getIngredients().stream().forEach(ingQuan -> {
    		Ingredient ing = ingredientService.loadIngredient(ingQuan.getIngredient());
			ingQuan.setIngredient(ing);
			newIngre.add(ingQuan);
    	});
		
		/*
		 * for(IngredientQuantity ingQuan : recipe.getIngredients()) { Ingredient ing =
		 * ingredientService.loadIngredient(ingQuan.getIngredient());
		 * 
		 * ingQuan.setIngredient(ing); newIngre.add(ingQuan); }
		 */
    	
    	return newIngre;
    }
    

	/*
	 * Actor daniel = new Actor("Daniel Radcliffe"); Movie goblet = new
	 * Movie("Harry Potter and the Goblet of Fire"); Movie phoenix = new
	 * Movie("Harry Potter and the Order of the Phoenix"); daniel.actedIn(goblet);
	 * daniel.actedIn(phoenix);
	 * 
	 * Award national = new Award(daniel,phoenix,"National Movie Awards, UK",2007);
	 * awardRepository.save(national);
	 * 
	 * ingredientQuantityRepository.saveAll(recipe.getIngredients());
	 */
}
