<%-- 
    Document   : create
    Created on : 14/05/2018, 06:02:43
    Author     : Beto
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="models.Product"%>
<div class="modal fade" id="createSaleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Venda</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <form class="form-horizontal" method="post" action="CreateUser">
                <div class="form-row">
                    <div class="form-group col-md-12">
                        <label>produtos:</label>
                        <div>                            
                           <table class="table">
                                <tr>
                                    <th>Nome</th>
                                    <th>Preço</th>
                                </tr>
                                <c:forEach items="${products}" var="product">               
                                    <tr>
                                        <td>${product.name}</td>
                                        <td>${product.price}</td>
                                        <td>
                                            <button class="btn btn-success">Adicionar</button>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Total</label>
                        <input class="form-control" placeholder="Cpf" name="cpf" />
                    </div>
                </div>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary">Fechar Compra</button>
            </form>
        </div>
    </div>
  </div>
</div>
