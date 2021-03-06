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
<!-- create a form to save product -->

<form action="product/save" method="post" enctype="multipart/form-data">
<table border="2" align="center"  bordercolor="ash">

<tr><td>Product ID : </td><td><input type="text" name="id"> </td></tr>

<tr><td>Product Name : </td><td> <input type="text" name="name"> </td></tr>

<tr><td>Price : </td><td><input type="text" name="price"> </td></tr>
<tr><td>Description : </td><td><input type="text" name="description"> </td></tr>

<!-- select/choose the category  -->
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
 

<tr><td></td><td><input type="submit" value="Save"> </td></tr>


<!-- upload the image -->


</table>
</form>


<!-- Show the list products + edit + delete buttons -->
<table border="2" align="center"  bordercolor="ash">
<tr>
<td></td>
<td>ID</td>
<td>Name</td>
<td>Description</td>
<td>Price</td>
<td>Supplier Name</td>
<td>Category Name</td>
<td> </td>
</tr>
<c:forEach var="p" items="${products}" >
<tr>
<td><img src="${pageContext.request.contextPath}/resources/images/${p.id}.jpg" style="width: 150px;height: 150px"></td>
<td>${p.id}</td>
<td>${p.name}</td>
<td>${p.description}</td>
<td>${p.price}</td>
<td>${p.supplier.name}</td>
<td>${p.category.name}</td>


<td> 
<a href="product/delete?id=${p.id}">Delete</a> <a href="product/edit?id=${p.id}"> | Edit</a>

   </td>


 </tr>


</c:forEach>
</table>








</body>
</html>