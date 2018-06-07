package com.niit.shoppingcart.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.CartDAO;
import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.ProductDAO;
import com.niit.shoppingcart.dao.UserDAO;
import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Product;



@Controller
public class CartController {
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private Cart cart;
	
	@RequestMapping("/user/cart")
	public ModelAndView myCart()
	{
		ModelAndView mv = new ModelAndView("order");
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		
		//System.out.println("------principal namr-----"+currentPrincipalName);
		
	List<Cart> cart =  cartDAO.getCartdetails(currentPrincipalName);
	        
		    mv.addObject("cart", cart);
		    List<Category> categories =  categoryDAO.list();
	        mv.addObject("categories", categories);
	        //mv.addObject("msg", msg);
		    
			return mv;
			
		}
	
	@RequestMapping("/user/order")
	public ModelAndView addingCart(@RequestParam("id") String id)
	{
		ModelAndView mv= new ModelAndView();
		
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		
		
		System.out.println("------principal namr-----"+currentPrincipalName);
		
		Product p=productDAO.get(id);
		 List<Cart> ca = cartDAO.findCart(id,currentPrincipalName);
		 if(p.getStock()>0)
		 {
			 mv.setViewName("redirect:/user/cart");
			 
			 
			Cart c;
			if(ca.isEmpty())
			{
				 c=new Cart();
	    		   c.setQuantity(1);
	    	    c.setUser(userDAO.get(currentPrincipalName));
	 	        c.setProduct(p);
	 	       c.setQuantity(1);
	 		    c.setAdded_date(new Date(System.currentTimeMillis()));
	 		    c.setStatus('T');
	 	        cartDAO.save(c);
	 	        p.setStock(p.getStock()-1);
	 	      productDAO.update(p);
	 	  		mv.addObject("msg","successfully added to cart");
				
				
			}
			 else{
	    		  
				 System.out.println("------entered else part----");
				c=ca.get(0);
	    		   c.setQuantity(c.getQuantity()+1);
	    		   System.out.println("---------quantity--------"+c.getQuantity());
	    		   cartDAO.update(c);
	    		   p.setStock(p.getStock()-1);
	 	 	      productDAO.update(p);
	    		   mv.addObject("msg","successfully Updated to cart");
	    	   
	        }
			 
			 
		 }
			 
		 else
		 {
			 mv.setViewName("redirect:/ProductDetails?id="+id);
			 mv.addObject("msg","No stock of the product");
			 System.out.println("No stock of the product");
		 }
		/*cart.setProduct(productDAO.get(id));
		cart.setUser(userDAO.get(currentPrincipalName));
		cart.setQuantity(1);
	    cart.setAdded_date(new Date(System.currentTimeMillis()));
	    cart.setStatus('T');
		List<Category> categories =  categoryDAO.list();
		if (cartDAO.save(cart)) {

			mv.addObject("message", "You successfully added cart");

		} else {

			mv.addObject("message", "Could not add.  please try after some time.");



		}*/
		
	    
	    
		return mv;
		
	}
	
	
	@RequestMapping("/user/delete")
	public ModelAndView deleteCart(@RequestParam("id") int id)
	{
		ModelAndView mv = new ModelAndView("redirect:/user/cart");
		
		
		Cart c1=cartDAO.get(id);
		
		
		int quantity=c1.getQuantity();
		
		System.out.println("---------Entered update cart"+quantity);
		
		
		if (cartDAO.delete(c1)) {
			Product p1=new Product();
			 p1=c1.getProduct();
			p1.setStock(p1.getStock()+quantity);
			productDAO.update(p1);

			mv.addObject("msg", "You successfully deleted cart");

		} else {

			mv.addObject("msg", "Could not add.  please try after some time.");



		}
		
        

        
		return mv;
		
	
	}
	
	
	@RequestMapping("/user/updatecart")
	public ModelAndView updatecart(@RequestParam("id") int id,@RequestParam("quantity") int quantity)
	{
		
		
		System.out.println("---------Entered update cart"+quantity);
		ModelAndView mv = new ModelAndView("redirect:/user/cart");
		
		
		
		Product p1=new Product();
		Cart c1=cartDAO.get(id);
		//int pid=c1.P_ID;
		 p1=c1.getProduct();
		
		 int quantity1=p1.getStock()-quantity;
		
		if(quantity1>=0)
		{
			p1.setStock(p1.getStock()-quantity1);
			c1.setQuantity(quantity);
			cartDAO.update(c1);
			productDAO.update(p1);
			
		}
		
		else
		{
System.out.println("No quantity avaliable");
			/*if(quantity>c1.getQuantity())
			
			{
				
				p1.setStock(p1.getStock()-1);
			}
			else
			{
				
				p1.setStock(p1.getStock()+1);
			
			}*/
			
		}
		
		
		
		
	
		
        

        
		return mv;
		
	
	}
}
