
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
<!--     <link rel="shortcut icon" href="../../assets/ico/favicon.png"> -->

    <title>Trastienda</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.css" rel="stylesheet" media="screen">

	<style type="text/css">
		body {
		  padding-top: 40px;
		  padding-bottom: 40px;
		  background-color: #eee;
		}
		
		.form-signin {
		  max-width: 330px;
		  padding: 15px;
		  margin: 0 auto;
		}
		.form-signin .form-signin-heading,
		.form-signin .checkbox {
		  margin-bottom: 10px;
		}
		.form-signin .checkbox {
		  font-weight: normal;
		}
		.form-signin .form-control {
		  position: relative;
		  font-size: 16px;
		  height: auto;
		  padding: 10px;
		  -webkit-box-sizing: border-box;
		     -moz-box-sizing: border-box;
		          box-sizing: border-box;
		}
		.form-signin .form-control:focus {
		  z-index: 2;
		}
		.form-signin input[type="text"] {
		  margin-bottom: -1px;
		  border-bottom-left-radius: 0;
		  border-bottom-right-radius: 0;
		}
		.form-signin input[type="password"] {
		  margin-bottom: 10px;
		  border-top-left-radius: 0;
		  border-top-right-radius: 0;
		}
	</style>


    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="../../assets/js/html5shiv.js"></script>
      <script src="../../assets/js/respond.min.js"></script>
    <![endif]-->
    <script type="text/javascript">
   	   
		function valida(){
			
			var f=document.forms[0];
			
			if(f.txtUser.value==""){
				alert("Ingrese Usuraio");
				return false;
			}

			if(f.txtPass.value==""){
				alert("Ingrese PASSWORD");
				return false;
			}

			
			f.method="post";
			f.submit();
		
		}

		function cambiaTipo(){
			    var f=document.forms[0];
				
			    if(f.chkUsuario.checked){
					f.hidTipo.value="A";
				}else
					f.hidTipo.value="R";
				
			}
			
    </script>
  </head>

  <body>
    <div class="container">
 	  
      <form class="form-signin" action="LoginServlet" method="post" >
        <h2 class="form-signin-heading"></h2>
        <c:if test="${not empty MENSAJE }">
        	<div class="alert alert-danger">${MENSAJE}</div>
        </c:if>
        <input type="hidden"  name="hidTipo"/>
        <input type="text" name="txtUser" class="form-control" placeholder="Usuario">
        <input type="password" name="txtPass" class="form-control" placeholder="Password">
        <label class="checkbox">
          <input type="checkbox" name="chkUsuario" onclick="cambiaTipo();"> Si eres Administrativo selecciona esta opcion
        </label>
        <input class="btn btn-lg btn-primary btn-block"  value ="Entrar" type="submit"  />
      </form>
	  <c:remove var="MENSAJE" scope="request" />
    </div> <!-- /container -->

     <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="js/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap-3.0.0.js"></script>
  </body>
</html>