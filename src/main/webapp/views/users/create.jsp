<div class="modal fade" id="createUserModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Cadastrar Funcionario</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <form class="form-horizontal" method="post" action="UserManager">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Nome</label>
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
                    <div class="form-group col-md-6">
                        <label>Filial</label>
                        <select class="form-control" name="subsidiary">
                            <option value="0">Selecione uma filia..</option>
                            <option value="1">S�o Paulo</option>
                            <option value="2">Recife</option>
                        </select>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Grupo</label>
                        <select class="form-control" name="group">
                            <option value="0">Selecione um grupo..</option>
                            <option value="1">Vendedor</option>
                            <option value="2">Gerente</option>
                        </select>
                    </div>
                </div>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary">Cadastrar</button>
            </form>
        </div>
    </div>
  </div>
</div>