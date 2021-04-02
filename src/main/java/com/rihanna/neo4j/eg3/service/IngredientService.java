package com.rihanna.neo4j.eg3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.dto.IngredientDTO;
import com.rihanna.neo4j.eg3.dto.NutritionalValueDTO;
import com.rihanna.neo4j.eg3.model.Ingredient;
import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.NutritionalValue;
import com.rihanna.neo4j.eg3.repository.IngredientRepository;
import com.rihanna.neo4j.eg3.repository.NutritionalValueRepository;

@Service
public class IngredientService {
	
	@Autowired
	IngredientRepository ingredientRepository;
	
	@Autowired
	NutritionalValueRepository nutritionalValueRepository;
	
	public Optional<Ingredient> loadIngredient(Ingredient ingredient) {
		return ingredientRepository.findOneByName(ingredient.getName());
	}
	
	public List<Ingredient> loadIngredientLikeName(String halfName) {
		return ingredientRepository.findAllIngredientNameLike(halfName);
	}
	
	public void saveOrUpdateIngredient(Ingredient ingredient) {
		Optional<Ingredient> current = loadIngredient(ingredient);
		current.ifPresent(currentIngredient -> {
			ingredient.getNutritionalValue().setId(currentIngredient.getNutritionalValue().getId());
			ingredient.setId(currentIngredient.getId());
			ingredientRepository.save(ingredient);
		});
	}
	
	public void saveNewIngredient(IngredientDTO ingredientDto) {
		Ingredient ingredient = convertDtoToEntity(ingredientDto);
		Optional<Ingredient> current = loadIngredient(ingredient);
		current.ifPresentOrElse(currentIngredient -> {
			ingredient.getNutritionalValue().setId(currentIngredient.getNutritionalValue().getId());
			ingredient.setId(currentIngredient.getId());
			ingredientRepository.save(ingredient);
		}, () -> {
			nutritionalValueRepository.save(ingredient.getNutritionalValue());
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

	private Ingredient convertDtoToEntity(IngredientDTO dto) {
		Ingredient ing = new Ingredient();
		ing.setName(dto.getName());
		ing.setNutritionalValue(convertNutDtoToEntity(dto.getNutritionalValue()));
		return ing;
	}
	
	private NutritionalValue convertNutDtoToEntity(NutritionalValueDTO dto) {
		return new NutritionalValue(dto.getCalory(), dto.getCarbs(), dto.getFat(), dto.getProtein());
	}
}
