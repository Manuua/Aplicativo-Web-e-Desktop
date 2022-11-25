<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Usuario"%>
<%@page import="transportadoracadastro.models.beans.Empresa"%>
<%@page import="transportadoracadastro.controllers.ControllerEmpresa"%>

<%
    String nome = request.getParameter("NOME");
    Empresa companies = new Empresa(nome);
    ControllerEmpresa companycont = new ControllerEmpresa();
    List<Empresa> company = companycont.listar(companies);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&NOME";
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA EMPRESA</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Nome</th>
                  <th data-field="Local">Local</th>
                  <th data-field="Cnpj">Cnpj</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(company.isEmpty())) { %>    
                <tbody>
                    <% for (Empresa listaEmpresa : company) { %>
                    
                        <tr>
                            <td><%=listaEmpresa.getId()%></td>
                            <td><%=listaEmpresa.getNome()%></td>
                            <td><%=listaEmpresa.getLocal()%></td>
                            <td><%=listaEmpresa.getCnpj()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirEmpresa.jsp?<%=url + listaEmpresa.getId()%>">Excluir</a></td>
                                <td><a href="alterarEmpresa.jsp?<%=url + listaEmpresa.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>


