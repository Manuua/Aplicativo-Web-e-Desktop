<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Empresa"%>
<%@page import="transportadoracadastro.controllers.ControllerEmpresa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Empresa company = new Empresa(id);
    ControllerEmpresa companyCont = new ControllerEmpresa();
    company = companyCont.buscar(company);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - EMPRESA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR EMPRESA</h1>
        <form name="alterarEmpresa" action="validaAlterarEmpresa.jsp" method="post">
            Nome: <input type="text" name="NOME" value="<%=company.getNome()%>"> <br>
            Local <input type="text" name="LOCAL" value="<%=company.getLocal()%>"> <br>
            Cnpj: <input type="text" name="CNPJ" value="<%=company.getCnpj()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=company.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>

