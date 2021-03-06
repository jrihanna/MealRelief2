package com.rihanna.neo4j.eg3.model;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.Property;
import org.neo4j.ogm.annotation.StartNode;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import com.rihanna.neo4j.eg3.enumeration.MeasurementTypeEnum;

@RelationshipProperties
public class IngredientQuantity {
	@Id
	@GeneratedValue
	private Long id;
	
	@StartNode
	private Recipe recipe;
	
    @EndNode
	@TargetNode
	private Ingredient ingredient;
    
    @Property
    private float quantity;
    
    @Property
    private MeasurementTypeEnum measurementType;

    @Property
    private float quantityGram;
    

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Recipe getRecipe() {
		return recipe;
	}
	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
	public Ingredient getIngredient() {
		return ingredient;
	}
	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	public MeasurementTypeEnum getMeasurementType() {
		return measurementType;
	}
	public void setMeasurementType(MeasurementTypeEnum measurementType) {
		this.measurementType = measurementType;
	}
	public float getQuantityGram() {
		return quantityGram;
	}
	public void setQuantityGram(float quantityGram) {
		this.quantityGram = quantityGram;
	}
    
}
