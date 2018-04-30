package com.niit.shoppingcart;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//check whether User instance created or not
		//because we are configuring the beans using annotations
		//1.Annotations
		//2.xml based configuration
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
         //it will check the classes which are in the package
		//in this package with annotated @component
		context.scan("com.niit");
		//It will clear the exist beans
		//create new beans of the classes
		//which are in package com.niit
		//with annotated with @component
		context.refresh();
		//i need one instance as context
		context.getBean("user");
		System.out.println("Bean is created successfully");
	}

}
