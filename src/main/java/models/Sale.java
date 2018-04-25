package models;

/**
 *
 * @author Vitor
 */
public class Sale extends BaseEntity {
    private double valorTotal;
    private int qtdProdutos;
    private int metodoPag;
    private String cliente; //CPF ou CNPJ

    public Sale(double valorTotal, int qtdProdutos, int metodoPag, String cliente){
        this.valorTotal = valorTotal;
        this.qtdProdutos = qtdProdutos;
        this.metodoPag = metodoPag;
        this.cliente = cliente;
    }

    public Sale() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getQtdProdutos() {
        return qtdProdutos;
    }

    public void setQtdProdutos(int qtdProdutos) {
        this.qtdProdutos = qtdProdutos;
    }

    public int getMetodoPag() {
        return metodoPag;
    }

    public void setMetodoPag(int métodoPag) {
        this.metodoPag = métodoPag;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    
}
