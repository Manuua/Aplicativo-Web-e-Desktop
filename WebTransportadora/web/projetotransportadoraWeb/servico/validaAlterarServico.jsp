<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Servico"%>
<%@page import="transportadoracadastro.controllers.ControllerServico"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("CARGA");
    String localEntrega = request.getParameter("LOCAL");
    String cnpj = request.getParameter("VALOR");
    String pbusca = request.getParameter("PBUSCA");
    Servico service = new Servico(id, carga, localEntrega, valor);
    ControllerServico serviceCont = new ControllerServico();
    service = serviceCont.alterar(service);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarServico.jsp?CARGA=" + pbusca;
    response.sendRedirect(url);
%>