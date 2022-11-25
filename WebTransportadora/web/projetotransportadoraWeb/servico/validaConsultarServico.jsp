<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="transportadoracadastro.models.beans.Usuario"%>
<%@page import="transportadoracadastro.models.beans.Servico"%>
<%@page import="transportadoracadastro.controllers.ControllerServico"%>

<%
    String nome = request.getParameter("CARGA");
    Servico services = new Servico(nome);
    ControllerServico servicecont = new ControllerServico();
    List<Servico> service = servicecont.listar(services);
    Usuario usuLogado = (Usuario) session.getAttribute("UsuarioLogado");
    String url = "PBUSCA=" + nome+"&CARGA=";
%>

<html>
    <%@include file="../../inc/materalizeWeb.inc" %>
    <title>LISTA SERVIÇO</title>
    <body>
        <table class="striped responsive-table">
            <thead>
              <tr>
                  <th data-field="Id">Id</th>
                  <th data-field="Nome">Carga</th>
                  <th data-field="Local">Local</th>
                  <th data-field="Cnpj">Valor</th>
                  <th data-field="Excluir">Excluir</th>
                  <th data-field="Alterar">Alterar</th>
              </tr>
            </thead>
            <% if (!(service.isEmpty())) { %>    
                <tbody>
                    <% for (Servico listaServico : service) { %>
                    
                        <tr>
                            <td><%=listaServico.getId()%></td>
                            <td><%=listaServico.getCarga()%></td>
                            <td><%=listaServico.getLocalEntrega()%></td>
                            <td><%=listaServico.getValor()%></td>
                            <% if (usuLogado.getTipo().equals("ADM")) { %>
                                <td><a href="excluirServico.jsp?<%=url + listaServico.getId()%>">Excluir</a></td>
                                <td><a href="alterarServico.jsp?<%=url + listaServico.getId()%>">Alterar</a></td>
                            <% } %>
                        </tr>
                    <% } %>
                </tbody>
            <% } %>
        </table>    
    </body>
</html>


