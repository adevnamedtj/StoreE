package com.chandhu.springstore;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.chandhu.springstore.Model.Product;
@Component
public class ProductSearchValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Product product =(Product) target;
		if(!StringUtils.hasLength(product.getProductName()) && product.getProductCategory().equalsIgnoreCase("All")){
			errors.rejectValue("productName", "required", "Either a Name or a Category is required.");
		}
		if(product.getProductCategory().equalsIgnoreCase("All") && product.getProductName().trim().length()<3){
			errors.rejectValue("productName", "tooShort", "Please Enter min of 3 charecters");
		}

	}

}
