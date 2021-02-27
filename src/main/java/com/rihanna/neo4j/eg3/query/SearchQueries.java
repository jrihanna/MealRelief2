package com.rihanna.neo4j.eg3.query;

import org.neo4j.procedure.UserFunction;

import com.rihanna.neo4j.eg3.dto.RecipeSearchDTO;


public class SearchQueries {
	
	@UserFunction(name = "SearchForCriteria")
	public String createSearchQuery4Criteria(RecipeSearchDTO criteria) {
		String result = "MATCH (nut:NutritionalValue)<-[r2:NUTRITIONAL_VALUE]-(n:Recipe)-[r:INGREDIENTS]->"
				+ "(m:Ingredient),(n)-[r3:TAGS]->(t:Tag) where (n.name =~ '(?i).*'+$criteria.recipeName+'.*')"
				+ " return n,collect(r),collect(m),collect(nut),collect(t),collect(r2),collect(r3)";
		
		
		return result;
	}

}
