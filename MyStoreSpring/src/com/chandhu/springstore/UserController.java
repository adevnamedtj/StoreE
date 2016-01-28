package com.chandhu.springstore;

import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chandhu.springstore.Model.User;
import com.chandhu.springstore.service.StoreService;

@Controller
@RequestMapping(value="/users")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	StoreService service;

	@RequestMapping(params="registration")
	public String craeteFormAndRedirect(Model model){
		
		model.addAttribute("modelUser",new User());
		return "user/register";
		
	}
	@RequestMapping(method=RequestMethod.POST)
	public String createAccount(@ModelAttribute("modelUser") @Valid User user,BindingResult result){
		if(result.hasErrors()){
			return "user/register";
		}
		service.addUser(user);
		return "redirect:/users/"+user.getUsername();
	}
	@RequestMapping(value="/auth", method=RequestMethod.GET)
	public String loginRedirect(){
		//model.addAttribute("modelUser",new User());
		return "user/auth";
		
	}
	@RequestMapping(value="/auth", method=RequestMethod.POST)
	public String AuthUser(@RequestParam String username, 
			@RequestParam String password,
			HttpSession session,Model model ){
		if(service.authUser(username, password)==true){
			User currentUser = new User();
			currentUser.setUsername(username);
			currentUser.setPassword(password);
			session.setAttribute("currentuser", currentUser);
			return "redirect:/";
		}
		model.addAttribute("ErrorMessage", "Please Enter Correct Username and Password");
		return "user/auth";
		
//		if(result.hasFieldErrors("username")){
//			return "user/auth";
//		}
//		if(result.hasFieldErrors("password")){
//			return "user/auth";
//		}
//		if(service.getUser(user.getUsername()).getPassword().equalsIgnoreCase(user.getPassword())){
//			logger.info(user.toString());
//			
//			return "redirect:/users";
//		}
//		return "user/auth";
	}
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String SessionKiller(HttpSession session){
		
		session.removeAttribute("currentuser");
		return "user/auth";
		
	}
	@RequestMapping(value="/{username}")
	public String getUserProfile(@PathVariable String username, Map<String, Object> model){
		model.put("user", service.getUser(username));
		
		return "user/profileInfo";
	}
	@RequestMapping(value="/{username}/edit", method=RequestMethod.GET)
	public String createEditForm(@PathVariable("username") String username,Map<String, Object> model){
		logger.info("createEditForm ==>");
		User user= service.getUser(username);
		model.put("modelUserEdit", user);
		System.out.println("GET");
		return "user/edit";
	}
	@RequestMapping(value="/{username}" , method= RequestMethod.POST)
	public String updateUser(@ModelAttribute("modelUserEdit") @Valid User user, BindingResult result){
		logger.info("UPDATE==>");
		if(result.hasErrors()){
			logger.info("error phase");
			return "user/edit";
		}
		logger.info("Update Ope Pass Through..!");
		User userEdited = service.editUser(user);
		System.out.println("edit aipoindi");
		return "redirect:/users/"+userEdited.getUsername();
	}
}
