/*package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;

@Controller
public class UserController {
	
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private User user;
	
	@Autowired
	private CategoryDAO categoryDAO;
}*/
			
	/*@PostMapping("/validate")
	public ModelAndView validate(@RequestParam("userName") String userName, 
			@RequestParam("userPassword") String userPassword)
	{
		//always we supposed to navigate to home only.
		ModelAndView mv = new ModelAndView("login");
		
		
		//temporarily I am assuing that id : niit
		//password L  niit@123 - are valid
		//if(id.equals("niit") && password.equals("niit@123"))
		List<Category> categories =  categoryDAO.list();
	    
	    
	    mv.addObject("categories", categories);
		user = userDAO.validate(userName, userPassword);
		
		if(user!=null)
		{//valid user
			//success message
			mv.addObject("msg", "welcome Mr/Ms "+ user.getName());
			
			//find out role of the user
			
			if(user.getRole()=='A')
			{
				mv.addObject("isAdmin", true);
			}
			else if(user.getRole()=='C')
			{
				mv.addObject("isUser", true);
			}
			else if(user.getRole()=='S')
			{
				mv.addObject("isSupplier", true);
			}
		}
		else
		{
			//error message
			mv.addObject("msg", "Invalid credentials...pleas try again");
		}
		return mv;
		
	}

}
*/