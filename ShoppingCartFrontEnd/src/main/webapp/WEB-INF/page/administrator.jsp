
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<title>ADMIN</title>

<body>

<jsp:include page="login_header.jsp"></jsp:include>
<div class="container">
  <h2>Manage</h2>
  
 <c:if test="${not empty message}">
    <script type="text/javascript">
    alert("${message}");
    </script>
 </c:if>
  
  <ul class="nav nav-tabs">
  
    <li  class="active"><a data-toggle="tab" href="#category">Category</a></li>
    <li><a data-toggle="tab" href="#products">Products</a></li>
    <li><a data-toggle="tab" href="#supplier">Supplier</a></li>
  </ul>

  <div class="tab-content">
    
    
    <div id="category" class="tab-pane fade in active">
    
    
    
    
      <h3>Category</h3>
      
      <form action="${pageContext.request.contextPath}/admin/category/save" method="post">



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
<a href="${pageContext.request.contextPath}/admin/category/delete?id=${c.id}">Delete</a> <a href="${pageContext.request.contextPath}/admin/category/edit?id=${c.id}"> | Edit</a>

   </td>


 </tr>


</c:forEach>
</table>
    
   
    
    
    
    </div>
    
    <div id="products" class="tab-pane fade">
    
      <h3>Products</h3>
      
   <form action="${pageContext.request.contextPath}/admin/product/save" method="post" enctype="multipart/form-data">
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
<a href="${pageContext.request.contextPath}/admin/product/delete?id=${p.id}">Delete</a> <a href="${pageContext.request.contextPath}/admin/product/edit?id=${p.id}"> | Edit</a>

   </td>


 </tr>


</c:forEach>
</table>
   
   
   
   
   
    </div>
    
    
    <div id="supplier" class="tab-pane fade">
     
      <h3>Supplier</h3>
      
      
     <form action="${pageContext.request.contextPath}/admin/supplier/save" method="post">



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
<a href="${pageContext.request.contextPath}/admin/supplier/delete?id=${s.id}">Delete</a> 
 
<a href="${pageContext.request.contextPath}/admin/supplier/edit?id=${s.id}"> | Edit</a>

 
 
   </td>


 </tr>


</c:forEach>
</table>
  
    </div>
 
  </div>
</div>
</body>
</html>