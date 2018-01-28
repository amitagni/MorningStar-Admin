package com.ms.dto;

import java.io.Serializable;

public class CategoryDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String categoryName;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}