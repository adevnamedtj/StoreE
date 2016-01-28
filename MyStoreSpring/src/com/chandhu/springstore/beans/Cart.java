package com.chandhu.springstore.beans;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.chandhu.springstore.CartController;
import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.service.StoreService;
@Component
@Scope(value=WebApplicationContext.SCOPE_SESSION,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Cart {
	@Autowired
	StoreService service;
	private Map<Integer, Integer> cart = new HashMap<>();
	
	public double Total=0;
	public static final Logger logger= LoggerFactory.getLogger(Cart.class);
	
	
	public Map<Product, Integer> cartMapConverter(Map<Integer, Integer> idMap){
		 Total=0;
		Map<Product, Integer> productMap = new HashMap<>();
		for(Integer productId : idMap.keySet()){
			Product product =service.getProduct(productId.toString(), "productId");
			logger.info(product.toString());
            Integer NumberOfItems=idMap.get(productId);
            Integer itemTotal= (int) (product.getProductPrice()*NumberOfItems);
            Total=Total+itemTotal;
			productMap.put(product,NumberOfItems );
		}
		
		return productMap;
	}

	public double getTotal() {
		return Total;
	}

	public void setTotal(double total) {
		Total = total;
	}

	public Map<Integer, Integer> getCart() {
		
		return cart;
	}

	public void setCart(Map<Integer, Integer> cart) {
		this.cart = cart;
	}

	public void addToCart(String productId, int count) {
		Total=0;
		Integer productIdx=Integer.parseInt(productId);
		if (cart.containsKey(productIdx)) {
			cart.put(productIdx, cart.get(productIdx) + count);
		} else {
			cart.put(productIdx, count);
		}
	}

	public void removeFromCart(String productId, int count) {
		Total=0;
		Integer productIdx=Integer.parseInt(productId);
		if (cart.containsKey(productIdx)) {
		
			if (cart.get(productIdx) > count) {
				cart.put(productIdx, cart.get(productIdx) - count);
			}
			else{
				cart.remove(productIdx);
			}
			
		} 
	}
	
	public void clearCart(){
		Total=0;
		cart.clear();
	}
	

}
