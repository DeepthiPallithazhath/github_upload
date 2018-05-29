package com.niit.shoppingcart.dao;

import java.util.List;

import com.niit.shoppingcart.domain.Supplier;

public interface SupplierDAO {
	
	public  boolean   save(Supplier supplier); 
	

	//update

	public  boolean   update(Supplier supplier); 

	

	//delete

	public boolean delete(Supplier supplier);

	

	

	//get the category details based on name

	public Supplier get(int id);

	//get all the categories

	//select * from Category

	public List<Supplier>  list();

}
