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
public class ProductRepository {
    
    private Connection getConnection() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");
        
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/SupermercadoAstec", "root", "");
        return conn;
    }
    
    public void insert(Product product) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO Product (Name, Description, Price) VALUES (?,?,?)")) {
            stmt.setString(1, product.getName());
            //GregorianCalendar cal = new GregorianCalendar(1992, 10, 5); // 5 de novembro de 1992  
            //stmt.setDate(2, new java.sql.Date(cal.getTimeInMillis()));
            stmt.setString(2, "");
            stmt.setDouble(3, product.getPrice());
            
            int status = stmt.executeUpdate();
        }
    }

    public void update(BaseEntity entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public BaseEntity getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
