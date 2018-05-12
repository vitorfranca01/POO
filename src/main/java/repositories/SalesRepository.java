package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Sale;

/**
 *
 * @author Vitor
 */
public class SalesRepository extends BaseRepository {
    
    public void insert(Sale sale) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO Sale (valorTotal, qtdProdutos, metodoPag, cliente) VALUES (?,?,?,?)")) {
            stmt.setDouble(1, sale.getValorTotal());
            stmt.setInt(2, sale.getQtdProdutos());
            stmt.setInt(3, sale.getMetodoPag());
            stmt.setString(4, sale.getCliente());
            
            int status = stmt.executeUpdate();
        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    public void update(Sale sale) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE Sale SET valorTotal = ?, qtdProdutos = ?, metodoPag = ?, cliente = ? WHERE Id = ?")) {
            stmt.setDouble(1, sale.getValorTotal());
            stmt.setInt(2, sale.getQtdProdutos());
            stmt.setInt(3, sale.getMetodoPag());
            stmt.setString(4, sale.getCliente());
            
            int status = stmt.executeUpdate();
        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    public void remove(int id) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM Sale WHERE Id = ?")) {
            stmt.setInt(1, id);
            
            int status = stmt.executeUpdate();
        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    public Sale getById(int id) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, valorTotal, qtdProdutos, metodoPag, cliente FROM Sale WHERE Id = ?");
                ResultSet resultados = stmt.executeQuery()) {
            
            stmt.setInt(1, id);
            
            while (resultados.next()) {
                Sale sale = new Sale();
                
                sale.setId(resultados.getInt("Id"));
                sale.setValorTotal(resultados.getDouble("valorTotal"));
                sale.setQtdProdutos(resultados.getInt("QtdProdutos"));
                sale.setMetodoPag(resultados.getInt("MetodoPag"));
                sale.setCliente(resultados.getString("cliente"));
                
                return sale;
            }
        }        
        return null;
    }

    public ArrayList<Sale> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Sale> sales = new ArrayList<Sale>();
        
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, valorTotal, qtdProdutos, metodoPag, cliente FROM Sale");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                Sale sale = new Sale();
                
                sale.setId(resultados.getInt("Id"));
                sale.setValorTotal(resultados.getDouble("valorTotal"));
                sale.setQtdProdutos(resultados.getInt("QtdProdutos"));
                sale.setMetodoPag(resultados.getInt("MetodoPag"));
                sale.setCliente(resultados.getString("cliente"));
                
                sales.add(sale);
            }
        }        
        return sales;
    }
    
}
