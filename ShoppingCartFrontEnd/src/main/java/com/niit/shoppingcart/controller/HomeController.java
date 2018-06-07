package com.niit.shoppingcart.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//convert this class into Servlet /Controller
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.OrdersDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Orders;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.User;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;


//convert this class into Servlet / Controller

@Controller

public class HomeController {


	@Autowired

	private CategoryDAO categoryDAO;
	
	@Autowired

	private ProductDAO productDAO;
	
	@Autowired
    private UserDAO userDAO;
	
	@Autowired
    private CartDAO cartDAO;
	
	@Autowired
    private OrdersDAO ordersDAO;
	
	@Autowired
	private Orders order;

	//we have to define hadler mapping

	//Different types of mappings

	//@GetMapping - doGet

	//@PostMapping - doPost  - create

	//@PutMapping	-doPut   - update

	//@DeleteMapping - doDelete - delete

	

	

	//   http://localhost:8080/shoppingcart/

	@RequestMapping("/")

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

	@RequestMapping("/login")	

	public ModelAndView login(@RequestParam("msg")String msg) 


 	{ 

	System.out.println("login method called"); 


	ModelAndView mv = new ModelAndView("login"); 
	
    List<Category> categories =  categoryDAO.list();
    
    
    mv.addObject("categories", categories);
    mv.addObject("msg", msg);
	
    return mv; 
 	} 

	//http://localhost:8080/shoppingcart/register

	@RequestMapping("/register")			

	public ModelAndView registration()

	{

			
		System.out.println("registration method called");
		
		ModelAndView mv= new ModelAndView("register");	 

			return mv;
		

	}
	@RequestMapping("/logout")
	public ModelAndView logout()
	{

	ModelAndView mv=new ModelAndView("logout");
	mv.addObject("msg","Thank u for registration");
System.out.println("logout method called");
return mv;
	
	}
	

	
	@RequestMapping("/ProductPage")
public ModelAndView displayProductPage(@RequestParam int id)
{
	ModelAndView mv = new ModelAndView("ProductPage");
	
	List<Product> products =productDAO.getFilterProducts(id) ;
	
		
	mv.addObject("products",products);
	
	List<Category> categories =  categoryDAO.list();
    
    
    mv.addObject("categories", categories);
	return mv;
	
}
	

	@RequestMapping("/ProductDetails")
public ModelAndView displayProductDetails(@RequestParam("id") int id,@RequestParam("msg") String msg)
{
	ModelAndView mv = new ModelAndView("ProductDetails");
	
	List<Product> products =productDAO.list(id) ;
	
		
	mv.addObject("products",products);
	
	List<Category> categories =  categoryDAO.list();
    
    
    mv.addObject("categories", categories);
    mv.addObject("msg", msg);
	return mv;
	
}
	/*@RequestMapping("/order")
public ModelAndView addingCart(@RequestParam("id") int id)
{
	ModelAndView mv = new ModelAndView("order");
	
	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	
	//System.out.println("------principal namr-----"+currentPrincipalName);
	
	List<Product> products =productDAO.list(id) ;
	
		
	mv.addObject("products",products);
	
	List<Category> categories =  categoryDAO.list();
    
    
    mv.addObject("categories", categories);
	return mv;
	
}*/
	
	@RequestMapping("/user/check")
public ModelAndView checkOut()
{
	
	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	
	//List<Product> products =productDAO.list(id) ;
	User u=new User();
	u=userDAO.get(currentPrincipalName);
	
	ModelAndView mv = new ModelAndView("checkout");	
	//mv.addObject("products",products);
	
	List<Category> categories =  categoryDAO.list();
    
	mv.addObject("u", u);
	
	List<Cart> cart =  cartDAO.getCartdetails(currentPrincipalName);
    
    mv.addObject("cart", cart);
    
    mv.addObject("categories", categories);
	return mv;
	
}
	
	
	@RequestMapping("/user/confirm")
public ModelAndView payBill(@RequestParam("name") String name,@RequestParam("email") String email,@RequestParam("address") String address)
{
	
	System.out.println("-------Entered pay check---------");
		
	ModelAndView mv = new ModelAndView("Thanku");	
	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	String currentPrincipalName = authentication.getName();
	
	
	//List<Product> products =productDAO.list(id) ;
	//User u=new User();
	//u=userDAO.get(currentPrincipalName);
	//Orders o=new Orders();
	order.setAddress(address);
	order.setUser(userDAO.get(currentPrincipalName));
	order.setEmailId(email);
	order.setName(name);
	
	if (ordersDAO.save(order)) {
		
		List<Cart> cart =  cartDAO.getCartdetails(currentPrincipalName);
		
		for(Cart c:cart)
		{
			cartDAO.delete(c);
		}

		mv.addObject("msg", "You successfully registered ");
		

	} else {

		mv.addObject("msg", "Could not register.  please try after some time.");



	}
	
	
	//mv.addObject("products",products);
	
	List<Category> categories =  categoryDAO.list();
    
	
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