
<%@page import="java.util.List"%>
<%@page import="br.com.orientacoes.modelo.Professor"%>
<%@include file="components/header.jsp" %>
<div class="starter-template">
    <h4>Adicionar Orientação</h4>
    <hr />
    <form action="orientacao-novo" method="post">
        <div class="form-group">
            <label for="tema">Tema da Orientação</label>
            <input type="text" name="tema" class="form-control" placeholder="Informe o tema da orientação" required />
        </div>

        <div class="form-group">
            <label for="aluno">Nome do Aluno</label>
            <input type="text" name="aluno" class="form-control" placeholder="Informe o nome do aluno" required />
        </div>

        <div class="form-group">
            <label for="id_professor">Nome do Professor</label>

            <select name="id_professor" class="form-control">
                <% for (Professor professor : (List<Professor>) request.getAttribute("professores")) {%>
                <option value="<%= professor.getId()%>"><%=professor.getNome()%></option>
                <% }%>
            </select>

        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block">Adicionar</button>
        </div>
    </form>
</div>
<%@include file="components/footer.jsp" %>