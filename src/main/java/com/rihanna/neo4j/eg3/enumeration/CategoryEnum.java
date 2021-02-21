package com.rihanna.neo4j.eg3.enumeration;

public enum CategoryEnum {
	
	SNACK("Snack"), BREAKFAST("Breakfast"), LUNCH("Lunch"), DINNER("Dinner");
	
	private CategoryEnum(String value) {
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}

}
