<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="login_header.jsp"></jsp:include>
<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

.table>tbody>tr>td, .table>tfoot>tr>td{
    vertical-align: middle;
}
@media screen and (max-width: 600px) {
    table#cart tbody td .form-control{
		width:20%;
		display: inline !important;
	}
	.actions .btn{
		width:36%;
		margin:1.5em 0;
	}
	
	.actions .btn-info{
		float:left;
	}
	.actions .btn-danger{
		float:right;
	}
	
	table#cart thead { display: none; }
	table#cart tbody td { display: block; padding: .6rem; min-width:320px;}
	table#cart tbody tr td:first-child { background: #333; color: #fff; }
	table#cart tbody td:before {
		content: attr(data-th); font-weight: bold;
		display: inline-block; width: 8rem;
	}
	
	
	
	table#cart tfoot td{display:block; }
	table#cart tfoot td .btn{display:block;}
	
}
</style>
</head>
<body>
<div class="container">
<c:if test="${not empty msg}">
    <script type="text/javascript">
    alert("${msg}");
    </script>
 </c:if>
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
									<div class="col-sm-2 hidden-xs"><img src="${pageContext.request.contextPath}/resources/images/${c.product.id}.jpg" alt="..." class="img-responsive"/></div>
									<div class="col-sm-10">
										<h4 class="nomargin">${c.product.name}</h4>
										<p>${c.product.description}</p>
									</div>
								</div>
								
							</td>
							<td data-th="Price">${c.product.price}</td>
							
							  <td data-th="Quantity">
							   <form action="${pageContext.request.contextPath}/user/updatecart?id=${c.id}" method="post">
							  <div class="form-group">
							 
						    <input type="number" name="quantity" class="form-control text-center" min="1" value="${c.quantity}">
							<button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>
							</div>
							</form>
							
							</td>
							
							
							
							
							<td data-th="Subtotal" class="text-center">${c.product.price*c.quantity}</td>
							<td class="actions" data-th="">
							
								    <!--  <button class="btn btn-info btn-sm"><i class="fa fa-refresh"></i></button>-->
								  
								
								 <!--  <button class="btn btn-danger btn-sm"><i class="fa fa-trash-o"></i></button>	-->
								  <a href="${pageContext.request.contextPath}/user/delete?id=${c.id}" class="btn btn-danger btn-sm">DELETE</a>
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
							<td><a href="${pageContext.request.contextPath}/" class="btn btn-warning"><i class="fa fa-angle-left"></i> Continue Shopping</a></td>
							<td colspan="2" class="hidden-xs"></td>
							
						
						<!--  	<td class="hidden-xs text-center"><strong>Total $1.99</strong></td>-->
						
						<c:set var="tot" value="0"></c:set>
                        <c:forEach items="${cart}" var="c">
                        <c:set var="t" value="${c.product.price*c.quantity}"></c:set>
                		<c:set var="tot" value="${tot+t}"/>
					</c:forEach>
							<td class="hidden-xs text-center"><strong>Total ${tot}</strong></td>
							
							<td><a href="check" class="btn btn-success btn-block">Checkout <i class="fa fa-angle-right"></i></a></td>
						
						
						</tr>
					</tfoot>


</body>
</html>