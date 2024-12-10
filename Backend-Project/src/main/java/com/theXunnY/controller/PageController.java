package com.theXunnY.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.theXunnY.entity.User;
import com.theXunnY.service.UserServiceImpl;

@Controller
public class PageController {
	
	@Autowired
	private UserServiceImpl service;

	@RequestMapping("/")
	public String home(Model model) {
		
		
		User user= new User();
		model.addAttribute("user", user);
		return "home";
	}
	
	@PostMapping("/register")
	public String saveUser(@ModelAttribute User user1, RedirectAttributes redirectAttributes) {
		if(service.findByEmail(user1.getEmail())!=null) {
			redirectAttributes.addFlashAttribute("msg", "Email Id Already Exist's Please Try again with some new Email id");
			return "redirect:/";
		}
		
		if(user1!=null) {
			User user=new User();
					user.setFirstName(user1.getFirstName());
					user.setLastName(user1.getLastName());
					user.setEmail(user1.getEmail());
					user.setPhNumber(user1.getPhNumber());
					user.setPassword(user1.getPassword());
					
			redirectAttributes.addFlashAttribute("registrationSuccess", true);
			service.saveUser(user);
			return "redirect:/";
		}
		

		return "/";
	}
	
	
	@RequestMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}
	

	@RequestMapping("/contactMe")
	public String contactMe(Model model) {
		model.addAttribute("user", new User());
		return "/fragments/contactMe";
	}
	
}
