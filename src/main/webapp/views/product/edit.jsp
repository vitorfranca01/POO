<div class="modal fade" id="editProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Alterar Produto</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
            <form class="form-horizontal" method="post" action="EditProduct">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label>Nome</label>
                        <input class="form-control" placeholder="Nome" name="name" required/>
                    </div>
                    <div class="form-group col-md-6">
                        <label>Marca</label>
                        <input class="form-control" placeholder="Marca" name="brand" />
                    </div>
                    <div class="form-group col-md-6">
                        <label>Descrição</label>
                        <textarea class="form-control" rows="8" placeholder="Descreva o produto.." name="description"></textarea>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label>Quantidade</label>
                            <input class="form-control" value="1" placeholder="Quantidade" name="amount" />
                        </div>
                        <div class="form-group">
                            <label>Preço</label>
                            <input type="text" class="form-control" placeholder="R$ 9,90" name="price"/>
                        </div>
                    </div>
                </div>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button type="submit" class="btn btn-primary">Alterar</button>
            </form>
        </div>
    </div>
  </div>
</div>