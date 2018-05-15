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
            <span class="alert alert-danger" style="display:none" id="alert"></span>
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
                        <button type="button" data-id="${product.id}" class="btn btn-success btnEdit">Editar</button>
                        <button type="button" data-id="${product.id}" class="btn btn-danger btnDelete">Deletar</button>
                    </td>
                </tr>
                </c:forEach>
            </table>
        </div>
        <%@include file="create.jsp" %>
        <%@include file="edit.jsp" %>
        <%@include file="../../includes/footer.jsp" %>
        <script>
        $(".btnDelete").click(function(){
            var id = $(this).data("id");
            
            bootbox.confirm({
                title: "Remover produto",
                message: "Você quer mesmo remover este produto?",
                buttons: {
                    confirm: {
                        label: 'Confirmar',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: 'Cancelar',
                        className: 'btn-default'
                    }
                },
                callback: function(result){
                    if (result != 1)
                        return;
                    $.ajax({
                        url: "RemoveProduct?id=" + id,
                        method: "GET",
                        success: function(result) {
                            var row = $(this).parent().parent();
                            $("#alert").removeClass("alert-danger").addClass("alert-success");
                            $("#alert").text("Removido com sucesso!").show();
                            row.remove();
                        },
                        error: function(){
                            $("#alert").removeClass("alert-success").addClass("alert-danger");
                            $("#alert").text("Ocorreu um erro ao remover o produto!").show();
                        }
                    });
                }
            });
            
        });
        
    $(".btnEdit").click(function(){
            var id = $(this).data("id");
            $.ajax({
                url: "EditProduct?id=" + id,
                method: "GET",
                success: function(result){
                    debugger;
                    $("#editProductModal").modal('show');
                },
                error: function() {
                }
            });
        });
        </script>
    </body>
</html>
