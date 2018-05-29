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

<form action="supplier/save" method="post">



		<table align="center" border="2" bordercolor="blue">

			

			<tr>

				<td>Supplier Name:</td>

				<td><input type="text" name="name"></td>

			</tr>

			<tr>

				<td>Address:</td>

				<td><input type="address" name="address"></td>

			</tr>

				<tr>

				<td><input type="submit" value="Save"></td>

			</tr>



		</table>



	</form>
	<table border="2" align="center"  bordercolor="ash">
<tr>

<td>ID</td>
<td>Name</td>
<td>Address</td>

</tr>
<c:forEach var="s" items="${suppliers}" >
<tr>

<td>${s.id}</td>
<td>${s.name}</td>
<td>${s.address}</td>

<td> 
<a href="supplier/delete?id=${s.id}">Delete</a> 
 
<a href="supplier/edit?id=${s.id}"> | Edit</a>

 
 
   </td>


 </tr>


</c:forEach>
</table>
	
	
	
</body>
</html>