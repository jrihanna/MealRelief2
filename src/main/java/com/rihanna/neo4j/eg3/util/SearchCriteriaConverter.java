package com.rihanna.neo4j.eg3.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import com.rihanna.neo4j.eg3.dto.IngredientDTO;
import com.rihanna.neo4j.eg3.dto.RecipeSearchDTO;
import com.rihanna.neo4j.eg3.dto.TagDTO;
import com.rihanna.neo4j.eg3.enumeration.CategoryEnum;

public class SearchCriteriaConverter {
	
	public static RecipeSearchDTO createListSearchCriteria(String recipeName, String category,
			List<String> includedIngredients, List<String> excludedIngredients, List<String> tags) {
		
		RecipeSearchDTO dto = new RecipeSearchDTO();
		dto.setName(recipeName);
		dto.setCategory(category != null ? CategoryEnum.valueOf(category) : null);
		dto.setIncludedIngredients(convertIngredients(includedIngredients));
		dto.setExcludedIngredients(convertIngredients(excludedIngredients));
		dto.setTags(convertTags(tags));
		
		return dto;
	}
	
	private static List<IngredientDTO> convertIngredients(List<String> ingredientsNames) {
		if(ingredientsNames != null) {
			List<IngredientDTO> ings = Collections.emptyList();
			ingredientsNames.stream().forEach(s -> ings.add(new IngredientDTO(s)));
			return ings;
		}
		else
			return null;
	}
	
	private static Set<TagDTO> convertTags(List<String> tags) {
		if(tags != null) {
			Set<TagDTO> tagDtos = Collections.emptySet();
			tags.stream().forEach(s -> tagDtos.add(new TagDTO(s)));
			return tagDtos;
		}
		else
			return null;
	}

}
