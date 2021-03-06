package com.rihanna.neo4j.eg3.enumeration;

public enum MeasurementTypeEnum {
	TABLESPOON("tbsp"), TEASPOON("tsp"), GRAM("gr"), NUM("");
	
	private MeasurementTypeEnum(String value) {
		this.value = value;
	}
	
	private String value;

	public String getValue() {
		return value;
	}
}
