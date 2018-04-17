/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.User;

/**
 *
 * @author Yuri PC
 */
public class UserService {
    private static ArrayList<User> users = new ArrayList<User>();
        
    public static User authenticate (String cpf, String password){
        users.add(new User("Yuri", "123.456.789-10", "123456"));
        User user = findByCpf(cpf);
        
        if(user != null && user.getPassword().equals(password))
            return user;
        
        return null;
    }
    
    public static User findByCpf (String cpf){
        for(User user : users){
            if(user.getCpf().equals(cpf))
                return user;
        }
        return null;
    }
    
    public static User findById (int id){
        for(User user : users){
            if(user.getId() == id)
                return user;
        }
        return null;
    }
    
    public static void insert (User user){
        users.add(user);
    }
    
    public static void remove(int id){
        User user = findById(id);
        
        if(user != null)
            users.remove(user);
    }
}
