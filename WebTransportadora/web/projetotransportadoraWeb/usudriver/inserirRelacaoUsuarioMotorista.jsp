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
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>INSERIR USUARIO MOTORISTA</title>
    <body>
        <div class="container"/>
            <h1>Inseri Usuario Motorista</h1>
            <form name="inseriUsuarioMotorista" action="validaRelacaoUsuarioMotorista.jsp" method="POST">
                <table>
                    <tr>
                        <td>Motorista:</td>
                        <td>
                            <select NAME ="ID_MOTORISTA" class="browser-default">
                                <% for (Motorista driver : drivers) { %>
                                    <option value="<%=driver.getId()%>"><%=driver.getNome()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Usuario:</td>
                        <td>
                            <select NAME="ID_USUARIO" class="browser-default">
                                <% for (Usuario usu : usus) { %>
                                    <option value="<%=usu.getId()%>"><%=usu.getLogin()%></option>
                                <% } %>
                            </select> 
                        </td>
                    </tr>
                    <tr>
                        <td>Observação:</td>
                        <td><input type="text" name="OBS" value=""></td>
                    </tr>
                </table>    
                <input type="submit" name="Enviar" value="Enviar">  <br>
            </form>
        </div>                     
    </body>
</html>
