<%-- 
    Document   : create
    Created on : 14/05/2018, 06:02:43
    Author     : Beto
--%>
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
                    <div class="form-group col-md-6">
                        <label>Funcionarios:</label>
                        <div>                            
                           <%-- <c:forEach items="${products}" var="product">               
                                <tr>
                                    <td>${user.name}</td>
                                    <td>${user.cpf}</td>
                                    <td>${user.creationDate}</td>
                                    <td>
                                        <a href="RemoveUser?id=${product.id}" class="btn btn-danger btnDelete">Deletar</a>
                                    </td>
                                </tr>
                            </c:forEach> --%>
                        </div>
                        <input class="form-control" placeholder="Nome" name="name" required/>
                    </div>
                    <div class="form-group col-md-6">
                        <label>CPF</label>
                        <input class="form-control" placeholder="Cpf" name="cpf" />
                    </div>
                    <div class="form-group col-md-6">
                        <label>Senha</label>
                        <input class="form-control" placeholder="Password" name="password" />
                    </div>
                </div>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </div>
  </div>
</div>
