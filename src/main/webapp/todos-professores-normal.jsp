<%@page import="java.util.List"%>
<%@page import="br.com.orientacoes.modelo.Professor"%>

<%@include file="components/header.jsp" %>
<div class="starter-template">

    <% if (request.getParameter("inserido") != null) { %> 
    <div class="alert alert-success" role="alert">
        Professor <strong>inserido</strong> com sucesso!
    </div>
    <% } %> 

    <% if (request.getParameter("excluido") != null) { %>  

        <% if (request.getParameter("excluido").equals("sim")) { %> 
        <div class="alert alert-danger" role="alert">
            Professor <strong>excluido</strong> com sucesso!
        </div>
        <% } else{ %>
        <div class="alert alert-warning" role="alert">
            Este professor está associado a uma orientação, apague-a antes de excluí-lo!
        </div>
        <% } %> 
    <% } %> 

    <a class="btn btn-primary" style="float: right; margin-bottom: 10px" href="professor-novo" role="button">Adicionar Professor</a>
    <h4>Lista de professores</h4>
    <hr />
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th width="20">#</th>
                <th scope="col">Nome</th>
                <th width="100">Ações</th>
            </tr>
        </thead>
        <tbody>
            <% for (Professor professor : (List<Professor>) request.getAttribute("professores")) {%>    
            <tr>
                <th scope="row"> <%= professor.getId()%></th>
                <td><%= professor.getNome()%></td>
                <td>
                    <a class="btn btn-danger" href="professor?deletar=<%= professor.getId()%>" role="button">Excluir</a>
                </td>
            </tr>
            <% }%> 
        </tbody>
    </table>
</div>
<%@include file="components/footer.jsp" %>