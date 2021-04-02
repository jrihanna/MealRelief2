package com.rihanna.neo4j.eg3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;

import com.rihanna.neo4j.eg3.model.Ingredient;

public interface IngredientRepository extends Neo4jRepository<Ingredient, Long> {

//	@Query("MATCH (n:Ingredient {name:$name})-[:NUTRITIONAL_VALUE]->(m:NutritionalValue) RETURN n,m")
//	public Ingredient findByName(String name);
	
	Optional<Ingredient> findOneByName(String name);
	
	@Query("MATCH (i:Ingredient)-[r:NUTRITIONAL_VALUE]->(nut:NutritionalValue)  where i.name =~ '(?i).*'+$halfName+'.*' return i, collect(r), collect(nut)")
	List<Ingredient> findAllIngredientNameLike(String halfName);
}
