<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Servico"%>
<%@page import="transportadoracadastro.controllers.ControllerServico"%>

<%
    String carga = request.getParameter("CARGA");
    String localEntrega = request.getParameter("LOCAL");
    String valor = request.getParameter("VALOR");
 
    Servico service = new Servico(carga,localEntrega,valor);
    ControllerServico servicecont = new ControllerServico();
    service = servicecont.inserir(service);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirServico.jsp";
    response.sendRedirect(url);
%>
   