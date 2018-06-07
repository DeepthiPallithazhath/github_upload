package com.niit.shoppingcart.domain;



import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.niit.shoppingcart.domain.Product;



import org.springframework.stereotype.Component;



@Component   //will create instance of User class --- user

@Table 

@Entity

public class Cart {

	@Id

	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;


	@ManyToOne
	@JoinColumn(name="P_ID")	
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name="U_ID")	
	private User user;

	

	private int quantity;

	

	private char status;

	

	private Date added_date;



	public int getId() {

		return id;

	}



	public void setId(int id) {

		this.id = id;

	}




	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}

	
	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}
	

	public int getQuantity() {

		return quantity;

	}



	public void setQuantity(int quantity) {

		this.quantity = quantity;

	}







	public char getStatus() {

		return status;

	}



	public void setStatus(char status) {

		this.status = status;

	}



	public Date getAdded_date() {

		return added_date;

	}



	public void setAdded_date(Date added_date) {

		this.added_date = added_date;

	}

	

	

	

	



}