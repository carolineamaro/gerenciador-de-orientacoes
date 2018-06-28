
<%@include file="components/header.jsp" %>
<div class="starter-template">
    <h4>Adicionar Professor</h4>
    <hr />
    <form action="professor-novo" method="post">
        <div class="form-group">
            <label for="nome">Nome do Professor</label>
            <input type="text" name="nome" class="form-control" placeholder="Digite o nome do professor" required />
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-primary btn-lg btn-block">Adicionar</button>
        </div>
    </form>
</div>
<%@include file="components/footer.jsp" %>