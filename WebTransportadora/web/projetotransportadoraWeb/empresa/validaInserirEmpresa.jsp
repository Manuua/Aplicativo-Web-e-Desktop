<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Empresa"%>
<%@page import="transportadoracadastro.controllers.ControllerEmpresa"%>

<%
    String nome = request.getParameter("NOME");
    String local = request.getParameter("LOCAL");
    String cnpj = request.getParameter("CNPJ");
 
    Empresa company = new Empresa(nome,local,cnpj);
    ControllerEmpresa companycont = new ControllerEmpresa();
    company = companycont.inserir(company);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirEmpresa.jsp";
    response.sendRedirect(url);
%>
   