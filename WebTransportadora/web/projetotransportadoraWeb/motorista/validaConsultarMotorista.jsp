<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Usuario"%>
<%@page import="transportadoracadastro.models.beans.Motorista"%>
<%@page import="transportadoracadastro.controllers.ControllerMotorista"%>

<%
    String nome = request.getParameter("NOME");
    Motorista drivers = new Motorista(nome);
    ControllerMotorista drivercont = new ControllerMotorista();
    List<Motorista> driver = drivercont.listar(drivers);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&ID=" ;
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA MOTORISTA</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Cpf">Nome</th>
                  <th data-field="Nome">Cpf</th>
                  <th data-field="idade">Idade</th>
                  <th data-field="caminhao">Caminhao</th>
                  <th data-field="placa">Placa</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(driver.isEmpty())) { %>    
                <tbody>
                    <% for (Motorista listaMotorista : driver) { %>
                        <tr>
                            <td><%=listaMotorista.getId()%></td>
                            <td><%=listaMotorista.getNome()%></td>
                            <td><%=listaMotorista.getCpf()%></td>
                            <td><%=listaMotorista.getIdade()%></td>
                            <td><%=listaMotorista.getCaminhao()%></td>
                            <td><%=listaMotorista.getPlaca()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirMotorista.jsp?<%=url + listaMotorista.getId()%>">Excluir</a></td>
                                <td><a href="alterarMotorista.jsp?<%=url + listaMotorista.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>

