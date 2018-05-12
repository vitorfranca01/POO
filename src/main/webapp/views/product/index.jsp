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
            <table class="table">
                <tr>
                    <th>Cod. Produto</th>
                    <th>Produto</th>
                    <th>Marca</th>
                    <th>Valor Compra</th>
                    <th>Valor Venda</th>
                    <th>Ações</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Bolacha</td>
                    <td>Trakinass</td>
                    <td>R$ 1,00</td>
                    <td>R$ 1,49</td>
                    <td>
                        <button class="btn btn-success">Editar</button>
                        <a href="Product?action=remove&id=1" class="btn btn-danger btnDelete">Deletar</a>
                    </td>
                </tr>
            </table>
        </div>
        <%@include file="../../includes/footer.jsp" %>
    </body>
</html>
