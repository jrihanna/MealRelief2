package com.rihanna.neo4j.eg3.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.controller.model.GroupSearchModelAttribute;
import com.rihanna.neo4j.eg3.controller.model.RecipeModelAttribute;
import com.rihanna.neo4j.eg3.dto.GroupSearchResult;
import com.rihanna.neo4j.eg3.dto.IngredientDTO;
import com.rihanna.neo4j.eg3.dto.NutritionalValueDTO;
import com.rihanna.neo4j.eg3.dto.RecipeDTO;
import com.rihanna.neo4j.eg3.dto.RecipeSearchDTO;
import com.rihanna.neo4j.eg3.dto.TagDTO;
import com.rihanna.neo4j.eg3.enumeration.CategoryEnum;
import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.model.Tag;
import com.rihanna.neo4j.eg3.repository.RecipeRepository;
import com.rihanna.neo4j.eg3.util.RecipeModelConverter;
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
//    	recipe.setNutritionalValue(nutritionCalculatorService.calculateNutritionsForRecipe(recipe));
    	recipeRepository.save(recipe);
    	
    }

    public Collection<Recipe> searchRecipeList(RecipeSearchDTO searchCriteria) {
    	return recipeRepository.findByCriteria(SearchCriteriaConverter.generateQuery(searchCriteria));
    }
    
    public GroupSearchResult searchRecipeGroup(RecipeModelAttribute recipeModelAttribute) {

    	// divide nutrition by 3
    	RecipeSearchDTO searchCriteria = convertToRecipeSearchDTO(recipeModelAttribute);
    	
    	// search 7 breakfast, 7 lunch, 7 dinner, 7 snack
    	searchCriteria.setLimit(7);
    	searchCriteria.setCategory(CategoryEnum.BREAKFAST.getValue());
    	List<Recipe> breakfasts = recipeRepository.findByCriteria(SearchCriteriaConverter.generateQuery(searchCriteria));
 
    	searchCriteria.setCategory(CategoryEnum.LUNCH.getValue());
    	List<Recipe> lunches = recipeRepository.findByCriteria(SearchCriteriaConverter.generateQuery(searchCriteria));

    	searchCriteria.setCategory(CategoryEnum.DINNER.getValue());
    	List<Recipe> dinners = recipeRepository.findByCriteria(SearchCriteriaConverter.generateQuery(searchCriteria));

    	searchCriteria.setCategory(CategoryEnum.SNACK.getValue());
    	List<Recipe> snacks = recipeRepository.findByCriteria(SearchCriteriaConverter.generateQuery(searchCriteria));

    	GroupSearchResult result = new GroupSearchResult();
		Map<Integer, List<RecipeDTO>> mm = new HashMap<>();
    	for(int i = 1; i <= 7; i++) {
    		RecipeDTO breakfastI = breakfasts.size() >= i ? RecipeModelConverter.convertEntityToDTO(breakfasts.get(i)) : null;
    		RecipeDTO lunchI = lunches.size() >= i ? RecipeModelConverter.convertEntityToDTO(lunches.get(i)) : null;
    		RecipeDTO dinnerI = dinners.size() >= i ? RecipeModelConverter.convertEntityToDTO(dinners.get(i)) : null;
    		RecipeDTO snackI = snacks.size() >= i ? RecipeModelConverter.convertEntityToDTO(snacks.get(i)) : null;
    		
    		mm.put(i, Arrays.asList(breakfastI, lunchI, dinnerI, snackI));
    	}
    	
    	result.setRecipesPerDay(mm);
    	return result;
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
    
    public Optional<Recipe> findRecipeById(Long id) {
    	return recipeRepository.findById(id);
    }
    
    public Map<String, List<String>> generateGroceryList(List<Long> ids) {
    	
    	Map<String, List<String>> result = new HashMap<>();
    	
    	ids.stream().forEach(rId -> {
    		Optional<Recipe> recipe = findRecipeById(rId);
    		recipe.ifPresent(r -> {
    			List<IngredientQuantity> ings = r.getIngredients();
    			ings.forEach(ing -> {
    				String measurement = ing.getMeasurementType() != null ? ing.getMeasurementType() : "gr";
    				String quantity = ing.getQuantity().toString();
    				if(quantity.endsWith(".0"))
    					quantity = String.valueOf(ing.getQuantity().intValue());
    				final String quantityString = quantity;
    				result.computeIfPresent(ing.getIngredient().getName(), (in, currents) -> {
    					String value = quantityString + " " + measurement;
    					List<String> newList = new ArrayList<>();
    					newList.addAll(currents);
    					newList.add(value);
    					return newList;
    				});
    				
    				result.computeIfAbsent(ing.getIngredient().getName(), in -> {
    					String value = quantityString + " " + measurement;
    					return Arrays.asList(value);
    				});
    			});
    		});
    	});
    	
    	return result;
    }
    
    public Map<Integer, List<Recipe>> loadRecipesPerDay(GroupSearchModelAttribute groupSearchModelAttribute) {
    	Map<Integer, List<Recipe>> recipePerDay = new HashMap<>();
    	for(Integer i : groupSearchModelAttribute.getRecipePerDay().keySet()) {
    		List<Long> recipeIdsPerDay = groupSearchModelAttribute.getRecipePerDay().get(i);
    		List<Recipe> recipesPerDay = new ArrayList<>();
    		
    		for(Long recipeId : recipeIdsPerDay) {
    			Recipe recipe = recipeRepository.findRecipeById(recipeId);
    			recipesPerDay.add(recipe);
    		}
    		
    		recipePerDay.put(i, recipesPerDay);
    	}
    	
    	return recipePerDay;
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
    

    private RecipeSearchDTO convertToRecipeSearchDTO(RecipeModelAttribute rma) {
    	RecipeSearchDTO dto = new RecipeSearchDTO();
    	dto.setCategory(rma.getCategory());
    	
    	if(rma.getExcludedIngredients() != null) {
	    	dto.setExcludedIngredients(new ArrayList<>());
	    	for(String ing : rma.getExcludedIngredients()) 
	    		dto.getExcludedIngredients().add(new IngredientDTO(ing));
    	}
    	
    	if(rma.getIncludedIngredients() != null) {
	    	dto.setIncludedIngredients(new ArrayList<>());
	    	for(String ing : rma.getIncludedIngredients()) 
	    		dto.getIncludedIngredients().add(new IngredientDTO(ing));
    	}
    	
    	dto.setMaxNutritionalValues(new NutritionalValueDTO(rma.getMaxCalory()/3, rma.getMaxCarb()/3, rma.getMaxFat()/3, rma.getMaxProtein()/3));
    	dto.setMinNutritionalValues(new NutritionalValueDTO(rma.getMinCalory()/3, rma.getMinCarb()/3, rma.getMinFat()/3, rma.getMinProtein()/3));
    	
    	if(dto.getTags() != null) {
	    	dto.setTags(new HashSet<>());
	    	for(String tag : rma.getTags())
	    		dto.getTags().add(new TagDTO(tag));
    	}
    	return dto;
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
