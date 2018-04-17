/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.ArrayList;
import models.Product;

/**
 *
 * @author Yuri PC
 */
public class ProductService {
    private static ArrayList<Product> products = new ArrayList<Product>();
    
    public static Product validarCadastro (int id, String name, String brand, double price, String description){
       //products.add(new Product(1, "produto", "marca", "preco", "descricao"));
        Product product = getById(1);
        //validar produto
        if(product != null && product.getId() == 1)
            return product;
        return null;
    }
    
    
    public static void insert (Product product){
        products.add(product);
    }
    
    public static boolean remove (int id){
        for(Product product : products) {
            if(product.getId() == id) {
                products.remove(product);
                return true;
            }
        }
        return false;
    }
    
    public static ArrayList<Product> getAll (){
        return products;
    }
    
    public static Product getByName (String name) {
        for(Product product : products) {
            if(product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
    
    public static Product getById (int id) {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
