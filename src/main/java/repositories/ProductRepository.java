/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import contracts.IRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import models.BaseEntity;
import models.Product;

/**
 *
 * @author yuri.jwsilva
 */
public class ProductRepository extends BaseRepository {
    
    public void insert(Product product) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO Product (Name, Description, Price) VALUES (?,?,?)")) {
            stmt.setString(1, product.getName());
            //GregorianCalendar cal = new GregorianCalendar(1992, 10, 5); // 5 de novembro de 1992  
            //stmt.setDate(2, new java.sql.Date(cal.getTimeInMillis()));
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            
            int status = stmt.executeUpdate();
        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    public void update(Product product) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE Product SET Name = ?, Description = ?, Price = ? WHERE Id = ?")) {
            stmt.setString(1, product.getName());
            //GregorianCalendar cal = new GregorianCalendar(1992, 10, 5); // 5 de novembro de 1992  
            //stmt.setDate(2, new java.sql.Date(cal.getTimeInMillis()));
            stmt.setString(2, product.getDescription());
            stmt.setDouble(3, product.getPrice());
            stmt.setInt(4, product.getId());
            
            int status = stmt.executeUpdate();
        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    public void remove(int id) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM Product WHERE Id = ?")) {
            stmt.setInt(1, id);
            
            int status = stmt.executeUpdate();
        } catch (Exception e){
            System.err.print(e.getMessage());
        }
    }

    public Product getById(int id) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, Name, Description, Price FROM Product WHERE Id = ?");
                ResultSet resultados = stmt.executeQuery()) {
            
            stmt.setInt(1, id);
            
            while (resultados.next()) {
                Product product = new Product();
                
                product.setId(resultados.getInt("Id"));
                product.setName(resultados.getString("Name"));
                product.setPrice(resultados.getDouble("Price"));
                
                return product;
            }
        }        
        return null;
    }

    public ArrayList<Product> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<Product> products = new ArrayList<Product>();
        
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, Name, Description, Price FROM Product");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                Product product = new Product();
                
                product.setId(resultados.getInt("Id"));
                product.setName(resultados.getString("Name"));
                product.setPrice(resultados.getDouble("Price"));
                
                products.add(product);
            }
        }        
        return products;
    }
    
}
