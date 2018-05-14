<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../includes/header.jsp" %>
        <title>Gerenciamento de Produtos</title>
    </head>
    <body>
        <%@include file="../../includes/navbar.jsp" %>
        <input type="text" hidden=""/>
        <div class="container">
            <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#createProductModal">
                Cadastrar novo produto
            </button>
            <table class="table">
                <tr>
                    <th>Cod. Produto</th>
                    <th>Produto</th>
                    <th>Marca</th>
                    <th>Valor Compra</th>
                    <th>Quantidade</th>
                    <th>Ações</th>
                </tr>
                <c:forEach items="${products}" var="product">               
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td>${product.brand}</td>
                    <td>R$ ${product.price}</td>
                    <td>${product.amount}</td>
                    <td>
                        <button class="btn btn-success">Editar</button>
                        <button type="button" data-id="${product.id}" class="btn btn-danger btnDelete">Deletar</button>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <%@include file="create.jsp" %>
        <%@include file="../../includes/footer.jsp" %>
        <script>
        $(".btnDelete").click(function(){
            var id = $(this).data("id");
            $.ajax({
                url: "RemoveProduct?id=" + id,
                method: "GET",
                success: function(result) {
                    bootbox.alert("Ola");
                },
                error: function(){
                    alert("deeu ruim")
                }
            });
        });
        </script>
    </body>
</html>
