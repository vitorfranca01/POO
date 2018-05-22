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
public class User extends BaseEntity {
    private String name;
    private String cpf;  
    private float salario;
    
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float salario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }
}