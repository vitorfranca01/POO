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
import models.User;

/**
 *
 * @author Vitor
 */
public class UserRepository extends BaseRepository {

    public void insert(User user) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO \"User\" (Name, Cpf, Password, CreationDate) VALUES (?,?,?,?)")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getCpf());
            stmt.setString(3, user.getPassword());
            GregorianCalendar cal = new GregorianCalendar(1992, 10, 5); // 5 de novembro de 1992  
            stmt.setDate(4, new java.sql.Date(cal.getTimeInMillis()));
            
            int status = stmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    public void update(User user) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE User SET Name = ?, Cpf = ?, Password = ? WHERE Id = ?")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getCpf());
            stmt.setString(3, user.getPassword());
            //stmt.setDate(4, user.getDate());
            stmt.setInt(4, user.getId());

            int status = stmt.executeUpdate();
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    public void remove(int id) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "DELETE FROM User WHERE Id = ?")) {
            stmt.setInt(1, id);

            int status = stmt.executeUpdate();
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }
    }

    public User getById(int id) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, Name, Cpf, Password FROM \"User\" WHERE Id = " + id);
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                User user = new User();

                user.setId(resultados.getInt("Id"));
                user.setName(resultados.getString("Name"));
                user.setCpf(resultados.getString("Cpf"));
                user.setPassword(resultados.getString("Password"));
                //user.setCreationDate(resultados.getDate("Date"));

                return user;
            }
        }
        return null;
    }
    
    public User getByCPF(String cpf) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT Id, Name, Cpf, Password FROM \"User\" WHERE CPF = '" + cpf + "'");

            ResultSet resultados = stmt.executeQuery();
                
            while (resultados.next()) {
                User user = new User();

                user.setId(resultados.getInt("Id"));
                user.setName(resultados.getString("Name"));
                user.setCpf(resultados.getString("Cpf"));
                user.setPassword(resultados.getString("Password"));
                //user.setCreationDate(resultados.getDate("Date"));

                return user;
            }
        } catch (Exception e) {
            
        }
        return null;
    }

    public ArrayList<User> getAll() throws ClassNotFoundException, SQLException {
        ArrayList<User> users = new ArrayList<User>();

        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "SELECT Id, Name, Cpf FROM \"User\"");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                User user = new User();

                user.setId(resultados.getInt("Id"));
                user.setName(resultados.getString("Name"));
                user.setCpf(resultados.getString("Cpf"));
                //user.setDate(resultados.getDate("Date"));

                users.add(user);
            }
        }
        return users;
    }

}
