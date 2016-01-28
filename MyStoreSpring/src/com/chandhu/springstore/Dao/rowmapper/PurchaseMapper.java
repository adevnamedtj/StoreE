package com.chandhu.springstore.Dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.chandhu.springstore.Model.Purchase;

public class PurchaseMapper implements RowMapper<Purchase> {

	@Override
	public Purchase mapRow(ResultSet rs, int rowNum) throws SQLException {
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(rs.getInt("purchaseId"));
		purchase.setPurchaseProductId(rs.getInt("purchaseProductId"));
		purchase.setPurchaseTransaction(rs.getInt("purchaseTransaction"));
		purchase.setPurchaseProductQty(rs.getInt("purchaseProductQty"));
		purchase.setPurchaseTotal(rs.getFloat("purchaseTotal"));
		purchase.setPurchaseDate(rs.getTimestamp("purchaseDate"));
		purchase.setPurchaseUserId(rs.getInt("purchaseUserId"));
		return purchase;
		
	}

}
