package com.niit.shoppingcart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	
	@PostMapping("/validate")
	public ModelAndView validate(@RequestParam("userName") String userName, 
			@RequestParam("userPassword") String userPassword)
	{
		System.out.println("method validate is called");
		//always we supposed to navigate to homue only.
		ModelAndView mv = new ModelAndView("home");
		
		//temporarily I am assuing that id : niit
		//password L  niit@123 - are valid
		
		if(userName.equals("niit") && userPassword.equals("niit@123"))
		{
			//success message
			mv.addObject("msg", "welcome Mr/Ms "+ userName);
		}
		else
		{
		//error message
			mv.addObject("msg", "Invalid credentials...pleas try again");
			
			
		}
		return mv;
		
	}

}
