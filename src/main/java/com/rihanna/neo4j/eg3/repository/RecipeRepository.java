package com.rihanna.neo4j.eg3.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.rihanna.neo4j.eg3.dto.RecipeSearchDTO;
import com.rihanna.neo4j.eg3.model.Recipe;


@Repository
public interface RecipeRepository extends Neo4jRepository<Recipe, Long> {

	@Query("MATCH (n:Recipe) RETURN n")
    Collection<Recipe> getAllRecipes();
	
//	@Query("MATCH (n:Recipe) where (n.name contains $recipeName) RETURN n")
	@Query("MATCH (nut:NutritionalValue)<-[r2:NUTRITIONAL_VALUE]-(n:Recipe)-[r:INGREDIENTS]->"
			+ "(m:Ingredient),(n)-[r3:TAGS]->(t:Tag) where (n.name =~ '(?i).*'+$recipeName+'.*') "
			+ "return n,collect(r),collect(m),collect(nut),collect(t),collect(r2),collect(r3)")
	Collection<Recipe> findByName(String recipeName);
	
	@Query("MATCH (nut:NutritionalValue)<-[r2:NUTRITIONAL_VALUE]-(n:Recipe)-[r:INGREDIENTS]->"
			+ "(m:Ingredient),(n)-[r3:TAGS]->(t:Tag) where (id(n) =$recipeId) "
			+ "return n,collect(r),collect(m),collect(nut),collect(t),collect(r2),collect(r3)")
	Recipe findRecipeById(Long recipeId);
	
	@Query("MATCH (n:Recipe)-[:INGREDIENTS]-(m:Ingredient)"
			+ " where (m.name in $ingredientNames) RETURN n")
	Collection<Recipe> findByIngredients(List<String> ingredientNames);
	
	@Query("MATCH (n:Recipe)-[:TAGS]-(o:Tag)"
			+ " where (o.name in $tagNames) RETURN n")
	Collection<Recipe> findByTags(List<String> tagNames);
	

//	@Query("MATCH (n:Recipe) where (n.name =~ '(?i).*$recipeName.*') RETURN n "
//			+ "UNION ALL MATCH (n:Recipe)-[:INGREDIENTS]-(m:Ingredient) "
//			+ "where (m.name in $ingredientNames) return n "
//			+ "UNION ALL MATCH (n:Recipe)-[:TAGS]-(o:Tag) "
//			+ "where (o.name in $tagNames) RETURN n "
//			+ "UNION ALL MATCH (n:Recipe)-[:NUTRITIONAL_VALUE]-(p:NutritionalValue) "
//			+ "where (p.calory = 1200 or p.carbs = 30) return n"
//			)
//	Collection<Recipe> findByCriteria(String recipeName, List<String> ingredientNames, List<String> tagNames);
	
//	@Query("CALL custom.recipe('dg') YIELD ripe")
	@Query("CALL apoc.cypher.run($filterQuery, null) " +
			"YIELD value as v RETURN v.n, v.ings, v.ring, v.tas, v.allTags")//, v.nutts, v.nuts
	List<Recipe> findByCriteria(String filterQuery);
	
	@Query("call apoc.custom.asProcedure('recipe', procedures.search_by_criteria_func,"
			+ "'read',[['ripe', 'NODE']], [['name', 'STRING']]); ")
	void registerProcedure(RecipeSearchDTO criteria);
	
	@Query("CALL custom.recipe('dg') YIELD ripe;")
	Collection<Recipe> findByCriteria2(String filterQuery);

	Collection<Recipe> findByNutritionalValue();
}
