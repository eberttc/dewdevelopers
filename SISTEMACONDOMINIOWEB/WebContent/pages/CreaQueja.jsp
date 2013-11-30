<!doctype html>

<html>
  
  <head>
    <title>New Page</title>
    <meta name="viewport" content="width=device-width">
    <link rel="stylesheet" href="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js" type="text/javascript"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.0.1/js/bootstrap.min.js" type="text/javascript"></script>
  </head>
  
  <body>
    <form>
      
      <div class="container">
        <table class="table">
          <tbody>
            <tr>
              <td>Fecha de Queja:</td>
              <td>
                <input class="form-control" type= "date">
              </td>
            </tr>
            <tr>
              <td>Tipo de Queja:</td>
              <td>
                <select class="form-control">
                  <option>Leve</option>
                  <option>Grave</option>
                  <option>Muy Grave</option>
                </select>
              </td>
            </tr>
            <tr>
              <td>Motivo: </td>
              <td>
                <input class="form-control" type="text">
              </td>
            </tr>
            <tr>
              <td>Detalle de la Queja:</td>
              <td>
                <textarea class="form-control"></textarea>
              </td>
            </tr>
            <tr>
              <td></td>
              <td>
                <div class="btn-group">
                  <a class="btn btn-default">Enviar</a>
                  <a class="btn btn-default">Cancelar</a>
                </div>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
    </form>
  </body>

</html>