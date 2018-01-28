package com.ms.dto;

public class SearchResultDTO {
	private Integer value;
	private String label;
	private String descValue;

	public String getDescValue() {
		return this.descValue;
	}

	public void setDescValue(String descValue) {
		this.descValue = descValue;
	}

	public Integer getValue() {
		return this.value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
}