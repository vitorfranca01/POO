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
    
    public static Product getById (int id) {
        for(Product product : products) {
            if(product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
