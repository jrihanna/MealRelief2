package com.rihanna.neo4j.eg3.model;

import java.util.List;
import java.util.Set;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import com.rihanna.neo4j.eg3.enumeration.CategoryEnum;

@NodeEntity
public class Recipe {

	@Id
	@GeneratedValue
	//@GraphId
	private Long id;
	
	private String name;
	private String instructions;
	private String iconSrc;
	
	@Relationship(type = "includes", direction = Relationship.OUTGOING)
	private List<IngredientQuantity> ingredients;
	
	@Relationship(type = "relates", direction = Relationship.OUTGOING)
	private Set<Tag> tags;
	
	@Relationship(type = "isA", direction = Relationship.OUTGOING)
	private String category;
	
	@Relationship(type = "total_nutritions", direction = Relationship.UNDIRECTED)
	private NutritionalValue nutritionalValue;
	
	public Recipe() {}

	public Recipe(Long id, String name, String instructions, List<IngredientQuantity> ingredients, Set<Tag> tags,
			NutritionalValue nutritionalValue) {
		super();
		this.id = id;
		this.name = name;
		this.instructions = instructions;
		this.ingredients = ingredients;
		this.tags = tags;
		this.nutritionalValue = nutritionalValue;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<IngredientQuantity> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientQuantity> ingredients) {
		this.ingredients = ingredients;
	}

	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public NutritionalValue getNutritionalValue() {
		return nutritionalValue;
	}

	public void setNutritionalValue(NutritionalValue nutritionalValue) {
		this.nutritionalValue = nutritionalValue;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getIconSrc() {
		return iconSrc;
	}

	public void setIconSrc(String iconSrc) {
		this.iconSrc = iconSrc;
	}
}
