<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error</title>

 	<!-- Bootstrap core CSS -->
     <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
 
 	<script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
     <style type="text/css">
      body {
        padding-top: 50px;
        padding-bottom: 20px;
      }
    </style>
</head>






  <body>
		<div class="jumbotron">
         <div class="container">
    		<div class="alert alert-danger">             
              <strong>
              		<p>Hubo un error o su sesión ha caducado.Vuelva a <a class="alert-link" href="<%=request.getContextPath()%>/index.jsp">intentarlo</a>.</p>
              </strong> 
            </div>
    	</div>
    	</div>
    	
    	
		
		
</body>
</html>