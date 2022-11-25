<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Usuario"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuario"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>
<%@page import="transportadoracadastro.models.beans.UsuarioMotorista"%>
<%@page import="transportadoracadastro.controllers.ControllerUsuarioMotorista"%>

<%
    String obs = request.getParameter("OBS");
    UsuarioMotorista usudriver = new UsuarioMotorista(obs);
    ControllerUsuarioMotorista usudrivercont = new ControllerUsuarioMotorista();
    List<UsuarioMotorista> usudrivers = usudrivercont.listar(usudriver);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + usudriver.getObservacao()+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA USUÁRIOS</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="IdUsuMotorista">Id</th>
                  <th data-field="IdMotorista">IdMotorista</th>
                  <th data-field="NomeMotorista">NomeMotorista</th>
                  <th data-field="IdUsuario">IdUsuario</th>
                  <th data-field="NomeUsuario">NomeUsuario</th>
                  <th data-field="Observacao">Observacao</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(usudrivers.isEmpty())) { %>    
                <tbody>
                    <% for (UsuarioMotorista listaUsuarioMotorista : usudrivers) { %>
                        <tr>
                            <td><%=listaUsuarioMotorista.getId()%></td>
                            <td><%=listaUsuarioMotorista.getIdMotorista()%></td>
                            <td><%=listaUsuarioMotorista.getDriver().getNome()%></td>
                            <td><%=listaUsuarioMotorista.getIdUsuario()%></td>
                            <td><%=listaUsuarioMotorista.getUsu().getLogin()%></td>
                            <td><%=listaUsuarioMotorista.getObservacao()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirRelacaoUsuarioMotorista.jsp?<%=url + listaUsuarioMotorista.getId()%>">Excluir</a></td>
                                <td><a href="alterarRelacaoUsuarioMotorista.jsp?<%=url + listaUsuarioMotorista.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>