package com.niit.shoppingcart.dao.impl;



import java.sql.Date;

import java.util.List;



import javax.transaction.Transactional;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;



import com.niit.shoppingcart.dao.CategoryDAO;

import com.niit.shoppingcart.dao.ProductDAO;

import com.niit.shoppingcart.domain.Product;



///need to add  @Transactional

@Repository("productDAO")

@Transactional

public class ProductDAOImpl  implements ProductDAO{

	

	

	//Declare the SessionFactory -supposed automatically injected in the class

	@Autowired

	private SessionFactory sessionFactory;



	public boolean save(Product product) {

		try {

			product.setAdded_date(new Date(System.currentTimeMillis()));

			sessionFactory.getCurrentSession().save(product);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}

		

		

	}



	public boolean update(Product product) {



		try {
			product.setAdded_date(new Date(System.currentTimeMillis()));

			sessionFactory.getCurrentSession().update(product);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}

		

		

	

		

	}



	public boolean delete(String name) {



		try {

			//if the product exist, then only delete

			Product product = get(name);

			if(product==null)

			{

				return false;

			}

			sessionFactory.getCurrentSession().delete(product);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}

		

		

	

		

	}



	public Product get(String id) {

		

	return	(Product) sessionFactory.getCurrentSession().get(Product.class,id);

		

	}



	public List<Product> list() {

		

	return	sessionFactory.getCurrentSession().createQuery("from Product").list();

		

	}



	public List<Product> list(int id) {
		// TODO Auto-generated method stub
		return	sessionFactory.getCurrentSession().createQuery("from Product where id="+id).list();

	}
	
	public List<Product> getFilterProducts(int id)
	{
Session s=sessionFactory.openSession();
		
		List<Product> results =s.createQuery("from Product where C_ID="+id).list();
		s.close();
		// TODO Auto-generated method stub
		return results;
	}



	public List<Product> list(int minAmount, int MaxAmout) {
		// TODO Auto-generated method stub
		return null;
	}



	public List<Product> list(String productName, int minAmount, int MaxAmout) {
		// TODO Auto-generated method stub
		return null;
	}



}

