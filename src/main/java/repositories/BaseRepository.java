/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Yuri PC
 */
public abstract class BaseRepository {
        
    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        // 1A) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("org.apache.derby.jdbc.ClientDriver");
        
        Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Store", "root", "root");
        return conn;
    }
}
