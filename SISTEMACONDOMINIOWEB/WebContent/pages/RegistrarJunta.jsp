<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>RegistrarJunta</title>

 	<!-- Bootstrap core CSS -->
     <link href="<%=request.getContextPath()%>/css/bootstrap.css" rel="stylesheet" media="screen">
 	 
 	 <script src="<%=request.getContextPath()%>/js/jquery-1.10.2.js"></script> 	 
 	 <script src="<%=request.getContextPath()%>/js/bootbox.min.js"></script> 	  	 	    
     <script src="<%=request.getContextPath()%>/js/bootstrap-3.0.0.js"></script>
     
     <style type="text/css">
      body {
        padding-top: 50px;
        padding-bottom: 20px;
      }                                                                                          
	

    </style>
  
  
    <script>
    	
    	function mostrarDirigente(){   
    		
    		var fecha=new Date();
    		window.showModalDialog("<%=request.getContextPath()%>/RegistrarJuntaServlet?opcion=1&fecha="+fecha,window,"dialogHeight:500px;"+
            "dialogWidth:600px;center:yes;help:no;resizable:no;status:no");    		    		
    	}

    	
    	function validar(){
    		var f=document.forms[0];
    		

			if(document.getElementById("fecha").value==""){
					//alert("ingrese fecha");
					bootbox.alert("Ingrese fecha");	
					return false;
			}
			if(f.txtHora.value==""){
				//alert("ingrese hora");
				  bootbox.alert("ingrese hora");
				  return false;
			}

			if(f.txtTema.value==""){
				//alert("ingrese tema");
				bootbox.alert("ingrese tema");
				 return false;
			}
			if(f.txtAcuerdo.value==""){
				//alert("ingrese acuerdo");
				bootbox.alert("ingrese acuerdo");
			    return false;
			}

			var table = document.getElementById("myTable");
									
            if(table.rows.length<2){
   				 //alert("Debe registrar los directivos");
   				 bootbox.alert("Debe registrar los directivos");
   				 return false;
   			 }

 			 var count=0;
        	 for (var i = 1, row; row = table.rows[i]; i++) {

        	   var textfield = row.cells[2].getElementsByTagName("input")[0];
     		  
     		   if(textfield.checked)
     			  count++;
     		   
     		}

       		if(count>1){
				//alert("Solo se debe aignar una persona para presidir la reunion");
				bootbox.alert("Solo se debe aignar una persona para presidir la reunion");
				return false;
            }
       		if(count<1){
				//alert("Debe asigar a un directivo para que diriga la reunion");
				bootbox.alert("Debe asigar a un directivo para que diriga la reunion");
				return false;
            }


			 return true;

          }
    	function validarDirectivo(id){
			
    		var table = document.getElementById("myTable");
    		for (var i = 1, row; row = table.rows[i]; i++) {
    		   
    		   if(row.cells[0].innerHTML==id){
					return true;
	        	}
    		   
    		}
    		return false;    		
        }
    	
    	
    	function agregarDirectivo(id,nombre){

        	if(validarDirectivo(id)){
				//alert("Ya se agrego directivo");
				bootbox.alert("Ya se agrego directivo");
				
				return false;

            }
    		
		   var table = document.getElementById("myTable");
 
            var rowCount = table.rows.length;
            var row = table.insertRow(rowCount);
 
            var cell1 = row.insertCell(0);
            cell1.innerHTML =id;
 
            var cell2 = row.insertCell(1);
            cell2.innerHTML =nombre;
            
            var cell3 = row.insertCell(2);           
            var element1 = document.createElement("input");
            element1.type = "checkbox";
            element1.name="chkbox[]";            
            cell3.appendChild(element1);

            var cell4 = row.insertCell(3);           
            var element2 = document.createElement("a");
            var linkText = document.createTextNode("Quitar");
            element2.appendChild(linkText);
            element2.href = "javaScript:quitar('"+id+"')";                    
            cell4.appendChild(element2);       

              
    		
    	}

    	function quitar(id){

    		try {
    			var table = document.getElementById("myTable");    			
				  
				for (var i = 1, row; row = table.rows[i]; i++) {
		    		 
		    		   if(row.cells[0].innerHTML==id){
		    			   table.deleteRow(i);  
			        	}
		    		   
		    		   
		    		}					
    			}catch(e) {
    				alert(e);
    			}
    			
        }
		window.name="junta";
        function grabar(){
        	var fecha=new Date();
        	var f=document.forms[0];
        	
        	if(validar()){
        		$('#hidepage').show();
				var url="<%=request.getContextPath()%>/RegistrarJuntaServlet?fecha="+fecha+"&opcion=2";
				f.hidDirectivos.value=obtenerDatos();
				f.target="junta";
				f.action=url;
				f.submit();

           	}

        }
        function obtenerDatos(){

        	var datos="";
        	
        	var table = document.getElementById("myTable");
        	for (var i = 1, row; row = table.rows[i]; i++) {
        		var dirige="N";
        		if(row.cells[2].getElementsByTagName("input")[0].checked)
        			dirige="S";
        		datos+= row.cells[0].innerHTML+";"+
        		 		row.cells[1].innerHTML+";"+
        		 		dirige+"-/-";
 					 	        	
     		}

     		return datos;
        }

      
      
         
    </script>
    <script type="text/javascript">
    $(document).ready(function() {
			
    	  $('#hidepage').hide();
    	  $('#example').tooltip();

    	 
          
   });
    </script>
    
