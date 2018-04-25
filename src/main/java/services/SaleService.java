package services;

import java.util.ArrayList;
import models.Sale;
import repositories.SalesRepository;

/**
 *
 * @author Vitor
 */
public class SaleService {
    private static ArrayList<Sale> sales = new ArrayList<Sale>();
    private static SalesRepository repository = new SalesRepository();

//criar validação de venda
    
    public static void insert (Sale sale){
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
    
    public static ArrayList<Sale> getAll (){
        try {
            return repository.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static Sale getById (int id) {
        try {
            return repository.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
