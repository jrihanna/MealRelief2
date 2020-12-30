package com.rihanna.neo4j.eg3.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import com.rihanna.neo4j.eg3.model.IngredientQuantity;


public interface IngredientQuantityRepository extends Neo4jRepository<IngredientQuantity, Long> {

}
