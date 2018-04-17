<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../includes/header.jsp" %>
        <title>Cadastro de Produtos</title>
    </head>
    <body>
        <%@include file="../../includes/navbar.jsp" %>
        <div class="container">
            <form class="form-horizontal">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Nome</label>
                        <input class="form-control" placeholder="Nome" />
                    </div>
                    <div class="form-group col-md-6">
                        <label>Marca</label>
                        <input class="form-control" placeholder="Marca" />
                    </div>
                    <div class="form-group col-md-6">
                        <label>Descrição</label>
                        <textarea class="form-control" rows="8" placeholder="Descreva o produto.."></textarea>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Quantidade</label>
                            <input class="form-control" value="1" placeholder="Quantidade" />
                        </div>
                        <div class="form-group">
                            <label>Valor venda</label>
                            <input class="form-control" placeholder="R$ 9,90" />
                        </div>
                        <div class="form-group">
                            <label>Valor compra</label>
                            <input class="form-control" placeholder="R$ 9,90" />
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
                        <button class="btn btn-danger">Deletar</button>
                    </td>
                </tr>
            </table>
        </div>
        <%@include file="../../includes/footer.jsp" %>
    </body>
</html>
