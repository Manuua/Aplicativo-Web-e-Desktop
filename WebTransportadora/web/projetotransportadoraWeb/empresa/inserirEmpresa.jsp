<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - EMPRESA</title>
    <body>
       <div class="container"/>
        <h1>INSERIR EMPRESA</h1>
        <form name="inserirEmpresa" action="validaInserirEmpresa.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            Local: <input type="text" name="LOCAL" value=""> <br>
            Cnpj: <input type="text" name="CNPJ" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>
