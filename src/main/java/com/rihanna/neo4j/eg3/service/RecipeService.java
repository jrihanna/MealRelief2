package com.rihanna.neo4j.eg3.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.dto.RecipeSearchDTO;
import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.model.Tag;
import com.rihanna.neo4j.eg3.repository.RecipeRepository;
import com.rihanna.neo4j.eg3.util.SearchCriteriaConverter;

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

    public Collection<Recipe> searchRecipeList(RecipeSearchDTO searchCriteria) {
    	return recipeRepository.findByCriteria(SearchCriteriaConverter.generateQuery(searchCriteria));
    }
    
    public Collection<Recipe> searchRecipe(Recipe recipe) {
    	Collection<Recipe> result = Collections.emptyList();
    	
    	if(recipe.getName() != null && recipe.getName().length() > 0)
    		result = recipeRepository.findByName(recipe.getName());
    	
    	if(recipe.getIngredients() != null)
	    	result.addAll(recipeRepository.findByIngredients(
	    			recipe.getIngredients().stream().map(s -> s.getIngredient().getName()).collect(Collectors.toList())
	    			));
    	
    	if(recipe.getTags() != null)
	    	result.addAll(recipeRepository.findByTags(
	    			recipe.getTags().stream().map(s -> s.getName()).collect(Collectors.toList())
	    			));
    			
    	return result;
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
