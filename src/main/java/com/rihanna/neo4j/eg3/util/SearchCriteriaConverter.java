package com.rihanna.neo4j.eg3.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.rihanna.neo4j.eg3.controller.model.RecipeModelAttribute;
import com.rihanna.neo4j.eg3.dto.IngredientDTO;
import com.rihanna.neo4j.eg3.dto.RecipeSearchDTO;
import com.rihanna.neo4j.eg3.dto.TagDTO;
import com.rihanna.neo4j.eg3.enumeration.CategoryEnum;

public class SearchCriteriaConverter {
	
	public static RecipeSearchDTO createListSearchCriteria( RecipeModelAttribute rma) {
		
		RecipeSearchDTO dto = new RecipeSearchDTO();
		dto.setName(rma.getRecipeName());
		dto.setCategory(rma.getCategory());
		dto.setIncludedIngredients(convertIngredients(rma.getIncludedIngredients()));
		dto.setExcludedIngredients(convertIngredients(rma.getExcludedIngredients()));
		dto.setTags(convertTags(rma.getTags()));
		
		return dto;
	}
	
	public static String generateQuery(RecipeSearchDTO searchCriteria) {
		return "MATCH (nut:NutritionalValue)<-[r2:NUTRITIONAL_VALUE]-(n:Recipe)-[r:INGREDIENTS]->"
    			+ "(mi:Ingredient),(n)-[r3:TAGS]->(t:Tag)  "
    			+ generateWhereClause(searchCriteria)
    			+ addOptionals()
    			+ " return n, "
    			+ "collect(si) + collect(mi) as ings, collect(distinct rr) as ring, "
    			+ "collect(t) + collect(ta) as allTags, collect(tt) as tas, collect(nutt) as nutts, collect(nut) as nuts"
    			+ addLimit(searchCriteria);
	}
	
	private static List<IngredientDTO> convertIngredients(List<String> ingredientsNames) {
		if(ingredientsNames != null) {
			List<IngredientDTO> ings = new ArrayList<>();
			ingredientsNames.stream().forEach(s -> ings.add(new IngredientDTO(s)));

			return ings;
		}
		else
			return null;
	}
	
	private static Set<TagDTO> convertTags(List<String> tags) {
		if(tags != null) {
			Set<TagDTO> tagDtos = new HashSet<>();
			tags.stream().forEach(s -> tagDtos.add(new TagDTO(s)));
			return tagDtos;
		}
		else
			return null;
	}
	
	private static String generateWhereClause(RecipeSearchDTO sc) {
    	if(determineIncludeWhereClause(sc)) {
	    	String whereClause = " where (";
	    	boolean needsAnd = false;
	    	if(sc.getName() != null && sc.getName().length() > 0) {
	    		whereClause += "n.name =~ '(?i).*" + sc.getName() + ".*'";
	    		needsAnd = true;
	    	}
	    	
	    	if(sc.getCategory() != null) {
	    		if(needsAnd)
	    			whereClause += " and ";
	    		whereClause += "n.category = '" + sc.getCategory() + "'";
	    		needsAnd = true;
	    	}
	    	
	    	if(sc.getExcludedIngredients() != null && sc.getExcludedIngredients().size() > 0) {
	    		if(needsAnd)
	    			whereClause += " and "; 
	    		
	    		whereClause += "(not mi.name in [";
	    		
	    		for(IngredientDTO ing : sc.getExcludedIngredients()) {
	    			whereClause += "'" + ing.getName() + "',";
	    		}
	    		whereClause = whereClause.substring(0, whereClause.lastIndexOf(",")) + "])";
	    		needsAnd = true;
	    	}
	    	
	    	if(sc.getIncludedIngredients() != null && sc.getIncludedIngredients().size() > 0) {
	    		if(needsAnd)
	    			whereClause += " and ";
	    		whereClause += "(mi.name in [";
	    		
	    		for(IngredientDTO ing : sc.getIncludedIngredients()) {
	    			whereClause += "'" + ing.getName() + "',";
	    		}

	    		whereClause = whereClause.substring(0, whereClause.lastIndexOf(",")) + "])";
	    		needsAnd = true;
	    	}
	    	
	    	if(sc.getTags() != null && sc.getTags().size() > 0) {
	    		if(needsAnd) 
	    			whereClause += " and ";
	    		
	    		whereClause += "(t.name in [";
	    		
	    		for(TagDTO t : sc.getTags()) {
	    			whereClause += "'" + t.getName() + "',";
	    		}

	    		whereClause = whereClause.substring(0, whereClause.lastIndexOf(",")) + "])";
	    		needsAnd = true;
	    	}
	    	
	    	whereClause += ")";
	    	
	    	return whereClause;
    	}
    	return "";
    }
    
    private static String addOptionals() {
    	String optionals = " OPTIONAL MATCH (n)-[rr:INGREDIENTS]->(si) "
    			+ "OPTIONAL MATCH (n)-[tt:TAGS]->(ta) "
    			+ "OPTIONAL MATCH (n)-[nutt:NUTRITIONAL_VALUE]->(nut) ";
    	
    	return optionals;
    }
    private static boolean determineIncludeWhereClause(RecipeSearchDTO sc) {
    	if(sc.getName() != null && sc.getName().length() > 0) 
    		return true;
    	
    	if(sc.getCategory() != null) return true;
    	
    	if(sc.getExcludedIngredients() != null && sc.getExcludedIngredients().size() > 0)
    		return true;
    	
    	if(sc.getIncludedIngredients() != null && sc.getIncludedIngredients().size() > 0) 
    		return true;
    	
    	if(sc.getTags() != null && sc.getTags().size() > 0)
    		return true;
    	
    	return false;
    }

    private static String addLimit(RecipeSearchDTO searchCriteria) {
    	return (searchCriteria.getLimit() > 0 ? " limit " + searchCriteria.getLimit() : "");
    }
}
