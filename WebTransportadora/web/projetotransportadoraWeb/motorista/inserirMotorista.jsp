<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR - MOTORISTA</title>
    <body>
       <div class="container"/>
        <h1>INSERIR MOTORISTA</h1>
        <form name="inserirMotoristas" action="validaInserirMotorista.jsp" method="post">
            Nome: <input type="text" name="NOME" value=""> <br>
            Cpf: <input type="text" name="CPF" value=""> <br>
            Idade: <input type="texr" name="IDADE" value=""> <br>
            Caminhao: <input type="text" name="CAMINHAO" value=""> <br>
            placa: <input type="text" name="PLACA" value=""> <br>
            Id_Motorista: <input type="text" name="ID_MOTORISTA" value=""> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        </div>
    </body>
</html>

