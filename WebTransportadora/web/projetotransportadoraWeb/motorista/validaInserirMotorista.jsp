<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>

<%
    String nome = request.getParameter("NOME");
    String cpf = request.getParameter("CPF");
    String idade = request.getParameter("IDADE");
    String caminhao = request.getParameter("CAMINHAO");
    String placa = request.getParameter("PLACA");
 
    Motorista driver = new Motorista(nome,cpf,idade,caminhao,placa);
    ControllerMotorista drivercont = new ControllerMotorista();
    driver = drivercont.inserir(driver);

    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirMotorista.jsp";
    response.sendRedirect(url);
%>

