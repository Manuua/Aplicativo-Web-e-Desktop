<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Usuario"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuario"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>
<%@page import="transportadoracadastro.models.beans.UsuarioMotorista"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuarioMotorista"%>

<%
    int idUsuario = Integer.parseInt(request.getParameter("ID_USUARIO"));
    int idMotorista = Integer.parseInt(request.getParameter("ID_MOTORISTA"));
    String obs = request.getParameter("OBS");
    UsuarioMotorista usudriver = new UsuarioMotorista(idMotorista,idUsuario,"","",obs);
    ControllerUsuarioMotorista usudrivercont = new ControllerUsuarioMotorista();
    usudriver = usudrivercont.inserir(usudriver);
    
// REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "inserirRelacaoUsuarioMotorista.jsp";
    response.sendRedirect(url);

%>