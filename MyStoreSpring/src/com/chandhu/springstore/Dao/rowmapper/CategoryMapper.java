package com.chandhu.springstore.Dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chandhu.springstore.Model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rs, int rowNum) throws SQLException {
		Category category = new Category();
		category.setCategoryId(rs.getInt("categoryId"));
		category.setCategoryName(rs.getString("categoryName"));
		category.setCategoryDescription(rs.getString("categoryDescription"));

		return category;
	}

}
