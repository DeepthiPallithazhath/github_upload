


<!DOCTYPE html> 


<html lang="en"> 


<head> 


  <title>Bootstrap Example</title> 


  <meta charset="utf-8"> 


  <meta name="viewport" content="width=device-width, initial-scale=1"> 



</head> 


<body> 





<div class="container"> 


 <h1 style="color:blue;margin-left:30px;"> Welcome To Shopping</h1>   


  <div id="myCarousel" class="carousel slide" data-ride="carousel"> 


   <!-- Indicators --> 


   <ol class="carousel-indicators"> 


      <li data-target="#myCarousel" data-slide-to="0" class="active"></li> 


      <li data-target="#myCarousel" data-slide-to="1"></li> 


      <li data-target="#myCarousel" data-slide-to="2"></li> 


    </ol> 


 


   <!-- Wrapper for slides --> 


    <div class="carousel-inner" style="width:70%;"> 


     <div class="item active"> 


       <img src="resources/images/tv1.jpg" alt="SAMSUNG" style="width:100%;margin-right:30px;"> 


      </div> 


 


      <div class="item"> 


        <img src="resources/images/tv2.png" alt="LG" style="width:100%;"> 


      </div> 


     


      <div class="item"> 


        <img src="resources/images/tv3.jpg" alt="PHILIPS" style="width:100%;"> 


     </div> 


    </div> 


 


    <!-- Left and right controls --> 


    <a class="left carousel-control" href="#myCarousel" data-slide="prev"> 


      <span class="glyphicon glyphicon-chevron-left" ></span> 


     <span class="sr-only">Previous</span> 


    </a> 


    <a class="right carousel-control" href="#myCarousel" data-slide="next"> 


    <span class="glyphicon glyphicon-chevron-right"></span> 


     <span class="sr-only">Next</span> 


    </a> 


  </div> 


</div> 





</body> 


</html> 