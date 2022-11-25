<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Servico"%>
<%@page import="transportadoracadastro.controllers.ControllerServico"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Servico service = new Servico(id);
    ControllerServico serviceCont = new ControllerServico();
    service = serviceCont.buscar(service);
    String pbusca = request.getParameter("PBUSCA");
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - SERVIÇO</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR SERVIÇO</h1>
        <form name="alterarServico" action="validaAlterarServico.jsp" method="post">
            Carga: <input type="text" name="NOME" value="<%=service.getCarga()%>"> <br>
            Local: <input type="text" name="LOCAL" value="<%=service.getLocalEntrega()%>"> <br>
            Valor: <input type="text" name="CNPJ" value="<%=service.getValor()%>"> <br>
            <input type="HIDDEN" name="ID" value="<%=service.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>"> <br>
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>

<!--
        int id = Integer.parseInt(JOptionPane.showInputDialog("ID"));
        String carga = JOptionPane.showInputDialog("CARGA");
        String local = JOptionPane.showInputDialog("LOCAL");
        String valor = JOptionPane.showInputDialog("VALOR");-->