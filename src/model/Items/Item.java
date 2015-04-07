/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.items;

/**
 *
 * @author darien
 */
public abstract class Item {
    
    private String name;
    public Item(String name){
        
        this.name = name;
    }
    
    public String getName(){
        
        return name;
    }
}
