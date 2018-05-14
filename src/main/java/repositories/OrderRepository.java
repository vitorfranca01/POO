package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Order;

/**
 *
 * @author Vitor
 */
public class OrderRepository extends BaseRepository {
    
    public void insert(Order order) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO Order (valorTotal, qtdProdutos, metodoPag, cliente) VALUES (?,?,?,?)")) {
            stmt.setDouble(1, order.getValorTotal());
            
            int status = stmt.executeUpdate();
        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    public void update(Order sale) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE Sale SET valorTotal = ?, qtdProdutos = ?, metodoPag = ?, cliente = ? WHERE Id = ?")) {
            stmt.setDouble(1, sale.getValorTotal());
            
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

    public Order getById(int id) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, valorTotal, qtdProdutos, metodoPag, cliente FROM Sale WHERE Id = ?");
                ResultSet resultados = stmt.executeQuery()) {
            
            stmt.setInt(1, id);
            
            while (resultados.next()) {
                /*Order sale = new Order();
                
                sale.setId(resultados.getInt("Id"));
                sale.setValorTotal(resultados.getDouble("valorTotal"));
                sale.setQtdProdutos(resultados.getInt("QtdProdutos"));
                sale.setMetodoPag(resultados.getInt("MetodoPag"));
                sale.setCliente(resultados.getString("cliente"));
                
                return sale;*/
            }
        }        
        return null;
    }

    public ArrayList<Order> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Order> sales = new ArrayList<Order>();
        
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, valorTotal, qtdProdutos, metodoPag, cliente FROM Sale");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                /*Order sale = new Order();
                
                sale.setId(resultados.getInt("Id"));
                sale.setValorTotal(resultados.getDouble("valorTotal"));
                sale.setQtdProdutos(resultados.getInt("QtdProdutos"));
                sale.setMetodoPag(resultados.getInt("MetodoPag"));
                sale.setCliente(resultados.getString("cliente"));
                
                sales.add(sale);*/
            }
        }        
        return sales;
    }
    
}
