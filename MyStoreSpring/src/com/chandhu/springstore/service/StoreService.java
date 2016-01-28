package com.chandhu.springstore.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.chandhu.springstore.Model.Category;
import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.Model.Purchase;
import com.chandhu.springstore.Model.User;

public interface StoreService {
	
    public void remover(String whatTypeofModelToRemove, String Identifier, String IdVal );
	
	public User addUser(User user);
	public void removeUser(User user);
	public User editUser(User user);
	public User getUser(String UserName);
	public Map<String, User> getUsers();
	public boolean authUser(String UserName, String Password);
	
	public Product addProduct(Product product);
	public Product removeProduct(Product product);
	public Product editProduct(Product product);
	public Product getProduct(String Identifier, String IdentifierKind);
	
	public Product getProduct(Product product);
	public List<Product> getProductsBySearch(Product product);
	public Map<Integer, Product> getproductsByCategory(String categoryName);
	public Map<Integer, Product> getProducts();
	
	public Purchase addPurchase(Purchase purchase);
	public Purchase removePurchase(Purchase purchase);
	public List<String> removePurchase(Map<String,Purchase> purchases);
	//dual search by both purchase and product ID
	public Map<Timestamp,Purchase> getpurchase(Integer purchaseId, Integer productId);
	public Map<Timestamp, Purchase> getPurchases();
	
	public Category addCategory(Category category);
	public void removeCategory(String categoryName);
	public Category getCategory(String categoryName);
	public Map<String,Category> getCategories();
	
	

}
