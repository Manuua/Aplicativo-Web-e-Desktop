<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="transportadoracadastro.models.beans.Usuario"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuario"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>
<%@page import="transportadoracadastro.models.beans.UsuarioMotorista"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuarioMotorista"%>

<%
    ControllerMotorista driverCont = new ControllerMotorista();
    Motorista pf = new Motorista("");
    List<Motorista> drivers = driverCont.listar(pf);

    ControllerUsuario usuCont = new ControllerUsuario();
    Usuario usuEnt = new Usuario("");
    List<Usuario> usus = usuCont.listar(usuEnt);

    String cod = request.getParameter("ID");
    int id = Integer.parseInt(cod);
    UsuarioMotorista usuDriver = new UsuarioMotorista(id);
    ControllerUsuarioMotorista usuDriverCont = new ControllerUsuarioMotorista();
    usuDriver = usuDriverCont.buscar(usuDriver);
    String pbusca = request.getParameter("PBUSCA");


%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>ALTERAR - USUÁRIO MOTORISTA</title>
    <body>
       <div class="container"/>
       <h1>ALTERAR - USUÁRIO MOTORISTA</h1>
        <form name="alterarUsuarioMotorista" action="validaAlterarRelacaoUsuarioMotorista.jsp" method="post">
            <table>
                <tr>
                    <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <% if( usu.getId() == usuDriver.getIdUsuario()) { %>
                                        <option selected value="<%=usu.getId()%>"><%=usu.getLogin()%></option>
                                    <% } else { %>
                                        <option value="<%=usu.getId()%>"><%=usu.getLogin()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                </tr>
                <tr>
                        <td>MOTORISTA:</td>
                        <td>
                            <select NAME ="ID_MOTORISTA" class="browser-default">
                                <% for (Motorista driver : drivers) { %>
                                    <% if( driver.getId()== usuDriver.getIdMotorista()) { %>
                                        <option selected value="<%=driver.getId()%>"><%=driver.getNome()%></option>
                                    <% } else { %>
                                        <option value="<%=driver.getId()%>"><%=driver.getNome()%></option>
                                    <% } %>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value="<%=usuDriver.getObservacao()%>"></td>

                    </tr>
                </table>    
            <input type="HIDDEN" name="ID" value="<%=usuDriver.getId()%>"> <br>
            <input type="HIDDEN" name="PBUSCA" value="<%=pbusca%>">
            <input type="submit" name="Enviar" value="OK">
        </form>
        <div>
    </body>
</html>