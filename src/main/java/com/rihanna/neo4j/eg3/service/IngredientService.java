package com.rihanna.neo4j.eg3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.repository.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	public Ingredient loadIngredient(Ingredient ingredient) {
		Optional<Ingredient> op = ingredientRepository.findOneByName(ingredient.getName());
		if(op.isPresent())
			return op.get();
		return null;
	}
	
	public void saveOrUpdateIngredient(Ingredient ingredient) {
		Ingredient current = loadIngredient(ingredient);
		if(current != null) {
			ingredient.getNutritionalValue().setId(current.getNutritionalValue().getId());
			ingredient.setId(current.getId());
		}
		ingredientRepository.save(ingredient);
	}

}
