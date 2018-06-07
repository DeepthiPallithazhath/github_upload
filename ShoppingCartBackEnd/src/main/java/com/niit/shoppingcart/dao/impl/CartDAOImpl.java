package com.niit.shoppingcart.dao.impl;



import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.CartDAO;

import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Product;
import com.niit.shoppingcart.domain.Supplier;

@Repository("cartDAO")

@Transactional


public class CartDAOImpl implements CartDAO {



	@Autowired

	private SessionFactory sessionFactory;



	public boolean save(Cart cart) {

		try {

			sessionFactory.getCurrentSession().save(cart);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}

	}



	public boolean update(Cart cart) {

		try {

			sessionFactory.getCurrentSession().update(cart);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}

	}



	public boolean delete(Cart c) {

		try {

			sessionFactory.getCurrentSession().delete(c);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}

	}

	
	public List<Cart> findCart(String pid,String name) {
		Session s=sessionFactory.getCurrentSession();		
         List<Cart> results = s.createQuery("from Cart where P_ID='"+pid+ "'and U_ID='"+name+"'").list();		
		
			return results;
			
		
		
	}


	public List<Cart> list(String emailID) {



		// select * from cart where emailID = ? and status = 'N'



		return sessionFactory.getCurrentSession().createCriteria(Cart.class).add(Restrictions.eq("emailID", emailID))

				.add(Restrictions.eq("status", "N")).list();



	}

	public List<Cart> getCartdetails(String id)
	{
Session s=sessionFactory.openSession();
		
		List<Cart> results =s.createQuery("from Cart where U_ID='"+id+"'").list();
		s.close();
		// TODO Auto-generated method stub
		return results;
	}

	public boolean update(List<Cart> carts, char status) {
		// TODO Auto-generated method stub
		return false;
	}



	public Cart get(int id) {
		// TODO Auto-generated method stub
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class,id);
	}

	public Cart get(int id,String name) {
		// TODO Auto-generated method stub
		return (Cart) sessionFactory.getCurrentSession().get(Cart.class,id);
	}

}
