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
            <form class="form-signin">
                <h1>Supermercados Astec</h1>
                <h3>Por favor, entre.</h3>
                <div class="form-group">
                    <label>Email:</label>
                    <input type="email" class="form-control" placeholder="example@example.com" />
                </div>
                <div class="form-group">
                    <label>Senha:</label>
                    <input type="password" class="form-control" />
                </div>
                <div class="form-check">
                    <input type="checkbox" class="form-check-input" />
                    <label>Lembrar-me meu acesso</label>
                </div>
                <button type="submit" class="btn btn-lg btn-primary btn-block">Entrar</button>
            </form>
        </div>
    </body>
</html>
