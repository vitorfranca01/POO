<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../includes/header.jsp" %>
        <title>Login no Supermercado Astec</title>
        <style>
            .form-signin {
                width: 330px;
                margin: 80px auto;
            }
        </style>
    </head>
    <body class="text-center">
        <div class="container">
            <form class="form-signin" method="post" action="Login">
                <h1>Supermercados Astec</h1>
                <h3>Por favor, entre.</h3>
                <div class="form-group">
                    <label>CPF:</label>
                    <input type="text" name="cpf" class="form-control" placeholder="123.456.789-10" />
                </div>
                <div class="form-group">
                    <label>Senha:</label>
                    <input type="password" name="password" class="form-control" />
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" />
                    <label>Lembrar-me meu acesso</label>
                </div>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>
            </form>
            <span class="alert alert-danger">
                Erro
            </span>
        </div>
    </body>
</html>