</head>
<jsp:include page="/pages/header.jsp" />
<c:set value="${requestScope.beanJunta}"  var="beanJunta" />
<body>
	
    <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="container">
      
        <div class="text-center">
        <h3><strong >Registro de Junta</strong></h3> 
      	        
        </div>
        <br>
        <div class="row">
          <div class="col-sm-3"></div>
           <div class="col-sm-6"> 
        	 <div class="well">
        		<form class="form-horizontal">
         		 <input type="hidden" name="hidDirectivos">	  
         		  <div id="hidepage" style="position: absolute;left:320px;top:290px;width: 150;height: 20">
						 <img  src="<%=request.getContextPath()%>/css/progress_bar.gif" >
					</div>          		 				
		         	 <div class="form-group">	
		         		          			          	 
		          		 <div class="col-sm-12"> 
		          				          		
			          		<c:choose>
			          			 <c:when test="${requestScope.mensaje=='1'}">
							     	 <div class="alert  alert-success">							     	
							     		 Registro satisfactoriamente
							     	 </div>
							     </c:when>
							      <c:when test="${not empty mensaje}">
								      <div class="alert alert-dismissable alert-danger">
								       <button type="button" class="close" data-dismiss="alert">×</button>
								       ${requestScope.mensaje}</div>          						  
								  </c:when>
							   	 <c:otherwise>
							     </c:otherwise>
			          			
								
			          		</c:choose>
		          		
		          		 </div>
		          		 
		          	</div>
           
          		 
          		 
          		 <div class="form-group">
			              <div class="col-sm-2">
			                <label class="form-label">Fecha</label>
			              </div>
			              <div class="col-sm-4">
			             <input type="date" class="form-control input-sm" required name="txtfecha" id="fecha" value="<c:out value='${beanJunta.dFechaJunta}'/>" >
			            
			              </div>
			              <div class="col-sm-1">
			                <label class="form-label">Hora</label>
			              </div>
			              <div class="col-sm-5">
			              	<div class="col-sm-4">
			              	   <input type="number" min="6" max="23" required class="form-control input-sm" value="<c:out value='${beanJunta.tHoraJunta}'/>" name="txtHora" style="width: 55px; ">
			              	</div>
			              	<div class="col-sm-8">
			              		:00 Hrs
			              	</div>
			             
			              </div>
			     </div>
			           <br>
			            <div class="form-group">
			              <div class="col-sm-2">
			                <label class="form-label">Temas</label>
			              </div>
			              <div>
			                <div class="col-sm-10">
			                  <textarea class="form-control input-sm" required placeholder="Tema" rows="3" name="txtTema"><c:out value='${beanJunta.strTemaJunta}'/></textarea>
			                </div>
			              </div>
			            </div>
			             <br>
			            <div class="form-group">
			              <div class="col-sm-2">
			                <label class="form-label">Acuerdos</label>
			              </div>
			              <div class="col-sm-10">
			                <textarea class="form-control input-sm"  required placeholder="Acuerdo" rows="3" name="txtAcuerdo"><c:out value='${beanJunta.strAcuerdoJunta}'/></textarea>
			              </div>
			            </div>
			          
			          <br>
			          <div class="form-group">
			            <div class="col-sm-2">
			              <label class="form-label">Directivos</label>
			            </div>
			            <div class="col-sm-5">
			            <c:if test="${requestScope.mensaje!='1'}">
			            	  <input class="btn btn-primary"  id="example" data-toggle="tooltip" data-original-title="Agrege a los directivos que dirigiran la reunion"
			            	   data-placement="right" value="Agregar" type="button" onclick="mostrarDirigente();"/>			              			               
			             </c:if> 
			            </div>			           			
			          </div>
			           <br>
			          <div class="form-group">
			            <div class="col-md-12">
			              <table class="table table-striped table-bordered table-hover" id="myTable">
			                <thead>
			                  <tr>
			                    <th>Codigo</th>
			                    <th>Nombre</th>
			                    <th>Dirige</th>
			                    <th></th>                    
			                  </tr>
			                </thead>
			               <c:forEach var="bean" items="${beanJunta.lstDirectivos}" varStatus="i">
						          <tr>
						          	<td id="codigo">${bean.intCodigoDirectivo}</td>
						          	<td>${bean.strNombreDirectivo}</td>
						          	<td><input type="checkbox" name="dirige" <c:if test="${bean.strPresideJunta=='S'}">checked</c:if>></td>                    	          	          		           	        
						          </tr>
				          	</c:forEach>
			              </table>
			            </div>
			          </div>
			          <div class="form-group">
				           <c:if test="${requestScope.mensaje!='1'}">
					          <div class="row">
					            <div class="col-md-12" align="center">
					              <input class="btn btn-primary" type="button" onclick="grabar();" value="grabar">			              			             
					            </div>
					          </div>	
				          </c:if>	
			          </div>			         
			          	          		 			          		           		        
              </form>
         	</div>
         </div>
          <div class="col-sm-3"></div>
       </div>     
       
     </div>
</body>
</html>