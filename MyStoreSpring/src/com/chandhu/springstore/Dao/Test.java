package com.chandhu.springstore.Dao;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.Model.User;

public class Test {
	public static void main(String[] args) {
		System.out.println(new Date());
		System.out.println(new Timestamp(new Date().getTime()));
		// ApplicationContext context = new
		// ClassPathXmlApplicationContext("Dao-Config.xml");
		// DaoImpl daox= (DaoImpl) context.getBean("Dao");
		// for(User user: daox.getUsers()){
		// System.out.println(
		// user.getFullName()
		// +user.getPassword()
		// +user.getUserId()
		// +user.getAddress()
		// +user.getCard()
		// +user.getUsername());
		// }
	}

}
