<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="login_header.jsp"></jsp:include>
 <link rel="stylesheet" type="text/css" href="resources/css/style.css">
</head>
<body>
<form action="category/save" method="post">


<!--  
		<table align="center" border="2" bordercolor="blue">

			<tr>

				<td>Category Name:</td>

				<td><input type="text" name="name"></td>

			</tr>

			<tr>

				<td>Description:</td>

				<td><input type="text" name="description"></td>

			</tr>

			<tr>

				<td><input type="submit" value="Save"></td>

			</tr>



		</table>
-->
<div class="form-group">
    <label for="exampleInputEmail1">Category Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Category Name">
    <small id="emailHelp" class="form-text text-muted"></small>
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Description</label>
    <input type="text" class="form-control" id="exampleInputPassword1" placeholder="description">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>

	</form>
	
	<table border="2" align="center"  bordercolor="ash">
<tr>

<td>ID</td>
<td>Name</td>
<td>Description</td>


</tr>
<c:forEach var="c" items="${categories}" >
<tr>

<td>${c.id}</td>
<td>${c.category_name}</td>
<td>${c.description}</td>
<td>
<a href="category/delete?id=${c.id}">Delete</a> <a href="category/edit?id=${c.id}"> | Edit</a>

   </td>


 </tr>


</c:forEach>
</table>



</body>
</html>