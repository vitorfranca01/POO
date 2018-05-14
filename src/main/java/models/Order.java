package models;

import java.util.ArrayList;

/**
 *
 * @author Vitor
 */
public class Order extends BaseEntity {
        
    private double total;
    private String client;
    private ArrayList<OrderItem> itens;
    private User user;
    
    public Order(){
    }
    
    public void addItem(OrderItem item){
        itens.add(item);
    }
    
    public void removeItem(OrderItem item){
        itens.remove(item);
    }

    public double getValorTotal() {
        return total;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
