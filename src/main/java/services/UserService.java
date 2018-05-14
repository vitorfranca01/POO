/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import models.User;
import repositories.UserRepository;

/**
 *
 * @author Yuri PC
 */
public class UserService {
    private static ArrayList<User> users = new ArrayList<User>();
    private static UserRepository repository = new UserRepository();
    
    public static boolean isLogged (HttpSession session){
        if(session.getAttribute("UserId") != null)
            return true;
        return false;
    }
    
    public static boolean hasPermission (int userId, String permissionName){
        return true;
    }
    
    public static User authenticate (String cpf, String password){
        User user = findByCpf(cpf);
        
        if(user != null && user.getPassword().equals(password))
            return user;
        
        return null;
    }
    
    public static User findByCpf (String cpf){
        try {
            return repository.getByCPF(cpf);
        } catch (Exception e) {
        }
        return null;
    }
    
    public static User findById (int id){
        try {
            return repository.getById(id);
        } catch (Exception e) {
        }
        return null;
    }
    
    public static User findByName (String name){
        for(User user : users){
            if(user.getName().equals(name))
                return user;
        }
        return null;
    }
    
    public static void insert (User user){
        try {
            repository.insert(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void remove(int id){
        User user = findById(id);
        
        if(user != null)
            users.remove(user);
    }
    
    public static ArrayList<User> getAll(){
        try {
            return repository.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
