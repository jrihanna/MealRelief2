package com.rihanna.neo4j.eg3.repository;

import java.util.Collection;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.rihanna.neo4j.eg3.model.Recipe;


@Repository
public interface RecipeRepository extends Neo4jRepository<Recipe, Long> {

	@Query("MATCH (n:Recipe) RETURN n")
    Collection<Recipe> getAllRecipes();
}
