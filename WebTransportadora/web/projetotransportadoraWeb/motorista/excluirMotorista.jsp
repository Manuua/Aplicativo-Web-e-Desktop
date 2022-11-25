<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    Motorista driver = new Motorista(id);
    ControllerMotorista driverCont = new ControllerMotorista();
    driver = driverCont.excluir(driver);
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarMotorista.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
