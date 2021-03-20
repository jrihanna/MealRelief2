package com.rihanna.neo4j.eg3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rihanna.neo4j.eg3.model.IngredientQuantity;
import com.rihanna.neo4j.eg3.model.NutritionalValue;
import com.rihanna.neo4j.eg3.model.Recipe;

@Service
public class NutritionCalculatorService {
	
	@Autowired
	IngredientService ingredientService;

	public NutritionalValue calculateNutritionsForRecipe(Recipe recipe) {
		NutritionalValue result = new NutritionalValue();
		
		recipe.getIngredients().stream().forEach(ingQuan -> {
			NutritionalValue nv = ingQuan.getIngredient().getNutritionalValue();
			result.addValues(
					calculateTotal(nv.getCalory(), ingQuan),
					calculateTotal(nv.getCarbs(), ingQuan),
					calculateTotal(nv.getFat(), ingQuan),
					calculateTotal(nv.getProtein(), ingQuan));
		});
		
		return result;
	}
	
	private Integer calculateTotal(Integer raw, IngredientQuantity ingQuan) {
		return Float.valueOf(((raw * ingQuan.getQuantity()) / ingQuan.getIngredient().getPerQuantity())).intValue();
	}
}
