package com.niit.shoppingcart.domain;



import java.sql.Date;

import javax.persistence.Id;
import javax.persistence.Table;



import org.springframework.stereotype.Component;



@Component   //will create instance of User class --- user

@Table 

public class Cart {
	
	
	@Id
	private int id;
	private String emailid;
	private String productname;
	private String quantity;
	private String status;
	private Date added_date;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getAdded_date() {
		return added_date;
	}
	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}

}