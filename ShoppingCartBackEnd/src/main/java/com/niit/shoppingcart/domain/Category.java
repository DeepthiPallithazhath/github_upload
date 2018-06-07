package com.niit.shoppingcart.domain;



import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;
import org.springframework.stereotype.Component;



@Component   //will create instance of User class --- user

@Table 

@Entity

public class Category {

	

	//add the properties - same as fields in Category Table.

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	

	private String category_name;

	

	private String description;

	

	private Date added_date;
	@OneToMany(targetEntity=Product.class,mappedBy = "category",cascade=CascadeType.ALL)
	Set<Product> products;



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getCategory_name() {
		return category_name;
	}



	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}



	public Set<Product> getProducts() {
		return products;
	}



	public void setProducts(Set<Product> products) {
		this.products = products;
	}



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