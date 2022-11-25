<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Empresa"%>
<%@page import="transportadoracadastro.controllers.ControllerEmpresa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Empresa company = new Empresa(id);
    ControllerEmpresa companyCont = new ControllerEmpresa();
    company = companyCont.excluir(company);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarEmpresa.jsp?CNPJ=" + pbusca;
    response.sendRedirect(url);
%>