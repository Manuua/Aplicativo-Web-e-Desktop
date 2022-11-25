<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    String nome = request.getParameter("NOME");
    String cpf = request.getParameter("CPF");
    String idade = request.getParameter("IDADE");
    String caminhao = request.getParameter("CAMINHAO");
    String placa = request.getParameter("PLACA");
    String pbusca = request.getParameter("PBUSCA");
    
    Motorista driver = new Motorista(id,nome,cpf,idade,caminhao,placa);
    ControllerMotorista driverCont = new ControllerMotorista();
    driver = driverCont.alterar(driver);
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarMotorista.jsp?NOME=" + pbusca;
    response.sendRedirect(url);
%>
