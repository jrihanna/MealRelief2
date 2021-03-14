package com.rihanna.neo4j.eg3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.repository.IngredientRepository;

@Service
public class IngredientService {
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	public Optional<Ingredient> loadIngredient(Ingredient ingredient) {
		return ingredientRepository.findOneByName(ingredient.getName());
	}
	
	public void saveOrUpdateIngredient(Ingredient ingredient) {
		Optional<Ingredient> current = loadIngredient(ingredient);
		current.ifPresent(currentIngredient -> {
			ingredient.getNutritionalValue().setId(currentIngredient.getNutritionalValue().getId());
			ingredient.setId(currentIngredient.getId());
			ingredientRepository.save(ingredient);
		});
	}
	
	public void saveOrUpdateIngredientBatch(List<IngredientQuantity> inqs) {
		
		inqs.stream().forEach(inq -> {
			
			Ingredient ing = inq.getIngredient();
		
			Optional<Ingredient> current = loadIngredient(ing);
			current.ifPresentOrElse(currentIngredient -> {
//				ing.getNutritionalValue().setId(currentIngredient.getNutritionalValue().getId());
				ing.setId(currentIngredient.getId());
				ingredientRepository.save(ing);
			}, () -> {
				ingredientRepository.save(ing);
			});
		});
	}

}
