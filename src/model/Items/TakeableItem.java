/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.items;

import model.inventory.EquippedInventoryManager;

/**
 *
 * @author darien
 */
public abstract class TakeableItem extends Item{
    
    
    public TakeableItem(String name){
        
        super(name);
    }
    
    public abstract  boolean accept(EquippedInventoryManager eim);
}
