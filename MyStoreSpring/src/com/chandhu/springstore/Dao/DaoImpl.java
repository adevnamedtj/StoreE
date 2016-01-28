package com.chandhu.springstore.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.chandhu.springstore.Dao.rowmapper.CategoryMapper;
import com.chandhu.springstore.Dao.rowmapper.ProductMapper;
import com.chandhu.springstore.Dao.rowmapper.PurchaseMapper;
import com.chandhu.springstore.Dao.rowmapper.UserMapper;
import com.chandhu.springstore.Model.Category;
import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.Model.Purchase;
import com.chandhu.springstore.Model.User;
import org.springframework.jdbc.core.JdbcTemplate;

public class DaoImpl implements Dao {

	public DataSource dataSource;
	public JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<User> getUsers() {
		List<User> Users = jdbcTemplate.query("SELECT * FROM user", new UserMapper());
		return Users;

	}

	@Override
	public void remover(String whatTypeofModelToRemove, String Identifier, String Idval) {

		jdbcTemplate.update("DELETE FROM " + whatTypeofModelToRemove + " WHERE " + Identifier + "=" + Idval);

	}

	@Override
	public User addUser(User user) {
		String sql = "INSERT INTO user " + "(UserName,userFullName,userAddress,userPassword,usercard)"
				+ " VALUES (?,?,?,?,?)";

		// JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(sql,
				new Object[] {

				user.getUsername(), user.getFullName(), user.getAddress(), user.getPassword(), user.getCard() });

		return user;
	}

	@Override
	public void removeUser(User user) {
		jdbcTemplate.execute("DELETE FROM user WHERE userName='" + user.getUsername() + "'");

	}

	@Override
	public User editUser(User user) {

		jdbcTemplate.update("UPDATE user SET userFullName=?,userAddress=?,userPassword=?,usercard=?"
				+ " WHERE userName='"+user.getUsername()+"'",
				new Object[] { user.getFullName(), user.getAddress(), user.getPassword(), user.getCard()

		});
		return getUser(user.getUsername());
	}

	@Override
	public User getUser(String UserName) {

		List <User> users = jdbcTemplate.query("SELECT * FROM user WHERE userName='" + UserName + "'", new UserMapper());
	
		if(users.isEmpty()){
			return null;
		}
		else{
			return users.get(0);
		}
		
	
	}

	@Override
	public Product addProduct(Product product) {
		String sql = "INSERT INTO product" + "(" + "productName," + "productPrice," + "productCategory,"
				+ "productDescription)" + "VALUES (?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] {

				product.getProductName(), product.getProductPrice(), product.getProductCategory(),
						product.getProductDescription()

		});
		return product;
	}

	@Override
	public Product removeProduct(Product product) {

		jdbcTemplate.execute("DELETE FROM product WHERE productId='" + product.getProductId() + "'");
		return product;
	}

	@Override
	public Product editProduct(Product product) {

		return null;
	}

	@Override
	public Product getProduct(String productName) {
		return jdbcTemplate.query("SELECT * FROM product WHERE productName='" + productName + "'", new ProductMapper())
				.get(0);

	}
	@Override
	public Product getProductbyId(String productId) {
		// TODO Auto-generated method stub
		return jdbcTemplate.query("SELECT * FROM product WHERE productId='" + productId + "'", new ProductMapper())
				.get(0);

	}

	@Override
	public List<Product> getproductsByCategory(String categoryName) {
		if (categoryName.equals("All")){
			return jdbcTemplate.query("SELECT * FROM product", new ProductMapper());
		}
		else{
			return jdbcTemplate.query("SELECT * FROM product WHERE productCategory='" + categoryName + "'",
					new ProductMapper());
		}

		
	}

	@Override
	public List<Product> getProducts() {

		return jdbcTemplate.query("SELECT * FROM product", new ProductMapper());
	}

	@Override
	public Purchase addPurchase(Purchase purchase) {
		String sql = "INSERT INTO purchase" + "(" + "purchaseProductId," + "purchaseTransaction,"
				+ "purchaseProductQty," + "purchaseTotal," + "purchaseDate," + "purchaseUserId)"
				+ "VALUES (?,?,?,?,?,?)";
		jdbcTemplate.update(sql,
				new Object[] {

				purchase.getPurchaseProductId(), purchase.getPurchaseTransaction(), purchase.getPurchaseProductQty(),
						purchase.getPurchaseTotal(), purchase.getPurchaseDate(), purchase.getPurchaseUserId() });

		return purchase;
	}

	@Override
	public Purchase removePurchase(Purchase purchase) {
		jdbcTemplate.execute("DELETE FROM purchase WHERE purchaseId='" + purchase.getPurchaseId() + "'");
		return purchase;
	}

	@Override
	public List<String> removePurchase(Map<String, Purchase> purchases) {
		List<String> DELETEs = new ArrayList();
		for (Purchase purchase : purchases.values()) {
			jdbcTemplate.update("DELETE FROM purchase WHERE purchaseId=? or purchaseProductId=?",
					new Object[] { purchase.getPurchaseId(), purchase.getPurchaseProductId() });
			DELETEs.add(purchase.getPurchaseId().toString());
		}
		return DELETEs;
	}

	@Override
	public List<Purchase> getpurchase(Integer purchaseId, Integer productId) {
		List<Purchase> purchases = new ArrayList();
		if (purchaseId == null) {
			purchases = jdbcTemplate.query("SELECT * FROM purchase WHERE productId='" + productId + "'",
					new PurchaseMapper());

		}
		if (productId == null) {
			purchases = jdbcTemplate.query("SELECT * FROM user WHERE purchaseId='" + purchaseId + "'",
					new PurchaseMapper());

		}
		return purchases;
	}

	@Override
	public List<Purchase> getPurchases() {

		return jdbcTemplate.query("SELECT * FROM purchase", new PurchaseMapper());
	}

	@Override
	public Category addCategory(Category category) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO category" + "(" + "categoryName," + "categoryDescription)" + "VALUES (?,?)";
		jdbcTemplate.update(sql,
				new Object[] {

				category.getCategoryName(), category.getCategoryDescription() });
		return category;
	}

	@Override
	public void removeCategory(String categoryName) {
		jdbcTemplate.execute("DELETE FROM Category WHERE categoryName='" + categoryName + "'");
	}

	@Override
	public Category getCategory(String categoryName) {
		// TODO Auto-generated method stub
		return jdbcTemplate
				.query("SELECT * FROM Category WHERE categoryName='" + categoryName + "'", new CategoryMapper()).get(0);

	}

	@Override
	public List<Category> getCategories() {

		return jdbcTemplate.query("SELECT * FROM Category", new CategoryMapper());
	}

	@Override
	public String daoTest(String x) {
		return x;
		// TODO Auto-generated method stub

	}

	

}
