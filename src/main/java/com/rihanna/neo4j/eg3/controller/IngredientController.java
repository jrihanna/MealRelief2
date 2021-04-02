package com.rihanna.neo4j.eg3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rihanna.neo4j.eg3.dto.IngredientDTO;
import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.service.IngredientService;

@CrossOrigin(origins = {"http://localhost:3000"})
@Controller
@RequestMapping("/ingredient")
public class IngredientController {

	@Autowired
	IngredientService ingredientService;
	
	@PostMapping(path = "/add")
    public String saveIngredient(@RequestBody IngredientDTO ingredient) {
		ingredientService.saveNewIngredient(ingredient);
		return "success";
    }
	
	@PutMapping(path = "/update")
    public void updateIngredient(@RequestBody Ingredient ingredient) {
		ingredientService.saveOrUpdateIngredient(ingredient);
    }
	
	@GetMapping(path = "/autocomplete")
    public @ResponseBody List<Ingredient> getIngredientByNameLike(@RequestParam String ingName) {
		return ingredientService.loadIngredientLikeName(ingName);
    }
}
