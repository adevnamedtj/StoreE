package com.chandhu.springstore.Model;

public class Category {
	private String categoryName;
	private Integer categoryId;
	private String categoryDescription;

	public Category() {
	}

	/**
	 * @param categoryName
	 * @param categoryDescription
	 */
	public Category(String categoryName, String categoryDescription) {
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
	}

	public Category(String categoryName, Integer categoryId, String categoryDescription) {

		this.categoryName = categoryName;
		this.categoryId = categoryId;
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", categoryId=" + categoryId + ", categoryDescription="
				+ categoryDescription + "]";
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

}
