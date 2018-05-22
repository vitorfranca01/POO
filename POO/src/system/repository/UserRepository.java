package system.repository;

import contracts.IRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                        "INSERT INTO ROOT.\"USER\" (Name, Cpf, salario) VALUES (?,?,?)")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getCpf());
            stmt.setFloat(3, user.getSalario());
          
            int status = stmt.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void update(User user) {
        try (Connection conn = getConnection();
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE ROOT.\"USER\" SET Name = ?, Cpf = ?, Salario = ?")) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getCpf());
            stmt.setFloat(3, user.getSalario());

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
    
    public User getByCPF(String cpf) throws ClassNotFoundException, SQLException {
        try (Connection conn = getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT Id, Name, Cpf, Salario FROM \"USER\" WHERE CPF = '" + cpf + "'");

            ResultSet resultados = stmt.executeQuery();
                
            while (resultados.next()) {
                User user = new User();

                user.setId(resultados.getInt("Id"));
                user.setName(resultados.getString("Name"));
                user.setCpf(resultados.getString("Cpf"));
                user.setSalario(resultados.getFloat("Salario"));


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
                        "SELECT Id, Name, Cpf, Salario FROM ROOT.\"USER\"");
                ResultSet resultados = stmt.executeQuery()) {

            while (resultados.next()) {
                User user = new User();

                user.setId(resultados.getInt("Id"));
                user.setName(resultados.getString("Name"));
                user.setCpf(resultados.getString("Cpf"));
                user.setSalario(resultados.getFloat("Salario"));

                users.add(user);
            }
        }
        return users;
    }
}
