package services;

import java.util.ArrayList;
import models.Order;
import repositories.OrderRepository;

/**
 *
 * @author Vitor
 */
public class SaleService {
    private static ArrayList<Order> sales = new ArrayList<Order>();
    private static OrderRepository repository = new OrderRepository();

//criar validação de venda
    
    public static void insert (Order sale){
        try {
            repository.insert(sale);
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
    
    public static ArrayList<Order> getAll (){
        try {
            return repository.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static Order getById (int id) {
        try {
            return repository.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
