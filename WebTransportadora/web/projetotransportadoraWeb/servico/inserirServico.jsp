<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - SERVIÇO</title>
    <body>
       <div class="container"/>
        <h1>INSERIR SERVIÇO</h1>
        <form name="inserirServico" action="validaInserirServico.jsp" method="post">
            Carga: <input type="text" name="CARGA" value=""> <br>
            Local: <input type="text" name="LOCAL" value=""> <br>
            Valor: <input type="text" name="VALOR" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
