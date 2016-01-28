package com.chandhu.springstore.Dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chandhu.springstore.Model.Product;

public class ProductMapper implements RowMapper<Product> {

	@Override
	public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setProductId(rs.getInt("productId"));
		product.setProductName(rs.getString("productName"));
		product.setProductPrice(rs.getFloat("productPrice"));
		product.setProductCategory(rs.getString("productCategory"));
		product.setProductDescription(rs.getString("productDescription"));

		return product;
	}

}
