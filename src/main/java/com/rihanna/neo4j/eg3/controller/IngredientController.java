package com.rihanna.neo4j.eg3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.service.IngredientService;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired
	IngredientService ingredientService;
	
	@PostMapping(path = "/add")
    public void saveIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.saveOrUpdateIngredient(ingredient);
    }
	
	@PutMapping(path = "/update")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.saveOrUpdateIngredient(ingredient);
    }
}
