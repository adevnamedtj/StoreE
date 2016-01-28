package com.chandhu.springstore.Dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chandhu.springstore.Model.User;

public class UserMapper implements RowMapper<User>
{

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUserId(rs.getInt("userId"));
		user.setUsername(rs.getString("userName"));
		user.setPassword(rs.getString("userPassword"));
		user.setAddress(rs.getString("userAddress"));
		user.setFullName(rs.getString("userFullName"));
		user.setCard(rs.getString("usercard"));
		return user;
	}

}
