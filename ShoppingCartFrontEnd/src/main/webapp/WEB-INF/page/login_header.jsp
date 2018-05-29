<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 


    pageEncoding="ISO-8859-1"%> 


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> 


<html lang="en"> 


<head> 

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <title>Shopping Hub</title> 


  <meta charset="utf-8"> 


 <meta name="viewport" content="width=device-width, initial-scale=1"> 

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> 


 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script> 


  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 

<link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head> 


<body class="headerbackground"> 

<nav  class="navbar navbar-inverse">
  <div class="container-fluid" style="background-color:navy;">
    <div class="navbar-header">
      <a class="navbar-brand" href="./">
     Gadgets
     
     
      </a>
    </div>
    <ul class="nav navbar-nav">
       <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Categories
        <span class="caret"></span></a>
        <ul class="dropdown-menu">
       <!--   <li><a href="#">Page 1-1</a></li>
          <li><a href="#">Page 1-2</a></li>
          <li><a href="#">Page 1-3</a></li>
          -->
          
           <c:forEach var="category" items="${categories}">

							<li><a href="ProductPage?id=${category.id}">${category.name}</a></li>

						</c:forEach>
						

          
          
        </ul>
       
        
      </li>
      
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="register"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
</body> 


</html>  
