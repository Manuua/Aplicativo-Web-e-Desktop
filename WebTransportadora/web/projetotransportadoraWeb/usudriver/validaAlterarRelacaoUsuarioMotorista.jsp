<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Usuario"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuario"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>
<%@page import="transportadoracadastro.models.beans.UsuarioMotorista"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuarioMotorista"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idMotorista = Integer.parseInt(request.getParameter("ID_MOTORISTA"));
    String obs = request.getParameter("OBS");
    String pbusca = request.getParameter("PBUSCA");
    UsuarioMotorista usudriver = new UsuarioMotorista(id,idMotorista,idUsuario,"","",obs);
    ControllerUsuarioMotorista usudrivercont = new ControllerUsuarioMotorista();
    usudriver = usudrivercont.alterar(usudriver);
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoUsuarioMotorista.jsp?OBS=" + pbusca;
    response.sendRedirect(url);
%>    
    
    