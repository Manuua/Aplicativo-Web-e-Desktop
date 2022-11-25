<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Servico"%>
<%@page import="transportadoracadastro.controllers.ControllerServico"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Servico service = new Servico(id);
    ControllerServico serviceCont = new ControllerServico();
    service = serviceCont.excluir(service);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarServico.jsp?CARGA=" + pbusca;
    response.sendRedirect(url);
%>