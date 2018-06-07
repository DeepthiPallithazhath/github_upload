package com.niit.shoppingcart.domain;



import java.beans.Transient;
import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import org.springframework.stereotype.Component;



@Component   //will create instance of User class --- user

@Table 

@Entity
public class Product {

	

	
    @Id
	private String id;
	
    
	private String name;

	

	private String description;

	

	private int price;
	private int stock;
    
	

	



	private Date added_date;

	

	//other annotations - @OneToMany  @ManyToOne

	//

	@ManyToOne
	@JoinColumn(name="C_ID")
	private Category category;
	@ManyToOne
	@JoinColumn(name="S_ID")
	private Supplier supplier;
/*
	@OneToMany(targetEntity=Cart.class,mappedBy = "product", cascade = CascadeType.ALL)
	Set<Cart> cart;
	
*/
	public String getId() {

		return id;

	}



	public void setId(String id) {

		this.id = id;

	}



	public String getName() {

		return name;

	}



	public void setName(String name) {

		this.name = name;

	}



	public String getDescription() {

		return description;

	}



	public void setDescription(String description) {

		this.description = description;

	}



	public int getPrice() {

		return price;

	}



	public void setPrice(int price) {

		this.price = price;

	}



	public Date getAdded_date() {

		return added_date;

	}



	public void setAdded_date(Date added_date) {

		this.added_date = added_date;

	}



	public Category getCategory() {
		return category;
	}



	public void setCategory(Category category) {
		this.category = category;
	}



	public Supplier getSupplier() {
		return supplier;
	}



	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}



	public int getStock() {
		return stock;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}

	


}