<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Motorista driver = new Motorista(id);
    ControllerMotorista driverCont = new ControllerMotorista();
    driver = driverCont.buscar(driver);
    String pbusca = request.getParameter("PBUSCA");
%>


<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - MOTORISTA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR MOTORISTA</h1>
        <form name="alterarMotorista" action="validaAlterarMotorista.jsp" method="post">
            Id: <input type="number" name="ID_MOTORISTA" value="<%=driver.getId()%>"> <br>
            Nome: <input type="text" name="NOME" value="<%=driver.getNome()%>"> <br>
            Cpf: <input type="text" name="CPF" value="<%=driver.getCpf()%>"> <br>
            Placa: <input type="text" name="PLACA" value="<%=driver.getPlaca()%>"> <br>    
            <input type="HIDDEN" name="ID" value="<%=driver.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>
