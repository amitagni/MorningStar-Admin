package com.ms.bean;

import com.ms.bean.CategoryBean;
import com.ms.dto.CategoryDTO;
import java.util.List;

public class InventoryCateoryBean {
	private Integer id;
	private String userAction;
	private String itemName;
	private String itemDescription;
	private CategoryBean categoryBean;
	private List<CategoryDTO> categoryList;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserAction() {
		return this.userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public List<CategoryDTO> getCategoryList() {
		return this.categoryList;
	}

	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}

	public CategoryBean getCategoryBean() {
		return this.categoryBean;
	}

	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

	public String getItemName() {
		return this.itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
}