<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><!-- 
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script> -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="login_header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
body {
  font-family: Arial;
  font-size: 17px;
  padding: 8px;
}

* {
  box-sizing: border-box;
}

.row {
  display: -ms-flexbox; /* IE10 */
  display: flex;
  -ms-flex-wrap: wrap; /* IE10 */
  flex-wrap: wrap;
  margin: 0 -16px;
}

.col-25 {
  -ms-flex: 25%; /* IE10 */
  flex: 25%;
}

.col-50 {
  -ms-flex: 50%; /* IE10 */
  flex: 50%;
}

.col-75 {
  -ms-flex: 75%; /* IE10 */
  flex: 75%;
}

.col-25,
.col-50,
.col-75 {
  padding: 0 16px;
}

.container {
  background-color: #f2f2f2;
  padding: 5px 20px 15px 20px;
  border: 1px solid lightgrey;
  border-radius: 3px;
}

input[type=text] {
  width: 100%;
  margin-bottom: 20px;
  padding: 12px;
  border: 1px solid #ccc;
  border-radius: 3px;
}

label {
  margin-bottom: 10px;
  display: block;
}

.icon-container {
  margin-bottom: 20px;
  padding: 7px 0;
  font-size: 24px;
}

.btn {
  background-color: #4CAF50;
  color: white;
  padding: 12px;
  margin: 10px 0;
  border: none;
  width: 100%;
  border-radius: 3px;
  cursor: pointer;
  font-size: 17px;
}

.btn:hover {
  background-color: #45a049;
}

a {
  color: #2196F3;
}

hr {
  border: 1px solid lightgrey;
}

span.price {
  float: right;
  color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media (max-width: 800px) {
  .row {
    flex-direction: column-reverse;
  }
  .col-25 {
    margin-bottom: 20px;
  }
}
</style>
<title>Insert title here</title>
</head>
<body>

  <div class="col-75">
    <div class="container">
      <form action="${pageContext.request.contextPath}/user/confirm" method="post">
      
        <div class="row">
          <div class="col-50">
            <h3>Billing Address</h3>
            <label for="fname"><i class="fa fa-user"></i> Full Name</label>
            <input type="text" id="fname" name="name"  value="${u.name}">
            <label for="email"><i class="fa fa-envelope"></i> Email</label>
            <input type="text" id="email" name="email" value="${u.emailID}">
            <label for="adr"><i class="fa fa-address-card-o"></i> Address</label>
           
            <input type="text" id="adr" name="address"  value="${u.address}">
            
            <td><input type="submit" class="btn btn-success btn-block" value="Confirm Order"><i class="fa fa-angle-right"></i></input></td>
            
             <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing
             </form>
          <!--  
            <label for="city"><i class="fa fa-institution"></i> City</label>
            <input type="text" id="city" name="city" placeholder="New York">
          -->  



 
           <!--   <div class="row">
              <div class="col-50">
                <label for="state">State</label>
                <input type="text" id="state" name="state" placeholder="NY">
              </div>
              <div class="col-50">
                <label for="zip">Zip</label>
                <input type="text" id="zip" name="zip" placeholder="10001">
              </div>
            </div>
            -->
          </div>
          

          <div class="col-50">
            <!--  <h3>Payment</h3>
            <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
            <label for="cname">Name on Card</label>
            <input type="text" id="cname" name="cardname" placeholder="John More Doe">
            <label for="ccnum">Credit card number</label>
            <input type="text" id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444">
       -->
       
       
       
           <!--  
            <label for="expmonth">Exp Month</label>
            <input type="text" id="expmonth" name="expmonth" placeholder="September">
            <div class="row">
              <div class="col-50">
                <label for="expyear">Exp Year</label>
                <input type="text" id="expyear" name="expyear" placeholder="2018">
              </div>
              <div class="col-50">
                <label for="cvv">CVV</label>
                <input type="text" id="cvv" name="cvv" placeholder="352">
              </div>
            </div>
          </div>
           
        </div>
        <label>
        
      <!--      <input type="checkbox" checked="checked" name="sameadr"> Shipping address same as billing-->
      
       <table id="cart" class="table table-hover table-condensed">
    				<thead>
						<tr>
							<th style="width:50%">Product</th>
							
							<th style="width:10%">Price</th>
							<th style="width:8%">Quantity</th>
							<th style="width:22%" class="text-center">Subtotal</th>
							<th style="width:10%"></th>
						</tr>
					</thead>
					<tbody>
						<tr>
						<c:forEach var="c" items="${cart}" >
							<td data-th="Product">
							 
								<div class="row">
									<div class="col-sm-4 hidden-xs"><img src="${pageContext.request.contextPath}/resources/images/${c.product.id}.jpg" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${c.product.name}</h4>
										<p>${c.product.description}</p>
									</div>
								</div>
								
							</td>
							<td data-th="Price">${c.product.price}</td>
							
							  <td data-th="Quantity">
							  
							 
						    <input type="number" name="quantity" class="form-control text-center" min="1" value="${c.quantity}" readonly="readonly">
							
							
							</td>
							
							
							
							
							<td data-th="Subtotal" class="text-center">${c.product.price*c.quantity}</td>
							<td class="actions" data-th="">
							
								    <!--  <button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>-->
								  
								
								 <!--  <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>	-->
								  
								  <br>
								  <!--   <a href="${pageContext.request.contextPath}/user/updatecart?id=${c.id}" class="btn btn-danger btn-sm">UPDATE
								   </a>
								   
								   -->
								  </br>
							<!--  <a href="#" class="btn btn-danger btn-sm">DELETE-->
								<!--  <i class="fa fa-angle-right"></i>-->
								</a>
														
							</td>
						</tr>
					</tbody>
					</c:forEach>
					<tfoot>
					
					<!--  
						<tr class="visible-xs">
							<td class="text-center"><strong>Total 1.99</strong></td>
						</tr>
						
					-->
					
					
						<tr>
							
							<td colspan="2" class="hidden-xs"></td>
							
						
						<!--  	<td class="hidden-xs text-center"><strong>Total $1.99</strong></td>-->
						
						<c:set var="tot" value="0"></c:set>
                        <c:forEach items="${cart}" var="c">
                        <c:set var="t" value="${c.product.price*c.quantity}"></c:set>
                		<c:set var="tot" value="${tot+t}"/>
					</c:forEach>
							<td class="hidden-xs text-center"><strong>Total ${tot}</strong></td>
							
							<!--  <td><a href="check" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>-->
						
						
						</tr>
					</tfoot>
       
       
       
       
        </label>
        <!-- <input type="submit" value="checkout" class="btn"> -->
      </form>
    </div>
  </div>
  <!--  
  <div class="col-25">
    <div class="container">
      <h4>Cart <span class="price" style="color:black"><i class="fa fa-shopping-cart"></i> <b>4</b></span></h4>
      <p><a href="#">Prakash Sharee</a> <span class="price">Rs.15</span></p>
      <p><a href="#">Nishant Plazo</a> <span class="price">Rs.15</span></p>
      <p><a href="#">Innerwear</a> <span class="price">Rs.15</span></p>
      
      <hr>
      <p>Total <span class="price" style="color:black"><b>$30</b></span></p>
    </div>
  </div>
  -->
  
  
  
</div>


</body>
</html>