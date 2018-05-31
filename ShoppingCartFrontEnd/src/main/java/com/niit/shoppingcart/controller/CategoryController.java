package com.niit.shoppingcart.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;



@Controller

public class CategoryController {
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private Category category;
	
	@Autowired
	private HttpSession httpSession;
	
	@RequestMapping("admin/category/save")
	public ModelAndView saveProduct(
			@RequestParam String name, 
			@RequestParam String description) {

		ModelAndView mv = new ModelAndView("redirect:/admin");
		category.setDescription(description);
		category.setName(name);
		category.setAdded_date(new Date(System.currentTimeMillis()));

		if (categoryDAO.save(category)) {

			mv.addObject("message", "You successfully added category");

		} else {

			mv.addObject("message", "Could not add.  please try after some time.");



		}

		
		
		//String value should be converted into integer
		
		
		
		// need to write one more condition.
		/*if (productDAO.save(product)) {
			mv.addObject("message", "Product created Successfully");
			return mv;
		} 
		
		else {
			mv.addObject("message", "Could not create product.");

		}*/
		return mv;

	}
	
	@RequestMapping("admin/category/update")
	public ModelAndView updateC(
			@RequestParam String name, 
			@RequestParam String description) {

		ModelAndView mv = new ModelAndView("redirect:/admin");
		category.setDescription(description);
		category.setName(name);
		category.setAdded_date(new Date(System.currentTimeMillis()));

		if (categoryDAO.update(category)) {

			mv.addObject("message", "You successfully Updated category");

		} else {

			mv.addObject("message", "Could not Updated.  please try after some time.");



		}
		return mv;
	}

	
	
	@RequestMapping("admin/category/delete")
	public ModelAndView deleteProduct(@RequestParam int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/admin");
		
		if(categoryDAO.delete(categoryDAO.get(id)))
		{
			mv.addObject("message", "The category successfully deleted");
		}
		else
		{
			mv.addObject("message", "Could not delete the product.  Please try after some time.");
		}
		return mv;
	}
	
	
	
	
	@RequestMapping("admin/category/edit")
	public ModelAndView editProduct(@RequestParam("id") int id)
	{
		ModelAndView mv = new ModelAndView("updateC");
	    category = categoryDAO.get(id);
		
		mv.addObject("category", category);
		//httpSession.setAttribute("selectedProduct", product);
		//why we need to have mv as we are using httpSession;
		
		return mv;
		
		//return "redirect:/manage_products";
	}
	
	

	

}
