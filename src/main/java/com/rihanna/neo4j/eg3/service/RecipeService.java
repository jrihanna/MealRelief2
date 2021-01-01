package com.rihanna.neo4j.eg3.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.model.Tag;
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
    
    public List<Recipe> searchRecipe(Recipe recipe) {
    	return recipeRepository.findAll(Example.of(recipe));
    }
    
    public void tagRecipe(Tag tag, Long id) {
    	Optional<Recipe> recOp = recipeRepository.findById(id);
    	recOp.ifPresent(rec -> {
    		rec.getTags().add(tag);
    		recipeRepository.save(rec);
    	});
    }
    
    public void untagRecipe(Tag tag, Long id) {
    	Optional<Recipe> recOp = recipeRepository.findById(id);
    	recOp.ifPresent(rec -> {
    		rec.getTags().remove(tag);
    		recipeRepository.save(rec);
    	});
    }
    
    private List<IngredientQuantity> loadIngredients(Recipe recipe) {
    	
    	List<IngredientQuantity> newIngre = new ArrayList<IngredientQuantity>();
    	
    	recipe.getIngredients().stream().forEach(ingQuan -> {
    		Optional<Ingredient> ingOp = ingredientService.loadIngredient(ingQuan.getIngredient());
			ingOp.ifPresent(ing -> {
				ingQuan.setIngredient(ing);
				newIngre.add(ingQuan);
			});
    	});
    	
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
