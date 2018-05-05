package com.niit.shoppingcart.domain;



import java.sql.Date;



import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;



import org.springframework.stereotype.Component;



@Component   //will create instance of User class --- user

@Table 

@Entity

public class Category {

	

	//add the properties - same as fields in Category Table.

	@Id

	private String category_name;

	

	private String description;

	

	private Date added_date;



	public String getName() {

		return category_name;

	}



	public void setName(String name) {

		this.category_name = name;

	}



	public String getDescription() {

		return description;

	}



	public void setDescription(String description) {

		this.description = description;

	}



	public Date getAdded_date() {

		return added_date;

	}



	public void setAdded_date(Date added_date) {

		this.added_date = added_date;

	}

	

	

	

	

	

	

	



}