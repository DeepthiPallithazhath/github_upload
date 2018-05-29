<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="login_header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="resources/css/login.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <div class="panel-body">
<div class="container">
<div class="row">
<div class="col-sm-4 col-md-4">
<table class="table table-striped table-bordered table-list">
                 <thead>
                   <tr>
                      
                       <th class="hidden-xs">ID</th>
                       <th>Name</th>
                       <th>Supplier</th>
                       <th>Price</th>
                       <th>Image</th>                                                                        
                   </tr> 
                 </thead>
                 <tbody>
<c:forEach items="${products}" var="p">
                         <tr>
                        
                           <td class="hidden-xs">${p.id}</td>
                           <td>${p.name}</td>   
                              
                           <tr>       
                         </c:forEach>


</tbody>
</table>
</div>



</div>

</div>
</div>
</body>
</html>