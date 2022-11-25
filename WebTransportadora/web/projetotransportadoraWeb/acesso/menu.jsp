<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Usuario"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuario"%>
<%@page import="java.util.Date" %>


<%
    String login = request.getParameter("LOGIN");
    String senha = request.getParameter("SENHA");
    Usuario usuEnt = new Usuario(login,senha);
    ControllerUsuario usucont = new ControllerUsuario();
    Usuario usuSaida = usucont.validarWeb(usuEnt);
    session.setAttribute("UsuarioLogado",usuSaida);
%>


<!DOCTYPE html>
<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>SISTEMA </title>
    <body>
        <% if (usuSaida != null) { %>
            <!-- Dropdown1 Trigger -->
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown1'>Manter Usuário</a>        
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown2'>Manter Motorista</a>             
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown3'>Manter Empresa</a> 
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown4'>Manter Serviço</a> 
            <a class='dropdown-button btn' data-beloworigin="true" href='#' data-activates='dropdown5'>Manter Acesso</a> 

            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown1 Structure -->
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/inserirUsuario.jsp"> InseriUsuario </a></li>
                    <li><a href="../usuario/consultarUsuario.jsp"> ConsultaUsuarioParametro </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown1' class='dropdown-content'>
                    <li><a href="../usuario/consultarUsuario.jsp"> ConsultaUsuarioParametro </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown2 Structure -->
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../motorista/inserirMotorista.jsp"> InseriMotorista </a></li>
                    <li><a href="../motorista/consultarMotorista.jsp"> ConsultaMotorista </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown2' class='dropdown-content'>
                    <li><a href="../motorista/consultarMotorista.jsp"> ConsultaMotorista </a></li>
                </ul>
            <% } %>
             <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../empresa/inserirEmpresa.jsp"> InseriEmpresa </a></li>
                    <li><a href="../empresa/consultarEmpresa.jsp"> ConsultaEmpresa </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown3' class='dropdown-content'>
                    <li><a href="../empresa/consultarEmpresa.jsp"> ConsultaEmpresa</a></li>
                </ul>
            <% } %>
             <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../servico/inserirServico.jsp"> InseriServico </a></li>
                    <li><a href="../servico/consultarServico.jsp"> ConsultarServico </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown4' class='dropdown-content'>
                    <li><a href="../servico/consultarServico.jsp"> ConsultarServico </a></li>
                </ul>
            <% } %>
            <% if (usuSaida.getTipo().equals("ADM")) { %>
                <!-- Dropdown3 Structure -->
                <ul id='dropdown5' class='dropdown-content'>
                    <li><a href="../usudriver/inserirRelacaoUsuarioMotorista.jsp"> InseriUsuarioMotorista </a></li>
                    <li><a href="../usudriver/consultarRelacaoUsuarioMotorista.jsp"> ConsultaUsuarioMotorista </a></li>
                </ul>
            <% } else { %>
                <ul id='dropdown5' class='dropdown-content'>
                    <li><a href="../usuario/consultarRelacaoUsuarioMotorista.jsp"> ConsultaUsuarioMotorista </a></li>
                </ul>
            <% } %>
            <% } else { %>
                <h1>USUÁRIO INVÁLIDO</h1>
        <% } %>
    </body>
</html>