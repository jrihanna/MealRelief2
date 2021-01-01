package com.rihanna.neo4j.eg3.repository;

import java.util.Optional;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.rihanna.neo4j.eg3.model.Ingredient;

public interface IngredientRepository extends Neo4jRepository<Ingredient, Long> {

//	@Query("MATCH (n:Ingredient {name:$name})-[:NUTRITIONAL_VALUE]->(m:NutritionalValue) RETURN n,m")
//	public Ingredient findByName(String name);
	
	Optional<Ingredient> findOneByName(String name);
}
