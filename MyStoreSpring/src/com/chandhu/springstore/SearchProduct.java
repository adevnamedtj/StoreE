package com.chandhu.springstore;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chandhu.springstore.Model.Category;
import com.chandhu.springstore.Model.Product;
import com.chandhu.springstore.service.StoreService;

@Controller
@RequestMapping("/products")
public class SearchProduct {

	@Autowired
	StoreService service;
	@Autowired
	ProductSearchValidator psv;

	@RequestMapping("/search")
	public String searchForm(Model model) {
		model.addAttribute("product", new Product());
		return "product/search";
	}

	@ModelAttribute("Categories")
	public List<Category> getCategories() {
		List<Category> s = new ArrayList<>();
		s.add(new Category("All", "EveryThing"));
		for (Category category : service.getCategories().values()) {
			s.add(category);
		}

		return s;

	}

	@RequestMapping(method = RequestMethod.GET)
	public String getSearchProducts(Product product, BindingResult bindingResult, Model model) {

		List<Product> productsList = service.getProductsBySearch(product);
		//List<Product> productsList =new ArrayList<>();
		//productsList.add(service.getProduct(product));
		if (productsList.size() < 1) {
			bindingResult.rejectValue("productName", "404-NOT FOUND",
					"We are soory, we cannot found the product you are looking for");
		}
//		if(productsList.size()>=1){ //for single product redirect
//			return
//		}
		model.addAttribute("productsList", productsList);
		return "product/search";

	}
	
	@InitBinder
	private void initBinder(WebDataBinder binder){
		binder.setValidator(psv);
		binder.setAllowedFields("productName","productCategory");
	}

}
