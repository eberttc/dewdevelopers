<%@page import="com.upc.condominio.negocio.GestionEspacioComun,com.upc.condominio.modelo.EspacioComun,com.upc.condominio.exceptions.DAOExcepcion,java.util.*" %>


<html>
  
  <head>
    <title>Jumbotron</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <style type="text/css">
      body {
        padding-top: 50px;
        padding-bottom: 20px;
      }
    </style>
  </head>
  
  <body>
    <div class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav">
            <li class="active">
              <a href="#">Home</a>
            </li>
            <li>
              <a href="#about">About</a>
            </li>
            <li>
              <a href="#contact">Contact</a>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
              <ul class="dropdown-menu">
                <li>
                  <a href="#">Action</a>
                </li>
                <li>
                  <a href="#">Another action</a>
                </li>
                <li>
                  <a href="#">Something else here</a>
                </li>
                <li class="divider"></li>
                <li class="dropdown-header">Nav header</li>
                <li>
                  <a href="#">Separated link</a>
                </li>
                <li>
                  <a href="#">One more separated link</a>
                </li>
              </ul>
            </li>
          </ul>
          <form class="navbar-form navbar-right">
            <div class="form-group">
              <input type="text" placeholder="Email" class="form-control">
            </div>
            <div class="form-group">
              <input type="password" placeholder="Password" class="form-control">
            </div>
            <button type="submit" class="btn btn-success">Sign in</button>
          </form>
        </div>
        <!--/.navbar-collapse -->
      </div>
    </div>
    <!-- Main jumbotron for a primary marketing message or call to action -->
    <div class="jumbotron">
      <div class="container">
        <h3>RESERVA DE ESPACIOS COMUNES DEL CONDOMINIO</h3>
        <p></p>
      </div>
    </div>
    <div class="container">
      <!-- Example row of columns -->
      <div class="row">
        <div class="col-lg-4">
          <form method="POST" Action="">
            <div class="col-md-4">Fecha:<input type="date"  class="form-control" name="fecha_res" placeholder="dd/mm/yyyy" size="150">
            </div>
            <div class="col-md-4">Espacio:
              <select class="form-control">
<% 
  GestionEspacioComun negocio = new GestionEspacioComun();
	try {
		Collection<EspacioComun> listado = negocio.listarEspacios();
		
		for (EspacioComun m : listado) {%>
			 <option value="<%out.println(m.getIdespacio()); %>"><%=m.getNombreEspacio()%></option>
		<%} 
	} catch (DAOExcepcion e) {
      out.print("Falló el Listado: "+e.getMessage());
    } %>
              </select>
             
            </div>
            <div class="filtros"></div>
            <table class="table">
              <thead>
                <tr>
                  <td>&nbsp;</td>
                </tr>
                <tr>
                  <th>N&ordm;</th>
                  <th>HORARIOS DISPONIBLES</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>8:00 - 9:00</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>89:00 - 10:00</td>
                </tr>
              </tbody>
            </table>
            <div class="col-md-4">
              <input type="submit" value="ENVIAR">
            </div>
          </form>
        </div>
        <div class="col-lg-4">
          <p></p>
        </div>
      </div>
      <hr>
      <footer>
        <p>&copy; Developers 2013</p>
        <nav>
          <div class="container"></div>
        </nav>
      </footer>
    </div>
    <!-- /container -->
  </body>

</html>