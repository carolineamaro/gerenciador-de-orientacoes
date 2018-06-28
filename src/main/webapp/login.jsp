<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gerenciador de Orientação</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>

        <link rel="stylesheet" href="https://getbootstrap.com/docs/4.0/examples/floating-labels/floating-labels.css" />
        <form class="form-signin" action="login" method="post">
            <div class="text-center mb-4">
                <h1 class="h3 mb-3 font-weight-normal">Gerenciador de Orientações</h1>
            </div>

            <% if (request.getAttribute("erro") != null) {%> 
            <div class="alert alert-danger" role="alert">
                <%= request.getAttribute("erro")%>
            </div>
            <% }%> 


            <div class="form-label-group">
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Seu e-mail" required autofocus>
                <label for="inputEmail">Seu e-mail</label>
            </div>

            <div class="form-label-group">
                <input type="password" name="senha" id="inputPassword" class="form-control" placeholder="Sua senha" required>
                <label for="inputPassword">Sua senha</label>
            </div>


            <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
        </form>
    </body>
</html>