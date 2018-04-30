package com.niit.shoppingcart.controller;

import org.springframework.http.HttpRequest;
//convert this class into Servlet /Controller
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;



//convert this class into Servlet / Controller

@Controller

public class HomeController {

	

	//we have to define hadler mapping

	//Different types of mappings

	//@GetMapping - doGet

	//@PostMapping - doPost  - create

	//@PutMapping	-doPut   - update

	//@DeleteMapping - doDelete - delete

	

	

	//   http://localhost:8080/shoppingcart/

		@GetMapping("/")

	//@RequestMapping(value="/",   method = RequestMethod.GET)

	public ModelAndView homePage()

	{
        ModelAndView mv=new ModelAndView("home");
			System.out.println("The method homePage is called");
        mv.addObject("msg", "");
		return mv;

	}

		

	//http://localhost:8080/shoppingcart/login	

	@GetMapping("/login")	

	public ModelAndView login() 


 	{ 

	System.out.println("login method called"); 


	ModelAndView mv = new ModelAndView("login"); 


		//mv.addObject("loginMessage", "Thank for login"); 


		mv.addObject("isUserClickedLogin", true); 
		


		return mv; 





 	} 

	//http://localhost:8080/shoppingcart/register

		@GetMapping("/register")	

		

	public ModelAndView registration()

	{

			
		System.out.println("registration method called");
		
		ModelAndView mv= new ModelAndView("register");	 


			 


			//carry the data 


			//mv.addObject("msg", "Thank you for registration"); 


		mv.addObject("isUserClickedRegister", true); 


			return mv;
		

	}
@GetMapping("/logout")
	public ModelAndView logout()
	{

	ModelAndView mv=new ModelAndView("logout");
	mv.addObject("msg","Thank u for registration");
System.out.println("logout method called");
return mv;
	
	}
	

	

	

	

	

	

	

	

	

	

	

	

	

	



}