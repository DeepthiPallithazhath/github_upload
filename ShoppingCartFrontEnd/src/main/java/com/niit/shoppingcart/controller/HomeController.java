package com.niit.shoppingcart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
//convert this class into Servlet /Controller
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.dao.ProductDAO;


//convert this class into Servlet / Controller

@Controller

public class HomeController {


	@Autowired

	private CategoryDAO categoryDAO;
	
	@Autowired

	private ProductDAO productDAO;

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
        List<Category> categories =  categoryDAO.list();
        
      
        mv.addObject("categories", categories);
		return mv;
		

	}

		

	//http://localhost:8080/shoppingcart/login	

	@GetMapping("/login")	

	public ModelAndView login() 


 	{ 

	System.out.println("login method called"); 


	ModelAndView mv = new ModelAndView("login"); 
	


		//mv.addObject("loginMessage", "Thank for login"); 
List<Category> categories =  categoryDAO.list();
    
    
    mv.addObject("categories", categories);
	


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
	

	
@GetMapping("/ProductPage")
public ModelAndView displayProductPage(@RequestParam int id)
{
	ModelAndView mv = new ModelAndView("ProductPage");
	
	List<Product> products =productDAO.getFilterProducts(id) ;
	
		
	mv.addObject("products",products);
	
	List<Category> categories =  categoryDAO.list();
    
    
    mv.addObject("categories", categories);
	return mv;
	
}
	

/*@RequestMapping("/productFilter")
public ModelAndView productListFilter(HttpServletRequest request)
{ 
	List<Product> list=productDao.getFilterProducts(Integer.valueOf(request.getParameter("id")));
	//List<Product> list=productDao.getProducts();
	ModelAndView mv = new ModelAndView("productFilter");	
	mv.addObject("list",list);
	List<Category> c=categoryDao.getAllCategories();
	mv.addObject("catalist",c);
	return mv;
}*/

	

	

	

	

	

	

	

	

	

	



}