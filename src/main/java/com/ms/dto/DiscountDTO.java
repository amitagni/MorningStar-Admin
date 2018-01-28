package com.ms.dto;

import java.io.Serializable;

public class DiscountDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String abbriviation;
	private String value;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAbbriviation() {
		return this.abbriviation;
	}

	public void setAbbriviation(String abbriviation) {
		this.abbriviation = abbriviation;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}