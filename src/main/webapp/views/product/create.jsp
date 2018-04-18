<%@page import="models.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../includes/header.jsp" %>
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <%@include file="../../includes/navbar.jsp" %>
        <input type="text" hidden=""/>
        <div class="container">
            <form class="form-horizontal" method="post" action="Product?action=create">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Nome</label>
                        <input class="form-control" placeholder="Nome" name="name"/>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Marca</label>
                        <input class="form-control" placeholder="Marca" name="brand" />
                    </div>
                    <div class="form-group col-md-6">
                        <label>Descrição</label>
                        <textarea class="form-control" rows="8" placeholder="Descreva o produto.." name="descricao"></textarea>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Quantidade</label>
                            <input class="form-control" value="1" placeholder="Quantidade" />
                        </div>
                        <div class="form-group">
                            <label>Valor venda</label>
                            <input class="form-control" placeholder="R$ 9,90" name="valorvenda"/>
                        </div>
                        <div class="form-group">
                            <label>Valor compra</label>
                            <input class="form-control" placeholder="R$ 9,90" name="valorcompra"/>
                        </div>
                    </div>
                </div>
                <button type="submit" class="btn btn-primary">Salvar</button>
                <button type="reset" class="btn btn-default">Limpar</button>
            </form>
            <br>
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
