package com.niit.shoppingcart.dao;



import java.util.List;



import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Product;



public interface CartDAO {

	

	//add a product to cart

	

	public boolean save(Cart cart);

	
	public List<Cart> findCart(String pid,String name);
	public boolean update(Cart cart);

	

	public boolean update(List<Cart> carts, char status);

	public List<Cart> getCartdetails(String id);

	public boolean delete(Cart id);

	

	

	

	

	

	//get my products which added to mycart

	//select * from Cart where emailID = ?

	public  List<Cart>  list(String emailID);

	

	//get cart by cart id;

	

	public Cart    get(int id);

	public Cart    get(int id,String name);

	//get cart by email ID

	

	

	

	

	

	

	

	

	

	

	

	

	

	

	



}