<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>

<html>
    <head>
    <title>Resgistro de Mensajes</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootswatch/3.0.0/cosmo/bootstrap.min.css">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
    <script type="text/javascript" src="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js"></script>
  </head>
  
  <body>
    <div class="container">
      <form class="form-horizontal" role="form" Method="POST" action="<%=request.getContextPath()%>/MensajeServlet">
        <div class="form-group">
          <label for="inputAsunto" class="col-sm-2 control-label">Asunto</label>
          <div class="col-sm-10">
            <input type="text" class="form-control" name="fc_asunto" placeholder="Asunto" id="inputAsunto" required="required">
          </div>
        </div>
        <div class="form-group">
          <label for="inputPassword3" class="col-sm-2 control-label">Mensaje</label>
          <div class="col-sm-10">
            <textarea class="form-control" name="fc_mensaje" placeholder="Redactar Mensaje" required="required"></textarea>
          </div>
        </div>
        <div class="form-group">
          <label for="inputfecha" class="col-sm-2 control-label">Fecha</label>
          <div class="col-sm-10">
            <input type="date" class="form-control" name="fc_fecha" placeholder="Asunto" id="inputfecha" required="required">
          </div>
        </div>
        <div class="form-group">
          <div class="col-sm-offset-2 col-sm-10">
            <button type="submit" class="btn btn-default">Enviar</button>
          </div>
        </div>
      </form>
    </div>
  </body>

</html>