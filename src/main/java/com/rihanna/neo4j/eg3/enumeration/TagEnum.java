package com.rihanna.neo4j.eg3.enumeration;

public enum TagEnum {
	
	VEGETARIAN("Vegetarian"),VEGAN("Vegan"), PISCATERIAN("Piscaterian");
	
	private TagEnum(String value) {
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}

	
}
