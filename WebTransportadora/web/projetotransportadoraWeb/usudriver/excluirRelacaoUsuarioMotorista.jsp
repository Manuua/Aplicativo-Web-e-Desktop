<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.UsuarioMotorista"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuarioMotorista"%>

<%
    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    UsuarioMotorista usuDriver = new UsuarioMotorista(id);
    ControllerUsuarioMotorista usuDriverCont = new ControllerUsuarioMotorista();
    usuDriver = usuDriverCont.excluir(usuDriver);
    
    String pbusca = request.getParameter("PBUSCA");
    
    // REDIRECIONA PARA A PAG LOGIN.JSP
    String url = "validaConsultarRelacaoUsuarioMotorista.jsp?OBS=" + pbusca;
    response.sendRedirect(url);

%>

