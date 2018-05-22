package system.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vitor
 */
public abstract class BaseRepository {

    protected Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.ClientDriver");//alterar caminho

        Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/Store", "root", "root");//alterar caminho
        return conn;
    }
}
