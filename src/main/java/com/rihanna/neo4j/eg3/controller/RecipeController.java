package com.rihanna.neo4j.eg3.controller;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rihanna.neo4j.eg3.controller.model.RecipeModelAttribute;
import com.rihanna.neo4j.eg3.dto.RecipeSearchDTO;
import com.rihanna.neo4j.eg3.dto.SearchResult;
import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.model.Tag;
import com.rihanna.neo4j.eg3.service.RecipeService;
import com.rihanna.neo4j.eg3.util.SearchCriteriaConverter;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
@RequestMapping("/recipe")
public class RecipeController {
	
	@Autowired
	RecipeService recipeService;
	
	@GetMapping
    public @ResponseBody Collection<Recipe> getAll() {
    	return recipeService.getAllRecipes();
    }
	
	@PostMapping(path = "/add")
    public String addRecipe(@RequestBody Recipe recipe) {
    	recipeService.saveOrUpdateRecipe(recipe);
    	return "success";
    }
	
	@PutMapping(path = "/update")
    public String updateRecipe(@RequestBody Recipe recipe) {
    	recipeService.saveOrUpdateRecipe(recipe);
    	return "success";
    }
	
	@GetMapping(path = "/search_")
    public @ResponseBody Collection<Recipe> searchRecipe_(@RequestBody Recipe recipe) {
    	return recipeService.searchRecipe(recipe);
    }
	
	@GetMapping(path = "/search")
    public @ResponseBody SearchResult searchRecipe(@ModelAttribute RecipeModelAttribute recipeModelAttribute) {
		
		Collection<Recipe> result = Collections.emptyList();
//		Recipe recipe = new Recipe();
		
//		if(recipeName == null && category == null && includedIngredients == null 
//				&& excludedIngredients == null && tags == null)
//			result = recipeService.searchRecipe(recipe);
//		else {	
			RecipeSearchDTO searchCriteria = SearchCriteriaConverter.createListSearchCriteria(recipeModelAttribute);
			result = recipeService.searchRecipeList(searchCriteria);
//		}
		
		SearchResult searchResult = new SearchResult();
		searchResult.setRecipes(result);
    	return searchResult;
    }
	
	@GetMapping(path = "/search_group")
    public @ResponseBody SearchResult searchGroupRecipe(
    			@Nullable @RequestParam List<String> includedIngredients, 
    			@Nullable @RequestParam List<String> excludedIngredients, 
    			@Nullable @RequestParam List<String> tags) {
		
		// TODO: if all null then search random 10 recipes
		Recipe recipe = new Recipe();
		Collection<Recipe> result = recipeService.searchRecipe(recipe);
		
		SearchResult searchResult = new SearchResult();
		searchResult.setRecipes(result);
    	return searchResult;
    }
	@PutMapping(path = "/tag/add/{id}")
    public String tagRecipe(@RequestBody Tag tag, @PathVariable Long id) {
    	recipeService.tagRecipe(tag, id);
    	return "success";
    }
	
	@PutMapping(path = "/tag/remove/{id}")
    public String untagRecipe(@RequestBody Tag tag, @PathVariable Long id) {
    	recipeService.untagRecipe(tag, id);
    	return "success";
    }
}
