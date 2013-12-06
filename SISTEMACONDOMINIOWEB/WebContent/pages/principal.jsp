<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Condominio</title>

    <!-- Bootstrap core CSS -->
    <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script> 	 
 	 	 	    
    <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
   
  </head>

  <body>
        
	  <jsp:include page="/pages/header.jsp" />
      
	 <div class="container"> 
	   
	   <!-- Jumbotron -->
	   <div class="jumbotron">     
	   		<h4>Bienvenido <b>${sessionScope.USUARIO_ACTUAL.nombres }</b></h4>	     
	   </div>
	   
	   <div class="row">
      
      </div>
      
	
	   <!-- Site footer -->
	   <div class="footer">
	   	 <p>&nbsp;</p>
	     <p>&copy;Developers 2014 </p>
	   </div>
	   
	 </div> <!-- /container -->
    
   


    
    
  </body>
</html>
