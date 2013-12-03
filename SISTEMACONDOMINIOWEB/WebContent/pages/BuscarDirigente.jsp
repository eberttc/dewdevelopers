<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buscar Directivos</title>

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

<script type="text/javascript">


$(document).ready(function () {
	
	
	var id="";
	var nombre="";
	
	
	 $( "#dirigentes tbody tr" ).dblclick(function() {
		 				       
		 id = $(this).find("td").eq(0).html();    
		 nombre = $(this).find("td").eq(1).html();    
		 devolverDatos(id,nombre);
	});
	 

	 function devolverDatos(id,nombre){
	 	
		 var callerWindowObj = dialogArguments;		   		   
	        callerWindowObj.agregarDirectivo(id,nombre);	
	        window.close();
	 	
	 }


});
</script>




  <body>
  
  <form action="<%=request.getContextPath()%>/RegistrarJuntaServlet?" method="post">
  <input type="hidden" name="opcion" value="3">
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <p>Busqueda de Directivos</p>
        <p></p>
      </div>
    </div>
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-md-2">
          <p>Codigo</p>
        </div>
        <div class="col-md-8">
          <input type="text" class="form-control" name="codigo">
        </div>
        <div class="col-md-2">
          <button class="btn btn-primary" onclick="buscar();">Buscar
             <span class="glyphicon glyphicon-search"></span>
          </button>
        </div>
      </div><br>
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <table class="table table-bordered table-hover" id="dirigentes">
              <thead>
                <tr>
                  <th>Codigo</th>
                  <th>Nombre</th>
                  <th>Cargo</th>
                </tr>
              </thead>
              <tbody>
               <c:forEach var="bean" items="${requestScope.lista}" varStatus="i">
		          <tr>
		          	<td id="codigo">${bean.intCodigoDirectivo}</td>
		          	<td>${bean.strNombreDirectivo}</td>
		          	<td>${bean.strCargo}</td>                    	          	          		           	        
		          </tr>
          	</c:forEach>
              </tbody>
            </table>
          </div>
        </div>
        <div class="row">
          <div class="col-md-12" align="center">
          	 <input class="btn btn-primary"  type="button" onclick="window.close();" value="Cerrar">	
          </div>          
          </div>
        <hr>
        <footer>
          <p>&copy; Company 2013</p>
        </footer>
      </div>
      <!-- /container -->
    </div>
    </form>
  </body>

</html>