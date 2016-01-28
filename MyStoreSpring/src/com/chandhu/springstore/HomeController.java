package com.chandhu.springstore;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chandhu.springstore.Dao.Dao;
import com.chandhu.springstore.Model.Category;
import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.Model.Purchase;
import com.chandhu.springstore.Model.User;
import com.chandhu.springstore.service.StoreService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	private StoreService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
//		Date date = new Date();
//		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
//		String formattedDate = dateFormat.format(date);
//		model.addAttribute("serverTime", formattedDate);
		
		
		model.addAttribute("products", service.getProducts().values());
		//model.addAttribute("products", service.getproductsByCategory("laptop").values());
		return "home";
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test(Locale locale, Model model) {
		logger.info("Testing PASSED {}.", "<3");
		
	// =============================================================================
		// Testing SerVice & DAO
		// =============================================================================
		// adding category & products
		// mainloader(p);
		// System.out.println(service.addPurchase(new
		// Purchase(2357,10)).toString());
		// System.out.println(service.addPurchase(new
		// Purchase(2757,8)).toString());
		// System.out.println(service.addPurchase(new
		// Purchase(2957,2)).toString());
		// String username ="chandhu";
		// String password="V134hjd";
		// String fullName="teja Ravi C Kalagara";
		// String Address="Nikenduku Bhey";
		// String card="nennivanu ga";
		// Integer userId=null;
		// for( int i=0;i<=10;i++){
		// System.out.println("ADDING "+
		// service.addUser(new User(username+i, password+i, fullName, Address,
		// card, userId)).toString()
		//
		//
		// );
		// for( int i=3;i<=6;i++){
		// System.out.println("Getting
		// "+service.getUser(username+i).toString());
		// }
		// }

		//
		// for(int i=0;i<30;i++){
		//
		// StoreService.add
		//
		// }
		// testing Remover;
		// for(Integer i=1; i<=9; i++){
		// service.remover("purchase", "purchaseId", i.toString());
		// }

		// testing getter user
//		System.out.println("USERS=============================================================================");
//		// public Map<String, User> getUsers();
//		for (User user : service.getUsers().values()) {

//			System.out.println("=============================================================================");
//			System.out.println(user.toString());
//			System.out.println("=============================================================================");
//			// public void removeUser(User user); REMOVING USER
//			service.removeUser(user);
//			System.out.println("REMOVING USER");
//			// public User addUser(User user); ADDING BACK
//			System.out.println("ADDING BACK" + service.addUser(user).toString());
//			// public User getUser(String UserName); GETTING AGAIN
//			System.out.println("GETTING AGAIN" + service.getUser(user.getUsername()).toString());
			// public User editUser(User user);
			// System.out.println("EDITING USER" + service.editUser(
			// new User(
			// //String username, String password, String fullName, String
			// address, String card, Integer userId
			// user.getUsername()+x,
			// user.getPassword()+x,
			// user.getFullName()+x,
			// user.getAddress()+x,
			// user.getCard()+1,
			// user.getUserId()
			// )));
			// System.out.println("RESETING BACK" +
			// service.addUser(user).toString());

		//}

		// System.out.println("CATEGORIES========================================================================");
		// for(Category category: service.getCategories().values()){
		// System.out.println(category.toString());
		// }
		// System.out.println("PRODUCTS==========================================================================");
		// for(Product product: service.getProducts().values()){
		// System.out.println(product.toString());
		// }

		// =============================================================================

		return "home";
	}

	public StoreService getService() {
		return service;
	}

	public void setService(StoreService service) {
		this.service = service;
	}
	//==============================================================================================
	          ///////////////        /////////////////         ////////////////      //////////////
				   ///               ///                       ///                        ///
            	   ///               ///                       ///                        ///
	   			   ///               ///                       ///                        ///
	               ///               ////////////////          ///////////////            ///
	               ///               ///                                   ///            ///
                   ///               ///                                   ///            ///
                   ///               ///                                   ///            ///
                   ///               ////////////////          ///////////////            ///
	//==============================================================================================
	// public void mainloader(int p){
	// System.out.println(service.addCategory(new Category("Category"+p,"v
	// "+p+"these are cars are expensive")).toString());
	//
	// if(p<=6){
	// subloader(p);
	// }
	// p++;
	//
	// }
	// public void subloader(int p){
	// String category = "category"+p;
	// String product ="product "+x;
	// for(int i=0;i<=10;i++){
	// System.out.println(
	// service.addProduct(
	// new Product(
	// product,
	// 0 ,
	// (float)10.50*i,
	// category,
	// "v
	// "+i+"productkadoasjwwekjawbfkjakajdakdakdnkdnakdnakdnkdndijaajaejnakdnakdsnkdnkdnkdjnjndkand
	// Description"
	// )).toString());
	// x++;
	//
	// if(i>=10){
	// mainloader(p);
	//
	// }
	//
	//
	// }
	//
	// }

}
