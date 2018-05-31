package com.niit.shoppingcart.controller;



import java.sql.Date;

import javax.servlet.http.HttpSession;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.GetMapping;

//import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.niit.shoppingcart.dao.SupplierDAO;
import com.niit.shoppingcart.domain.Supplier;


@Controller

public class SupplierController {


	@Autowired
	private SupplierDAO supplierDAO;

	@Autowired
	private Supplier supplier;
	

	

	@Autowired

	private HttpSession httpSession;



	@RequestMapping("admin/supplier/save")

	public ModelAndView saveSupplier(@RequestParam String name, @RequestParam String address) {

		ModelAndView mv = new ModelAndView("redirect:/admin");



		supplier.setAddress(address);

		

		supplier.setName(name);

		


		// check whether the record already exist

		// with this emaild or not

		// if existed, give message "The record already exist"

	/*	if (userDAO.get(emailID) != null) {

			mv.addObject("message", "The record already exist");



		} else

*/

		if (supplierDAO.save(supplier)) {

			mv.addObject("message", "You successfully registered as supplier");

		} else {

			mv.addObject("message", "Could not register.  please try after some time.");



		}



		return mv;



	}

	

	

	

	

	

	@RequestMapping("admin/supplier/delete")

	public ModelAndView deleteSupplier(@RequestParam int id)

	{

		
		
		ModelAndView mv = new ModelAndView("redirect:/admin");

	

		if (supplierDAO.delete(supplierDAO.get(id))) {

			mv.addObject("message", "Supplier successfully delete");

		} else {

			mv.addObject("message", "Could not delete.  please try after some time.");



		}



		return mv;

	}

	

	@RequestMapping("admin/supplier/update")
	public ModelAndView updateS(
			@RequestParam String name, 
			@RequestParam String address) {

		ModelAndView mv = new ModelAndView("redirect:/admin");
supplier.setAddress(address);

		

		supplier.setName(name);

		

		if (supplierDAO.update(supplier)) {

			mv.addObject("message", "You successfully Updated supplier");

		} else {

			mv.addObject("message", "Could not Updated.  please try after some time.");



		}
		return mv;
	}

	

	

	@RequestMapping("admin/supplier/edit")

	public  ModelAndView  editSupplier(@RequestParam("id") int id)

	{
		ModelAndView mv = new ModelAndView("updateS");
	   supplier = supplierDAO.get(id);
		
		mv.addObject("supplier", supplier);
		//httpSession.setAttribute("selectedProduct", product);
		//why we need to have mv as we are using httpSession;
		
		return mv;

		

	 

	}
	
	}

	

	

	

	

	

	

	

	

	

	

	

	

	

	



