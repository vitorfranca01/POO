<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../includes/header.jsp" %>
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="../../includes/navbar.jsp" %>
        <div class="container">
            <h1>Bem-vindo(a), ${sessionScope.username}</h1>
        </div>
        <%@include file="../../includes/footer.jsp" %>
    </body>
</html>
