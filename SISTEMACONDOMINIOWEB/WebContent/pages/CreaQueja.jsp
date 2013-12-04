<!doctype html>

<html>
  
  <head>
    <title>Registro de Quejas</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" type="text/javascript"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  
  <body>
  	<jsp:include page="/pages/header.jsp" />
    <form>
      
      <div class="container">
        <table class="table">
          <tbody>
            <tr>
              <td>Fecha de Queja:</td>
              <td>
                <input class="form-control" type= "date" id="txtFecha" name="txtFecha" required autofocus />
              </td>
            </tr>
            <tr>
              <td>Tipo de Queja:</td>
              <td>
                <select class="form-control" id="txtTipoQueja" name="txtTipoQueja">
                  <option value="1">Leve</option>
                  <option value="2">Grave</option>
                  <option value="3">Muy Grave</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Motivo:</td>
              <td>
                <input class="form-control" type="text" id="txtMotivo" name="txtMotivo" required autofocus>
              </td>
            </tr>
            <tr>
              <td>Detalle de la Queja:</td>
              <td>
                <textarea class="form-control" id="txtDetalle" name="txtDetalle" required autofocus></textarea>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <div class="btn-group">
                  <a class="btn btn-default" id="botonEnviar" type="submit">:: Enviar </a>
                  <a class="btn btn-default" id="botonCancelar" type="calcel">:: Cancelar </a>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </form>
  </body>

</html>