package com.chandhu.springstore.Dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.chandhu.springstore.Model.Category;
import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.Model.Purchase;
import com.chandhu.springstore.Model.User;

public interface Dao {
	public void setDataSource(DataSource dataSource);
	
	 public void remover(String whatTypeofModelToRemove, String Identifier,String IdentifierVal );
		//-------
	    public String daoTest(String x);
		public User addUser(User user);
		public void removeUser(User user);
		public User editUser(User user);
		public User getUser(String UserName);
		public List<User> getUsers();
		
		public Product addProduct(Product product);
		public Product removeProduct(Product product);
		public Product editProduct(Product product);
		public Product getProduct(String productName);
		public Product getProductbyId(String productId);
		public List<Product> getproductsByCategory(String categoryName);
		public List<Product> getProducts();
		
		public Purchase addPurchase(Purchase purchase);
		public Purchase removePurchase(Purchase purchase);
		public List<String> removePurchase(Map<String,Purchase> purchases);
		//dual search by both purchase and product ID
		public List<Purchase> getpurchase(Integer purchaseId, Integer productId);
		public List<Purchase> getPurchases();
		
		public Category addCategory(Category category);
		public void removeCategory(String categoryName);
		public Category getCategory(String categoryName);
		public List<Category> getCategories();

		
		

}
