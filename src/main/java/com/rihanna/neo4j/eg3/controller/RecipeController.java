package com.rihanna.neo4j.eg3.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.model.SearchResult;
import com.rihanna.neo4j.eg3.model.Tag;
import com.rihanna.neo4j.eg3.service.RecipeService;

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
	
	@GetMapping(path = "/search")
    public @ResponseBody Collection<Recipe> searchRecipe(@RequestBody Recipe recipe) {
    	return recipeService.searchRecipe(recipe);
    }
	
	@GetMapping(path = "/search2")
    public @ResponseBody SearchResult searchRecipe2(@RequestParam String recipeName) {
		System.out.println(recipeName);
		Recipe recipe = new Recipe();
		recipe.setName(recipeName);
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
