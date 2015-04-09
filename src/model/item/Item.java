/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.item;

import model.entity.Avatar;
import model.entity.Occupation;

public abstract class Item {
    
    private String name;
    private int value;
    // TODO: Items have stats potentially;

    public Item(String name, int value){
        
        this.name = name;
        this.value = value;
    }
    
    public String getName(){
        
        return name;
    }

    public int getValue() {
        return value;
    }

    public abstract boolean use(Occupation occupation);

    public abstract boolean touch(Avatar avatar);
}
