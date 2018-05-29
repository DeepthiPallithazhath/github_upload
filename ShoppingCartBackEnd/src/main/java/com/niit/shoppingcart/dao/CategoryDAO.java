package com.niit.shoppingcart.dao;



import java.util.List;



import com.niit.shoppingcart.domain.Category;



public interface CategoryDAO {

	

	//create, update, delete, get, list

	

	//access_specifier return_type methodName(parameters)

	

	//create

	public  boolean   save(Category category); 
	

	//update

	public  boolean   update(Category category); 

	

	//delete

	public boolean delete(Category category);

	

	

	//get the category details based on name

	public Category get(int id);

	//get all the categories

	//select * from Category

	public List<Category>  list();






}