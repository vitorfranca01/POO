<%-- 
    Document   : index
    Created on : 14/05/2018, 00:43:16
    Author     : Beto
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="models.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../includes/header.jsp" %>
        <title>Gerenciamento de Vendas</title>
    </head>
    <body>
        <%@include file="../../includes/navbar.jsp" %>
        <input type="text" hidden=""/>
        <div class="container">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createSaleModal">
                Fazer uma Venda
            </button>
            <table class="table">
                <tr>
                    <th>Nome</th>
                    <th>CPF</th>
                    <th>Data de Criação</th>
                </tr>
                <c:forEach items="${sales}" var="sale">               
                <tr>
                    <td>${sale.name}</td>
                    <td>${sale.cpf}</td>
                    <td>${sale.creationDate}</td>
                    <td>
                        <button class="btn btn-success">Editar</button>
                        <a href="RemoveSale?id=${sale.id}" class="btn btn-danger btnDelete">Deletar</a>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <%@include file="create.jsp" %>
        <%@include file="../../includes/footer.jsp" %>
    </body>
</html>

