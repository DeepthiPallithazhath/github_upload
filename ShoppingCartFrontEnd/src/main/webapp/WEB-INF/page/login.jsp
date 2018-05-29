
<!------ Include the above in your HEAD tag ---------->

<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<jsp:include page="login_header.jsp"></jsp:include>

<link rel="stylesheet" type="text/css" href="resources/css/login.css">

<!-- <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>-->
<!--Pulling Awesome Font -->
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
                 
		<form action="validate" method="post"  name="Login_Form" class="form-signin"> 
		
            <h4>Welcome back.</h4>
            <input type="text" name="userName" class="form-control input-sm chat-input" placeholder="username" />
            </br>
            <input type="text" name="userPassword" class="form-control input-sm chat-input" placeholder="password" />
            </br>
            <div class="wrapper">
            <span class="group-btn">     
                <button type="submit" class="btn btn-primary btn-md">login <i class="fa fa-sign-in"></i></button>
            </span>
            </form>
            </div>
            </div>
        
        </div>
    </div>

</div>
<c:if test="${isAdmin==true}"> 


		<jsp:include page="admin.jsp"></jsp:include> 


	</c:if> 
</body>
</html>