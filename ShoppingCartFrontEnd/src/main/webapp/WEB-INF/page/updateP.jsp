<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="login_header.jsp"></jsp:include>
 <link rel="stylesheet" type="text/css" href="resources/css/style.css">


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="col-xs-8 container">
<!-- create a form to save product -->

<form action="update" method="post" enctype="multipart/form-data">
<!-- 
<table border="2" align="center"  bordercolor="ash">

<tr><td>Product ID : </td><td><input type="text" name="id" value="${product.id }" readonly="true"> </td></tr>

<tr><td>Product Name : </td><td> <input type="text" name="name" value="${product.name}" > </td></tr>

<tr><td>Price : </td><td><input type="text" name="price" value="${product.price}"> </td></tr>
<tr><td>Description : </td><td><input type="text" name="description" value="${product.description}"> </td></tr>
-->
<!-- select/choose the category  -->
<!-- 
<tr>
<td>Select Category</td>
<td>
<select name="cid">
<c:forEach var="category" items="${categories}">
<option value="${category.id}">${category.name}  </option> 
</c:forEach>
 
</select>


 </td></tr>
 
 <tr>
<td>Select Supplier</td>
<td>
<select name="sid">
<c:forEach var="supplier" items="${suppliers}">
<option value="${supplier.id}">${supplier.name}  </option> 
</c:forEach>
 
</select>


 </td></tr>
 
 <tr><td>Upload image : </td><td> <input type="file" id="img" name="file"> </td></tr>
 

<tr><td></td></tr>

 -->
<!-- upload the image -->
<div class="form-group">
    <label for="exampleInputEmail1">Product ID</label>
    <input type="text" class="form-control" id="exampleInputEmail1" name="id" aria-describedby="emailHelp" value="${product.id}" readonly="readonly">
    <small id="emailHelp" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Product Name</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="name"value="${product.name}" placeholder="name">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Description</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="description" value="${product.description}" placeholder="description">
  </div>
  
  <div class="form-group">
    <label for="exampleInputPassword1">Price</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="price" value="${product.price}" placeholder="price">
  </div>
  
   <div class="form-group">
    <label for="exampleInputPassword1">Stock</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="stock" value="${product.stock}" placeholder="stock">
  </div>
  
  <div class="form-group">
  <label for="sel1">Select Category:</label>
 
  <select class="form-control" id="sel1" name="cid">
   <c:forEach var="category" items="${categories}">
    <option value="${category.id}">${category.name}  </option> 
    </c:forEach>
  </select>

</div>
<div class="form-group">
  <label for="sel1">Select Supplier:</label>
 

  <select class="form-control" id="sel1" name="sid">
   <c:forEach var="supplier" items="${suppliers}">
    <option value="${supplier.id}">${supplier.name}  </option> 
    </c:forEach>
  </select>

</div>
<div class="form-group">
    <label for="exampleFormControlFile1">Upload Image</label>
    <input type="file" class="form-control-file" id="exampleFormControlFile1" name="file">
  </div>
  
  <button type="submit" class="btn btn-primary">Update</button>
<!--  <tr>

				<td><input type="submit" value="Update"></td>

			</tr>-->



		
</table>

</form>




</div>






</body>
</html>