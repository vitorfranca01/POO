/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.Product;
import repositories.ProductRepository;

/**
 *
 * @author Yuri PC
 */
public class ProductService {
    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ProductRepository repository = new ProductRepository();
    
    public static Product validarCadastro (int id, String name, String brand, double price, String description){
        //products.add(new Product(1, "produto", "marca", "preco", "descricao"));
        Product product = getById(1);
        //validar produto
        if(product != null && product.getId() == 1)
            return product;
        return null;
    }
    
    
    public static void insert (Product product){
        try {
            repository.insert(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void update (Product product){
        try {
            repository.update(product);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static boolean remove (int id){
        try {
            repository.remove(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public static ArrayList<Product> getAll (){
        try {
            return repository.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static Product getById (int id) {
        try {
            return repository.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
