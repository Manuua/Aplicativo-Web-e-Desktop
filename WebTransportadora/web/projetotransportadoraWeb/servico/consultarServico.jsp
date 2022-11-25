<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>CONSULTAR - SERVIÇO</title>
    <body>
       <div class="container"/>
       <h1>CONSULTAR SERVIÇO</h1>
       <form name="consultarServico" action="validaConsultarServico.jsp" method="post">
           Carga <input type="text" name ="CARGA" value=""> <br>
           <input type="submit" name ="Enviar" value="Enviar"> <br>
       </form>
       </div>
    </body>
</html>
