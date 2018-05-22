/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.models;

/**
 *
 * @author Vitor
 */
public abstract class BaseEntity {
    private int id;
    
    public int getId (){
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
}

