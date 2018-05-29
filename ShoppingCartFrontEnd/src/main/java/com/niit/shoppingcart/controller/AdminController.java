package com.niit.shoppingcart.controller;



import java.util.List;



import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.servlet.ModelAndView;


import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.dao.CategoryDAO;

import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.dao.UserDAO;

import com.niit.shoppingcart.domain.Category;

import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;
import com.niit.shoppingcart.domain.User;



@Controller

public class AdminController {

	

	@Autowired

	private CategoryDAO categoryDAO;

	

	@Autowired

	private Category category;

	

	@Autowired

	private UserDAO userDAO;

	

	@Autowired

	private User user;

	

	

	@Autowired

	private ProductDAO productDAO;

	

	@Autowired

	private Product product;

	

	@Autowired

	private SupplierDAO supplierDAO;

	

	@Autowired

	private Supplier supplier;
	

	@Autowired

	private HttpSession httpSession;

	

	@GetMapping("/manage_categories")

	public ModelAndView manageCategories()

	{

		ModelAndView mv = new ModelAndView("admin");

		mv.addObject("isAdminClickedManageCategories", true);

		//load all the categories and set to httpSession

		List<Category> categories =  categoryDAO.list();
		
		httpSession.setAttribute("categories", categories);

		

		return mv;

	}

	

	@GetMapping("/manage_suppliers")

	public ModelAndView manageSuppliers()

	{

		
		ModelAndView mv = new ModelAndView("admin");

		mv.addObject("isAdminClickedManageSupplires", true);

		

		//List<User> suppliers = userDAO.list('S');
		List<Supplier> suppliers = supplierDAO.list();
		  List<Category> categories =  categoryDAO.list();
	        
	      
	        mv.addObject("categories", categories);
		

		httpSession.setAttribute("suppliers", suppliers);

		System.out.print("----------------Came back to Adminclicked----------------");
		System.out.println(suppliers);

		return mv;

	}

	

	@GetMapping("/manage_products")

	public ModelAndView manageProducts()

	{

		ModelAndView mv = new ModelAndView("admin");

		mv.addObject("isAdminClickedManageProducts", true);

		

		List<Product> products =  productDAO.list();

		httpSession.setAttribute("products", products);
		
		List<Category> categories =  categoryDAO.list();
        mv.addObject("categories", categories);


		

		return mv;

	}



}
