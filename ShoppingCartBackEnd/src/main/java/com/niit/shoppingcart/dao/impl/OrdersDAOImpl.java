package com.niit.shoppingcart.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;

import com.niit.shoppingcart.domain.Cart;
import com.niit.shoppingcart.domain.Orders;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.HibernateException;

import com.niit.shoppingcart.dao.CategoryDAO;
import com.niit.shoppingcart.dao.OrdersDAO;

@Repository("ordersDAO")

@Transactional

public class OrdersDAOImpl implements OrdersDAO
{
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public boolean save(Orders order) {

		try {

			sessionFactory.getCurrentSession().save(order);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}

	}


}
