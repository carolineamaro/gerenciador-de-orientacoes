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
        <style>
            main{
                margin-top: 50px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <div class="container">
    <a class="navbar-brand" href="professor">Gerenciador</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="professor-drop" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Professor</a>
                <div class="dropdown-menu" aria-labelledby="professor-drop">
                    <a class="dropdown-item" href="professor">Todos professores</a>
                    <a class="dropdown-item" href="professor-novo">Novo professor</a>

                </div>
            </li>

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="orientacao-drop" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Orientação</a>
                <div class="dropdown-menu" aria-labelledby="orientacao-drop">
                    <a class="dropdown-item" href="orientacao">Todas orientações</a>
                    <a class="dropdown-item" href="orientacao-novo">Nova orientação</a>

                </div>
            </li>
        </ul>
    </div>
    </div>
</nav>
        <main role="main" class="container">
