package com.niit.shoppingcart.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.User;


@Controller
public class RegisterController {
	
	@Autowired

	private UserDAO userDAO;

	@Autowired

	private User user;

	@Autowired

	private CategoryDAO categoryDAO;

	@Autowired

	private HttpSession httpSession;
	
	
	
	@RequestMapping("/register/save")

	public ModelAndView saveUser(@RequestParam String email,

			@RequestParam String username, @RequestParam String password, @RequestParam String confirm,

			@RequestParam String address,@RequestParam String mobile) {

		



		user.setAddress(address);

		user.setEmailID(email);

		user.setMobile(mobile);

		user.setName(username);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);

		user.setPassword(hashedPassword);

		user.setRole("ROLE_ADMIN");



		// check whether the record already exist

		// with this emaild or not

		// if existed, give message "The record already exist"

	/*	if (userDAO.get(emailID) != null) {

			mv.addObject("message", "The record already exist");



		} else

*/
		ModelAndView mv = new ModelAndView("redirect:/login");
		  List<Category> categories =  categoryDAO.list();
	        
	      
	        mv.addObject("categories", categories);

		if (userDAO.save(user)) {

			mv.addObject("msg", "You successfully registered ");
			

		} else {

			mv.addObject("msg", "Could not register.  please try after some time.");



		}



		return mv;



	}

	

}
