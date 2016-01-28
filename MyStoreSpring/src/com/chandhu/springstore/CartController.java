package com.chandhu.springstore;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.Model.Purchase;
import com.chandhu.springstore.Model.User;
import com.chandhu.springstore.beans.Cart;
import com.chandhu.springstore.service.StoreService;

@Controller
public class CartController {

	@Autowired
	StoreService service;
	@Autowired
	private Cart cart;
	
	public static final Logger logger= LoggerFactory.getLogger(CartController.class);
	
	
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String home( Model model) {
		logger.info("cart Loaded");
        model.addAttribute("products", cart.cartMapConverter(cart.getCart()));
        model.addAttribute("totalPrice", cart.getTotal());
		return "user/cart";
	}
	@RequestMapping(value="cart/add/{productId}")
	public String addItemToCart(@PathVariable("productId") String productId, 
			@RequestHeader("referer") String referedform){
		//Product product = service.getProduct(productId, "productId");
		cart.addToCart(productId, 1);
		logger.debug("added to cart"+productId, productId);
		logger.info("added to cart"+productId.toString());
		return "redirect:"+referedform;
	}
	@RequestMapping(value="cart/remove/{productId}")
	public String removeItemToCart(@PathVariable("productId") String productId, 
			@RequestHeader("referer") String referedform){
		//Product product = service.getProduct(productId, "productId");
		cart.removeFromCart(productId, 1);
		logger.debug("removed from cart"+productId, productId);
		logger.info("removed from cart"+productId.toString());
		return "redirect:"+referedform;
	}
	@RequestMapping(value="cart/clear")
	public String clearCart( @RequestHeader("referer") String referedform){
		cart.clearCart();
		logger.info("Total Cart Was Clear");
		return "redirect:"+referedform;
	}
	@RequestMapping(value="cart/finalise")
	public String finalizeCart( @RequestHeader("referer") String referedform, HttpSession session){
		Map<Product, Integer> finalizeCart=cart.cartMapConverter(cart.getCart());
		for(Product product:finalizeCart.keySet()){
			User user= service.getUser(((User) session.getAttribute("currentuser")).getUsername());
			Integer productId= product.getProductId();
			Integer price =(int) product.getProductPrice();
			Purchase purchase = new Purchase(
					user.getUserId(),
					productId,
					12345672,
					finalizeCart.get(product),
					price
					);
			logger.info(purchase.toString());
			service.addPurchase(purchase);
			
			
		}
			
		
		cart.clearCart();
		logger.info("Total Cart Was Clear");
		return "redirect:"+referedform;
	}
}
