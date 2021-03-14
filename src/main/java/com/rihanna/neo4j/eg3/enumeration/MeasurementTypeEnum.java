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
	
	public static MeasurementTypeEnum fromString(String text) {
        for (MeasurementTypeEnum b : MeasurementTypeEnum.values()) {
            if (b.value.equalsIgnoreCase(text)) {
                return b;
            }
        }
        return null;
    }
}
