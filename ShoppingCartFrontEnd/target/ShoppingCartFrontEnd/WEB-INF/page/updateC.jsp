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
<form action="update" method="post">

<!--  

		<table align="center" border="2" bordercolor="blue">

			<tr>

				<td>Category Name:</td>

				<td><input type="text" name="name" value="${category.name }"></td>

			</tr>

			<tr>

				<td>Description:</td>

				<td><input type="text" name="description"  value="${category.description }"></td>

			</tr>

			<tr>

				<td><input type="submit" value="Update"></td>

			</tr>



		</table>

-->

<div class="form-group">

    <label for="exampleInputEmail1">Category Name</label>
    <input  type="text"   class="form-control" id="exampleInputEmail1" name="name" aria-describedby="emailHelp" value="${category.name }" >
    <small id="emailHelp" class="form-text text-muted"></small>

</div>
  <div class="form-group ">
    <label for="exampleInputPassword1">Description</label>
    <input type="text" class="form-control" id="exampleInputPassword1" name="description" value="${category.description }">
 </div>
  
  <button type="submit" class="btn btn-primary" value="Update">Submit</button>
	</form>




	</form>





</body>
</html>