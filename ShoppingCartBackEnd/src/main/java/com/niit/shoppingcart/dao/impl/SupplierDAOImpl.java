package com.niit.shoppingcart.dao.impl;

import java.sql.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Category;
import com.niit.shoppingcart.domain.Supplier;

@Repository
@Transactional
public class SupplierDAOImpl implements SupplierDAO {

	@Autowired

	private SessionFactory sessionFactory;

	public boolean save(Supplier supplier) {
		
		
		try {

			//set the current system date to category

			

			sessionFactory.getCurrentSession().save(supplier);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}
		// TODO Auto-generated method stub
		
	}

	public boolean update(Supplier supplier) {
		try {

			sessionFactory.getCurrentSession().update(supplier);

			return true;

		} catch (HibernateException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

			return false;

		}
	}

	public boolean delete(Supplier supplier) {
		// TODO Auto-generated method stub
		 sessionFactory.getCurrentSession().delete(supplier);
		return true;

	}

	public Supplier get(int id) {
		// TODO Auto-generated method stub
		return	(Supplier) sessionFactory.getCurrentSession().get(Supplier.class,id);

	}

	public List<Supplier> list() {
		// TODO Auto-generated method stub
		return	sessionFactory.getCurrentSession().createQuery("from Supplier").list();
	}

	


	
	
	
	}


