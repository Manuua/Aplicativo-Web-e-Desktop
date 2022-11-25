<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Empresa"%>
<%@page import="transportadoracadastro.controllers.ControllerEmpresa"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String local = request.getParameter("LOCAL");
    String cnpj = request.getParameter("CNPJ");
    String pbusca = request.getParameter("PBUSCA");
    Empresa company = new Empresa(id, nome, local, cnpj);
    ControllerEmpresa companyCont = new ControllerEmpresa();
    company = companyCont.alterar(company);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarEmpresa.jsp?CNPJ=" + pbusca;
    response.sendRedirect(url);
%>