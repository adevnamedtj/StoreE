package com.chandhu.springstore.Model;

public class Product {
	
	private String productName;
	private Integer productId;
	private float productPrice;
	private String productCategory;
	private String productDescription;
	
	
	
	public Product(){}
	
	public Product(String productName, Integer productId, float productPrice, String productCategory,
			String productDescription) {

		this.productName = productName;
		this.productId = productId;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
	}
	

	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productId=" + productId + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + ", productDescription=" + productDescription + "]";
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productname) {
		this.productName = productname;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float f) {
		this.productPrice = f;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}
	

}
