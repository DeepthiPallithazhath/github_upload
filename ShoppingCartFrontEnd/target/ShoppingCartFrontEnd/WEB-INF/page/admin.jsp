
<!------ Include the above in your HEAD tag ---------->

<html>
<head>


<link rel="stylesheet" type="text/css" href="resources/css/login.css">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!--Pulling Awesome Font -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>

<c:if test="${isAdminClickedManageSupplires==true}">
	
	

		<jsp:include page="Supplier.jsp"></jsp:include>

	</c:if>
	
	
	<c:if test="${isAdminClickedManageProducts==true}">

		<jsp:include page="Product.jsp"></jsp:include>

	</c:if>


	<c:if test="${isAdminClickedManageCategories==true}">

		<jsp:include page="category.jsp"></jsp:include>

	</c:if>
             

<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            
                 
		<form action="admin" method="post"  name="Login_Form" class="form-signin"> 
		<br>
		<br>
          
          
            <h4><a href="manage_categories"> Manage Categories</a>

	

<h4>	<a href="manage_suppliers"> Manage Suppliers</a></h4>

	

	<h4><a href="manage_products"> Manage Produts</a></h4>
	
	<!--
	
	-->
 

	



            </form>
            
            </div>
                 
		
            </div>
            </div>
        
        </div>
    </div>

</div>

</body>
</html>