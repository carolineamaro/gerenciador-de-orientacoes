<%@page import="java.util.List"%>
<%@page import="br.com.orientacoes.modelo.Professor"%>
<%@include file="components/header.jsp" %>
<script type="text/javascript" src="js/professor.js"> </script>
<script type="text/javascript">
    carregaListaDeProfessores();
</script>
<div class="starter-template">

    <div id="alertas">
        
    </div>
    
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
        <tbody id="lista-de-professores">
           
        </tbody>
    </table>
</div>
<%@include file="components/footer.jsp" %>