<%@page import="br.com.orientacoes.modelo.Orientacao"%>
<%@page import="java.util.List"%>
<%@page import="br.com.orientacoes.modelo.Professor"%>

<%@include file="components/header.jsp" %>
<div class="starter-template">

    <% if (request.getParameter("inserido") != null) { %> 
    <div class="alert alert-success" role="alert">
        Orientação <strong>inserido</strong> com sucesso!
    </div>
    <% } %> 

    <% if (request.getParameter("excluido") != null) { %>  
    <div class="alert alert-    " role="alert">
        Orientação <strong>excluido</strong> com sucesso!
    </div>
    <% } %> 

    <a class="btn btn-primary" style="float: right; margin-bottom: 10px" href="orientacao-novo" role="button">Adicionar Orientação</a>
    <h4>Lista de Orientações</h4>
    <hr />
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th width="20">#</th>
                <th scope="col">Tema</th>
                <th scope="col">Professor</th>
                <th scope="col">Aluno</th>
                <th width="100">Ações</th>
            </tr>
        </thead>
        <tbody>
            <% for (Orientacao orientacao : (List<Orientacao>) request.getAttribute("orientacoes")) {%>    
            <tr>
                <th scope="row"> <%= orientacao.getId()%></th>
                <td><%= orientacao.getTema()%></td>
                <td><%= orientacao.getProfessor().getNome()%></td>
                <td><%= orientacao.getAluno()%></td>
                <td>
                    <a class="btn btn-danger" href="orientacao?deletar=<%= orientacao.getId()%>" role="button">Excluir</a>
                </td>
            </tr>
            <% }%> 
        </tbody>
    </table>
</div>
<%@include file="components/footer.jsp" %>