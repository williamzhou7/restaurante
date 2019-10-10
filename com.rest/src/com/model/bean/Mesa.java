/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author willi
 */
@Entity
public class Mesa {

    @Id
    private Integer nome_mesa;

    public Integer getNome_mesa() {
        return nome_mesa;
    }

    public void setNome_mesa(Integer nome_mesa) {
        this.nome_mesa = nome_mesa;
    }

    @Override
    public String toString() {
        return nome_mesa.toString();
    }
    


    
     
    
    
}
