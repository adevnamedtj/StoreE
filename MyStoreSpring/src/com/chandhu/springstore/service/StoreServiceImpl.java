package com.chandhu.springstore.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.chandhu.springstore.Dao.Dao;
import com.chandhu.springstore.Model.Category;
import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.Model.Purchase;
import com.chandhu.springstore.Model.User;

public class StoreServiceImpl implements StoreService {
	@Autowired
	Dao dao;

	@Override
	public void remover(String whatTypeofModelToRemove, String Identifier, String IdVal) {

		dao.remover(whatTypeofModelToRemove, Identifier, IdVal);

	}

	@Override
	public User addUser(User user) {

		return dao.addUser(user);
	}

	@Override
	public void removeUser(User user) {
		dao.removeUser(user);

	}

	@Override
	public User editUser(User user) {

		return dao.editUser(user);
	}

	@Override
	public User getUser(String UserName) {

		return dao.getUser(UserName);
	}

	@Override
	public Map<String, User> getUsers() {

		return userMapMaker(dao.getUsers());
	}
	@Override
	public boolean authUser(String UserName, String Password) {
		if(dao.getUser(UserName)==null){
			return false;
		}
		if(dao.getUser(UserName).getPassword().equals(Password)){
			return true;
		}
		else{
			return false;
		}
		
	}

	@Override
	public Product addProduct(Product product) {

		return dao.addProduct(product);
	}

	@Override
	public Product removeProduct(Product product) {

		return dao.removeProduct(product);
	}

	@Override
	public Product editProduct(Product product) {

		return dao.editProduct(product);
	}
	@Override
	public Product getProduct(String Identifier, String IdentifierKind) {
		if(IdentifierKind.equals("productId")){
			return	dao.getProductbyId(Identifier);
		}
		else{
			return dao.getProduct(Identifier);
		}
	}

	
	@Override
	public Product getProduct(Product product) {
		// TODO Auto-generated method stub
		List <Product> productsList=dao.getproductsByCategory(product.getProductCategory());
		Map<String,Product> productGroupByCategory =productMapMakerWithString(productsList);
		 
		return productGroupByCategory.get(product.getProductName());
	}
	@Override
	public List<Product> getProductsBySearch(Product product) {
		List <Product> productsList=dao.getproductsByCategory(product.getProductCategory());
		List <Product> searchResults = new ArrayList<>();
		Map<String,Product> productGroupByCategory =productMapMakerWithString(productsList);
		for(String s:productGroupByCategory.keySet()){
			if (s.toUpperCase().contains(product.getProductName().trim().toUpperCase())){
				searchResults.add(productGroupByCategory.get(s));
			}
		}
		
		
		return searchResults;
	}

	@Override
	public Map<Integer, Product> getproductsByCategory(String categoryName) {

		return productMapMaker(dao.getproductsByCategory(categoryName));

	}

	@Override
	public Map<Integer, Product> getProducts() {

		return productMapMaker(dao.getProducts());
	}

	@Override
	public Purchase addPurchase(Purchase purchase) {

		return dao.addPurchase(purchase);
	}

	@Override
	public Purchase removePurchase(Purchase purchase) {

		return dao.removePurchase(purchase);
	}

	@Override
	public List<String> removePurchase(Map<String, Purchase> purchases) {

		return dao.removePurchase(purchases);
	}

	@Override
	public Map<Timestamp, Purchase> getpurchase(Integer purchaseId, Integer productId) {

		return purchaseMapMaker(dao.getpurchase(purchaseId, productId));
	}

	@Override
	public Map<Timestamp, Purchase> getPurchases() {

		return purchaseMapMaker(dao.getPurchases());
	}

	@Override
	public Category addCategory(Category category) {

		return dao.addCategory(category);
	}

	@Override
	public void removeCategory(String categoryName) {

		dao.removeCategory(categoryName);
	}

	@Override
	public Category getCategory(String categoryName) {

		return dao.getCategory(categoryName);
	}

	@Override
	public Map<String, Category> getCategories() {

		return categoryMapMaker(dao.getCategories(), "name");
	}

	public Map<Integer, Product> productMapMaker(List<Product> products) {
		Map<Integer, Product> map = new HashMap<>();
		for (Product product : products) {
			map.put(product.getProductId(), product);
		}

		return map;

	}
	public Map<String, Product> productMapMakerWithString(List<Product> products) {
		Map<String, Product> map = new HashMap<>();
		for (Product product : products) {
			map.put(product.getProductName(), product);
		}

		return map;

	}

	public Map<Timestamp, Purchase> purchaseMapMaker(List<Purchase> purchases) {
		Map<Timestamp, Purchase> map = new HashMap<>();
		for (Purchase purchase : purchases) {
			map.put(purchase.getPurchaseDate(), purchase);
		}
		return map;

	}

	public Map<String, User> userMapMaker(List<User> users) {
		Map<String, User> map = new HashMap<>();
		for (User user : users) {
			map.put(user.getUsername(), user);
		}
		return map;

	}

	public Map<String, Category> categoryMapMaker(List<Category> categories, String kindOfIdOrName) {
		Map<String, Category> map = new HashMap<>();
		if (kindOfIdOrName == "id") {
			for (Category category : categories) {
				map.put(category.getCategoryId().toString(), category);
			}
		}
		if (kindOfIdOrName == "name") {
			for (Category category : categories) {
				map.put(category.getCategoryName(), category);
			}
		}
		return map;

	}

	

	

	

	

}
