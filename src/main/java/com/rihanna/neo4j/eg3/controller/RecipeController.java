package com.rihanna.neo4j.eg3.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rihanna.neo4j.eg3.model.Recipe;
import com.rihanna.neo4j.eg3.repository.RecipeRepository;


@Controller
@RequestMapping("/recipeee")
public class RecipeController {
	
	@Autowired
	RecipeRepository recipeRepository;
	
	@GetMapping
    public @ResponseBody Collection<Recipe> getAll() {
    	try {
    		return recipeRepository.getAllRecipes();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
    	return null;
    }
}
